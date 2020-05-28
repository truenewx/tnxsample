package org.truenewx.tnxsample.admin.web.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.core.version.VersionReader;
import org.truenewx.tnxsample.admin.web.api.controller.IndexController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Autowired
    private VersionReader versionReader;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("admin").apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(IndexController.class.getPackageName()))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        String version = this.versionReader.getVersion();
        return new ApiInfoBuilder().version(version).build();
    }

}
