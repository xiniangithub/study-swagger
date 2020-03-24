//package com.wez.study.swagger.config;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        /**
//         *此处拦截路径（/**）
//         * 注意两个**。一个*号只拦截一级路径下，两个*号拦截所有
//         */
//        registry.addInterceptor(new Swagger2Interceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/rest/login.do/info")
//                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
//    }
//    
//    /**
//     * 静态资源配置(默认)
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
////        registry.addResourceHandler("/swagger/**").addResourceLocations("classpath:/static/");// 静态资源路径
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        super.addResourceHandlers(registry);
//    }
//    
//    class Swagger2Interceptor implements HandlerInterceptor {
//
//        /**
//         * 在一个请求进入Controller层方法执行前执行这个方法
//         */
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//                throws Exception {
//            //在这里可以对参数做一些预处理和做一些验证
//            return true;//方法给予执行，就是允许controller的方法进行执行
//            //false 不允许，可以在这之前在reponse中编写返回的结果
//        }
//
//        /**
//         * 返回model前
//         */
//        @Override
//        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                ModelAndView modelAndView) throws Exception {
//            //Controller执行完毕后，返回之前，可以对request和reponse进行处理
//            //如果是前后端没有分离，在进入View层中前执行
//        }
//
//        /**
//         * 返回model后
//         */
//        @Override
//        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
//                Exception ex) throws Exception {
//            //在一个请求处理完毕，即将销毁的时候，执行，可以做一些资源释放之类的工作
//        }
//        
//    }
//
//
//}
