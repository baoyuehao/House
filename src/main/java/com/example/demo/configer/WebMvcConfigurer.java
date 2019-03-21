package com.example.demo.configer;

import com.example.demo.controller.interceptor.OneInterceptor;
import com.example.demo.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 该配置类用户注册mvc拦截器，拦截对应的请求
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
													 .addPathPatterns("/one/**");
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
		
		super.addInterceptors(registry);
	}

	/**
	 * 自定义静态资源访问路径
	 * @param registry
	 */
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//		if(!registry.hasMappingForPattern("/static/**")){
//			registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//		}
//		super.addResourceHandlers(registry);
//	}

}
