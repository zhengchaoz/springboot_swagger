package com.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 郑超
 * @date 2021-05-14 20:40
 */
@Configuration
//@EnableSwagger2
@EnableOpenApi
public class SwaggerConfig {

//    @Value("${swagger2.enable}") 从配置环境中决定是否启用swagger
//    private boolean enable = false;

    // 完成了swagger的bean配置
    @Bean
//    @Profile("dev")
    public Docket docket(Environment environment) {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo())
//                .groupName("郑超")// 分组，配置多个Docket的@bean就可实现多人写作开发
//                .enable(enable) 禁用swagger
                .select()
                // 配置要扫描接口的方式
                // basePackage()扫描包；any()全部扫描；none()都不扫描；with[Class/Method]Annotation()扫描类或方法上的注解；
                .apis(RequestHandlerSelectors.basePackage("com.swagger.controller"))
                // 过滤什么路径，只有/login路径下的请求才会被扫描
//                .paths(PathSelectors.ant("/login"))
                .build();
    }

    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("郑超", "http://zhengchao.com", "1258954785@qq.com");
        return new ApiInfo("郑超测试swagger", "测试描述信息", "1.0",
                "http://www.baidu.com", contact, "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
