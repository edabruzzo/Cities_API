package br.com.digitalinnovation.abruzzo.project_cities_api.config;

import br.com.digitalinnovation.abruzzo.project_cities_api.services.StringToEnumEarthRadiusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMVCInterceptorsConfig implements WebMvcConfigurer {

    @Autowired
    LoggerInterceptor loggerInterceptor;

    @Autowired
    StringToEnumEarthRadiusConverter enumConverter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(enumConverter);
    }

}
