package br.edu.utfpr.pb.pw25s.serverproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerProjectApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET","POST","PUT","PATCH","OPTIONS","DELETE")
						.allowedHeaders("Authorization","x-xsrf-token", "Access-Control-Allow-Headers", "Origin",
								"Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method",
								"Access-Control-Request-Headers", "Auth-Id-Token");
			}
		};
	}
}
