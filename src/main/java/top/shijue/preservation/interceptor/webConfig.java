package top.shijue.preservation.interceptor;/*
 * @Author: Dong
 * @DateTime: 2021/7/27 上午10:42
 * @Description: TODO 配置类
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {
    /**
     * 加载拦截器
     *
     */

    @Bean
    public IPInterceptor ipInterceptor(){
        return new IPInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
        registry.addInterceptor(ipInterceptor()).addPathPatterns("/static/js/jquery.min.js");
    }
}
