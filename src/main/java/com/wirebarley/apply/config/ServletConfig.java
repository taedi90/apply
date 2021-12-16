package com.wirebarley.apply.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"com.wirebarley.apply"})
public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry)  {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
//        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/");
//        registry.addResourceHandler("/upload/**").addResourceLocations("/resources/upload/");
//        registry.addResourceHandler("/se2/**").addResourceLocations("/resources/se2/");
    }

}