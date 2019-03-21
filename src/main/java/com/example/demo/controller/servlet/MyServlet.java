package com.example.demo.controller.servlet;

import org.springframework.stereotype.Component;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by baoyu on 2018/12/1.
 */
@WebServlet(urlPatterns =  "/myservlet",asyncSupported = true)
//异步非阻塞请求
public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * servlet 3.0以上支持的异步非阻塞请求操作
         */
        super.doGet(req, resp);
        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(()->{
            try {
                resp.getWriter().write("哈罗 this is my servlet....");
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
