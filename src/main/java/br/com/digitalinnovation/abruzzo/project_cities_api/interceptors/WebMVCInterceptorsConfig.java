package br.com.digitalinnovation.abruzzo.project_cities_api.interceptors;

import br.com.digitalinnovation.abruzzo.project_cities_api.services.StringToEnumEarthRadiusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCInterceptorsConfig implements WebMvcConfigurer {

    @Autowired
    LoggerInterceptor loggerInterceptor;

    @Autowired
    StringToEnumEarthRadiusConverter EnumConverter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry){
        formatterRegistry.addFormatter((Formatter<?>) EnumConverter);
    }


}
