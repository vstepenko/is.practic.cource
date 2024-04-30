package ua.edu.duan.students;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import ua.edu.duan.students.filter.LogFilter;

import java.util.Locale;

@Configuration
public class SpringFactory {
    @Bean
    public OpenAPI openAPI(){
        OpenAPI openAPI = new OpenAPI();

        openAPI.setInfo(new Info());
        openAPI.getInfo().setTitle("Our custom title");
        openAPI.getInfo().setDescription("Big custom description");
        return openAPI;
    }

    @Bean
    public LocaleResolver localResolver(){
        AcceptHeaderLocaleResolver lr = new AcceptHeaderLocaleResolver();
        lr.setDefaultLocale(Locale.ENGLISH);
        return lr;
    }
    @Bean
    public FilterRegistrationBean<LogFilter>  logFilterFilterRegistrationBean(){
        FilterRegistrationBean<LogFilter>  filterRegistrationBean = new FilterRegistrationBean<>();
        LogFilter logFilter = new LogFilter();
        filterRegistrationBean.setFilter(logFilter);
        return filterRegistrationBean;
    }
}
