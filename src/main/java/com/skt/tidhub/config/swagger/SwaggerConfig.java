package com.skt.tidhub.config.swagger;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    private final String swaggerScanPackate = "com.skt.tidhub";

    @Bean
    public Docket korbitApi() {
        String docVersion = "v10";
        String docTitle = "01. KORBIT API " + docVersion;
        String desc = "<b>korbit 가상자산 정보를 조회하는 api.</b><br/>"
        		+ " - 2022.07.07 : 최초작성";
        
        return new Docket(DocumentationType.SWAGGER_2)
        		.consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .groupName(docTitle)
                .apiInfo(getApiInfo(docTitle, docVersion, desc))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerScanPackate))
                .paths(PathSelectors.ant("/korbit/api/"+docVersion+"/**"))
                .build();
    }
    
    @Bean
    public Docket informationApi() {
        String docVersion = "v10";
        String docTitle = "02. INFORMATION API " + docVersion;
        String desc = "<b>고객센터 정보를 조회하는 api.</b><br/>"
        		+ " - 2022.07.07 : 최초작성";
        
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .groupName(docTitle)
                .apiInfo(getApiInfo(docTitle, docVersion, desc))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerScanPackate))
                .paths(PathSelectors.ant("/information/api/"+docVersion+"/**"))
                .build();
    }

    private ApiInfo getApiInfo(String title, String version, String desc) {
        return new ApiInfoBuilder()
                .title(title)
                .description(desc)
                .version(version)
                .build();
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.
                addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
