package com.itheima.config;

/*
@Configuration
public class WebConfig implements WebMvcConfigurer {
*/
/*    @Autowired
    private DemoInterceptor demoInterceptor;*//*


    @Autowired
    private TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }
}
*/
