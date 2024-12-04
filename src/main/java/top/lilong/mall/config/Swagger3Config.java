package top.lilong.mall.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@Configuration
public class Swagger3Config {
    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder().group("用户模块").pathsToMatch("/user/**").build();
    }

    @Bean
    public GroupedOpenApi shoppingApi() {
        return GroupedOpenApi.builder().group("商品模块").pathsToMatch("/shopping/**").build();
    }

    @Bean
    public GroupedOpenApi orderApi() {
        return GroupedOpenApi.builder().group("订单模块").pathsToMatch("/order/**").build();
    }

    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("spring-cloud")
                        .description("通用设计")
                        .version("v1.0")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("")
                        .url("")
                );
    }
}
