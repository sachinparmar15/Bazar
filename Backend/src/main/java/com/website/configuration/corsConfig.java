
package com.website.configuration; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration; 
import org.springframework.web.cors.UrlBasedCorsConfigurationSource; 
import org.springframework.web.filter.CorsFilter; 
@Configuration 
public class corsConfig {
	@Bean 
	CorsFilter corsFilter() { 
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); 
		CorsConfiguration config = new CorsConfiguration(); 
		config.addAllowedOrigin("http://localhost:4200");
		config.addAllowedMethod("*");
		config.addAllowedHeader("*");
		config.setAllowCredentials(true);
		source.registerCorsConfiguration("/**", config); 
		System.out.println("Hello"); 
		return new CorsFilter(source); 
		 
	}
}