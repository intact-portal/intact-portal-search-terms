package uk.ac.ebi.intact.search.terms;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class TermSwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(Predicates.not(PathSelectors.regex("/")))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "IntAct Term Search REST API",
                "This API allow searching control vocabulary information in the IntAct database.",
                "API 1.0 BETA",
                "https://www.ebi.ac.uk/about/terms-of-use",
                 new Contact("IntAct", "https://www.ebi.ac.uk/intact", "intact@helpdesk.ebi.ac.uk"),
                "License of API", "https://creativecommons.org/licenses/by/4.0/", Collections.emptyList());
    }
}