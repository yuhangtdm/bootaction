package com.allinjava.bootaction.config;

import com.allinjava.bootaction.common.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:yuhang
 * @Date:2018/10/15
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${swagger.basePackage}")
    private String basePackage;

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     */
    @Bean
    public Docket createRestApi() {
        /**
         * 配置响应状态码
         */
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        for (HttpStatus httpStatus : HttpStatus.values()) {
            responseMessageList.add(new ResponseMessageBuilder().code(httpStatus.value()).message(httpStatus.getReasonPhrase()).build());
        }
        for (ResultEnum resultEnum : ResultEnum.values()) {
            responseMessageList.add(new ResponseMessageBuilder().code(resultEnum.getCode()).message(resultEnum.getMsg()).build());
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址(swagger原生页面)：http://项目实际地址/swagger-ui.html
     * 访问地址(bootstrap美化页面)：http://项目实际地址/doc.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBootAction接口在线测试文档")
                .description("一套springboot整合javaee全栈的项目")
                .termsOfServiceUrl("http://localhost:8801/bootAction/doc.html")
                .version("1.0")
                .contact(new Contact("yuhang","http://localhost:8801/bootAction/doc.html","649411629@qq.com"))
                .build();
    }

}
