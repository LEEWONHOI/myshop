package leewonhoi.myshop;

import leewonhoi.myshop.web.argumentResolver.LoginMemberArgumentResolver;
import leewonhoi.myshop.web.formatter.NumberFormatter;
import leewonhoi.myshop.web.interceptor.LoginCheckInterceptor;
import leewonhoi.myshop.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginMemberArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/members/new", "/login", "/logout" ,"/css/**", "/*.ico", "/error");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new NumberFormatter());
    }
}
