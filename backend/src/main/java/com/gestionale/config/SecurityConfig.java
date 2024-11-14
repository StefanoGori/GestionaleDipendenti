//package com.gestionale.config;
//
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//public class SecurityConfig {
//	
//	//spieghiamo come gestire la codifica delle password
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(Customizer.withDefaults())
//
//                .httpBasic(Customizer.withDefaults())
//                .authorizeHttpRequests(requests -> requests
//                		//autorizzazioni chiamate per timetables permesse a tutti
//                		.requestMatchers(HttpMethod.GET, "/management/timetables/**").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/management/timetables/**").hasAuthority("ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/management/timetables/**").permitAll()
//                        .requestMatchers(HttpMethod.DELETE, "/management/timetables/**").permitAll()
//                        
//                        .requestMatchers(HttpMethod.GET, "/management/employees/**").hasAuthority("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/management/employees/*").hasAuthority("ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/management/employees/*").hasAuthority("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/management/employees/*").hasAuthority("ADMIN")
//
//                        .anyRequest().authenticated()
//                );
//        return http.build();
//    }
//}	
