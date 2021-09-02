//package com.mtplatform.demo;
//
////public class SwaggerConfiguration {
////
////}
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Parameter;
//import springfox.documentation.spi.DocumentationType;
////import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
//import springfox.documentation.spring.web.plugins.Docket;
////import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
////import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//
//@Configuration
////@EnableSwagger2WebMvc
////@EnableSwagger2WebFlux
//
////@Import(SpringDataRestConfiguration.class)
//
//public class SwaggerConfiguration {
//	    
//
////
////	    @Bean
////	    public Docket api() {
////	        return new Docket(DocumentationType.SWAGGER_2)
////	                .select()
////	                .apis(RequestHandlerSelectors.any())
////	                .paths(PathSelectors.any())
////	                .build();
////	    }
////	}
//	@Bean
//	    public Docket api() { 
//	        return new Docket(DocumentationType.SWAGGER_2)  
//	          .select()                                  
//	          .apis(RequestHandlerSelectors.basePackage("com.mtplatform.demo"))              
//	          .paths(PathSelectors.any())                          
//	          .build().apiInfo(apiInfo());             
////	        .globalOperationParameters(Collections.singletonList(SessionToken));
//	    }
//	 
//	 private ApiInfo apiInfo() {
//		    return new ApiInfoBuilder().title("MT Platform APIs")
//		        .description("Documentation to MT Platform APIs with it's related DTOs")
//		        .license("Apache License Version 2.0").version("1.0").build();
//		  }
//	    
//	 
//}
