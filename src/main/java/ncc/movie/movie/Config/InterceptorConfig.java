package ncc.movie.movie.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
//@EnableWebMvc
 public class InterceptorConfig   implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/video/**").addResourceLocations("file:D:/videos/");
        registry.addResourceHandler("/imgs/**").addResourceLocations("file:D:/imgs/");
        registry.addResourceHandler("/sideshow/**").addResourceLocations("file:D:/sideshow/");
    }


    @Autowired
    AdminLoginInterceptor adminLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminLoginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/tologin","/signIn","/lblin/*","/video/**","/imgs/**","/sideshow/**","/uploadUserImgs");

    }


}