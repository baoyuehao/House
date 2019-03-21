package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.House;
import com.example.demo.pojo.Owner;
import com.example.demo.pojo.Picture;
import com.example.demo.pojo.User;
import com.example.demo.service.HouseService;
import com.example.demo.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by baoyu on 2018/12/19.
 */
@Controller
@RequestMapping("/do")
@Slf4j
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    HouseService houseService;

    @RequestMapping("/test")
    public String test(){
        return "/thymeleaf/test";
    }

    //登录页面
    @RequestMapping("/loginIn")
    public String LoginIn(ModelMap map) {
        log.info("loginin", "进入登录页面...");
        return "/thymeleaf/loginin";
    }

    //退出页面
    @RequestMapping("/loginOut")
    public String LoginOut(ModelMap map) {
        log.info("loginout", "用户退出...");
        return "redirect:/do/loginIn";
    }

    //登录验证
    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    public String CheckUser(ModelMap map, @RequestParam(value = "house_name", required = true, defaultValue = "") String house_name, @RequestParam(value = "house_password", required = true, defaultValue = "") String house_password, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        log.info("checkuser", "登录验证..." + house_name + "_" + house_password);
        System.out.println(house_name + house_password);
        User user = userService.checkUserByLoginIn(house_name, house_password);
        if (user != null) {
            map.addAttribute("login_user", user);
            request.getSession().setAttribute("login_user", user);
            return "redirect:/do/main";
        } else {
            return "redirect:/do/loginIn";
        }
    }

    @RequestMapping(value = "main")
    public String Main(ModelMap map, HttpServletResponse response, HttpServletRequest request, HttpSession session,String msg,@RequestParam(value = "page",defaultValue = "1",required = true) int page,@RequestParam(value = "owner_page",defaultValue = "1",required = true) int owner_page,@RequestParam(value = "oid",defaultValue = "0",required = true) int oid) {
        if(page<=0)
            page = 1;
        if(owner_page<=0)
            owner_page = 1;
        if(oid != 0)
            houseService.deleteOwner(oid);
        User user = (User) request.getSession().getAttribute("login_user");
        map.addAttribute("login_user", user);
        map.addAttribute("msg",msg);
        //查询房源信息
        ArrayList<House> houses = houseService.getHouses(user.getUserid(),page);
        log.info("查询到的房源信息="+JSON.toJSONString(houses));
        //查询会员信息
        ArrayList<Owner> owners = houseService.getOwnersByUserIdAndPage(user.getUserid(),owner_page);
        log.info("查询到的会员信息="+JSON.toJSONString(owners));
        map.addAttribute("owners",owners);
        //查询房源对应房主信息
        ArrayList<Owner> houses_owners = houseService.getOwnerByHouses(houses);
        //查询房源对应图片信息
        ArrayList<ArrayList<Picture>> picUrls = houseService.getPicUrlsByHouses(houses);
        map.addAttribute("picUrls",picUrls);
        map.addAttribute("houses_owners",houses_owners);
        log.info("查询到的房源数量="+houses.size()+",page="+page+",owner_page="+owner_page);
        log.info("查询到的picURI="+ JSON.toJSONString(picUrls));
        map.addAttribute("houses",houses);
        map.addAttribute("page",page);
        map.addAttribute("owner_page",owner_page);
        return "/thymeleaf/main";
    }

    @RequestMapping(value = "addHouse")
    public String addHouse(ModelMap modelMap,HttpServletRequest request,@RequestParam(value = "hid",defaultValue = "0",required = true) int hid) throws UnsupportedEncodingException {
        try {
        User user = (User) request.getSession().getAttribute("login_user");
        modelMap.addAttribute("login_user", user);
        String htitle = request.getParameter("htitle")+"";
        Double hlowestprice= Double.parseDouble(request.getParameter("hlowestprice").trim());
//        Double hhighestprice= Double.parseDouble(request.getParameter("hhighestprice").trim());
        int hlevel = Integer.parseInt(request.getParameter("hlevel").trim());
        String hage_year= request.getParameter("hage_year")+"";
        if(!hage_year.contains("年"))
            hage_year = hage_year+"年";
//        String hage_month = request.getParameter("hage_month")+"";
//        if(!hage_month.contains("月"))
//            hage_month = hage_month+"月";
//        String hage = hage_year+hage_month;
        String hage = hage_year;
        String hquality = request.getParameter("hquality")+"";
        String hsource = request.getParameter("hsource")+"";
        String hpaint= request.getParameter("hpaint")+"";
        String hvillage = request.getParameter("hvillage")+"";
        String hcreatetime = request.getParameter("hcreatetime")+"";
        Date date = new Date();
        if(hcreatetime.length()>0)
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(hcreatetime.trim());
        String htype = request.getParameter("htype")+"";
        Integer howner= Integer.parseInt(request.getParameter("howner"));
        String hdescribe = request.getParameter("hdescribe")+"";
        double hsize = Double.parseDouble(request.getParameter("hsize").trim());
            House house = new House();
            house.setHcreatetime(date);
            house.setHdescribe(hdescribe);
            house.setHhighestprice(hlowestprice);
            house.setHlastupdatetime(new Date());
            house.setHlowestprice(hlowestprice);
            house.setHowner(howner);
            house.setHtitle(htitle);
            house.setHtype(htype.trim());
            house.setHuid(user.getUserid());
            house.setHlevel(hlevel);
            house.setHage(hage);
            house.setHquality(hquality);
            house.setHsource(hsource);
            house.setHpaint(hpaint);
            house.setHvillage(hvillage);
            house.setHsize(hsize);
            if(hid == 0) {
            }else{
                house.setHid(hid);
            }
            if(houseService.addHouse(house,hid)){
                String msg = java.net.URLEncoder.encode("添加成功.", "UTF-8");
                modelMap.addAttribute("msg",msg);
                return "redirect:/do/main?msg="+msg;
            }else{
                String msg = java.net.URLEncoder.encode("添加失败，必填项不能为空.", "UTF-8");
                modelMap.addAttribute("msg",msg);
                return "redirect:/do/main?msg="+msg;
            }
        } catch (Exception e) {
            e.printStackTrace();
            String msg = java.net.URLEncoder.encode("添加失败，请检查表单内容.", "UTF-8");
            modelMap.addAttribute("msg",msg);
            return "redirect:/do/main?msg="+msg;
        }

    }

    public static String UPLOAD_PATH = "/data/suredata/house/image/upload";
    public static String PIC_URI="http://house.suredata.com.cn/do/getImage/";
    //上传图片
    @RequestMapping(value = "/addPic", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(MultipartFile image,int addPic_hid) {
        try {
            log.info("hid=" + addPic_hid);
            String name = image.getOriginalFilename();
            log.info("picName=" + name);
            InputStream inputStream = image.getInputStream();
            Path directory = Paths.get(UPLOAD_PATH);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            long copy = Files.copy(inputStream, directory.resolve(name));
            Picture picture = new Picture();
            picture.setPhid(addPic_hid);
            picture.setPname(name);
            picture.setPsize((int) copy);
            picture.setPpath(PIC_URI + name);
            picture.setPtype(name);
            houseService.addPicture(picture);
            return "上传成功，大小：" + copy + "b";
        }catch (FileAlreadyExistsException a){
            log.error(a.getMessage(), a);
            return "上传失败,图片已存在.";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "上传失败"+e.getMessage();
        }
    }
    //使用流将图片输出
    @GetMapping("/getImage/{name}")
    public void getImage(HttpServletResponse response, @PathVariable("name")String name) throws IOException {
        response.setContentType("image/jpeg;charset=utf-8");
        response.setHeader("Content-Disposition", "inline; filename=girls.png");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(Files.readAllBytes(Paths.get(UPLOAD_PATH).resolve(name)));
        outputStream.flush();
        outputStream.close();
    }

    //删除房源
    @RequestMapping(value = "/deleteHouse", method = RequestMethod.POST)
    @ResponseBody
    public String deleteHouse(@RequestParam(value = "hid",defaultValue = "0",required = true) int hid) {
        try {
            log.info("hid=" + hid);
            houseService.deleteHouse(hid);
            return "删除成功";
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            return "删除失败"+e.getMessage();
        }
    }

    //添加会员
    @RequestMapping(value = "/addOwner", method = RequestMethod.POST)
    @ResponseBody
    public String addOwner(HttpServletRequest request,@RequestParam(value = "oid",defaultValue = "0",required = true)int oid) {
        try {
            int ouserid = Integer.parseInt(request.getParameter("ouserid"));
            String oname = request.getParameter("oname").trim();
            String ophone = request.getParameter("ophone").trim();
            int osex = Integer.parseInt(request.getParameter("osex"));
            int olevel = Integer.parseInt(request.getParameter("olevel"));
            String oaddress = request.getParameter("oaddress")+"";
            String ocontent = request.getParameter("ocontent")+"";
            Owner owner = new Owner();
            owner.setOphone(ophone);
            owner.setOname(oname);
            owner.setOaddress(oaddress);
            owner.setOcontent(ocontent);
            owner.setOlevel(olevel);
            owner.setOsex(osex);
            owner.setOtelphone("");
            owner.setOuserid(ouserid);
            if(oid != 0)
                owner.setOid(oid);
            houseService.addOwner(owner,oid);
            if(oid == 0)
                return "添加成功";
            else
                return "修改成功";
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            return "添加失败"+e.getMessage();
        }
    }
}
