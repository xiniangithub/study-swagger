package com.wez.study.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean("UsersApis")
    public Docket usersApis() {
        return new Docket(DocumentationType.SWAGGER_2)
                // select()返回的是ApiSelectorBuilder对象，而非Docket对象
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                // build()返回的是Docket对象
                .build()
                // 测试API时的主机URL
//                .host("https://xiaobaiai.net")
                // API前缀
                .pathProvider(new RelativePathProvider(null) {
                    @Override
                    public String getApplicationBasePath() {
                        return "/prefix";
                    }
                })
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        // API负责人的联系信息
        final Contact contact = new Contact(
                "Ethan", "https://xiaobaiai.net", "ycm_hy@163.com");
        return new ApiInfoBuilder()
                // API文档标题
                .title("任务系统接口文档")
                // API文档描述
                .description("任务系统接口文档")
                // 服务条款URL
//                .termsOfServiceUrl("https://github.com/yicm")
                // API文档版本
                .version("2.1.0")
                // API负责人的联系信息
                .contact(contact)
                // API的许可证Url
                .licenseUrl("http://license.coscl.org.cn/MulanPSL")
                .license("MulanPSL")
                .build();
    }

}
