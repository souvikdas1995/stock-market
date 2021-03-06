package command.service;

import command.service.repository.CustomRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("command.service.bean")
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class CommandServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CommandServiceApplication.class, args);
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/v1/**").allowedOrigins("*").allowedMethods("POST","PUT", "DELETE");
//            }
//        };
//    }
}