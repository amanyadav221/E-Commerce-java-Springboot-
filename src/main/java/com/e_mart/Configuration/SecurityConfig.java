package com.e_mart.Configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


    	http
    	.cors(Customizer.withDefaults())

        .csrf(csrf -> csrf.disable())
        .sessionManagement(m -> m.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth -> auth
        		 .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  
        		 .requestMatchers("/error").permitAll()

                .requestMatchers("/public/**", "/auth/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                //.requestMatchers("/user/**").hasRole("USER")
                .requestMatchers(HttpMethod.GET,    "/user/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST,   "/user/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.PUT,    "/user/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/user/**").hasAnyRole("USER","ADMIN")

                .requestMatchers(HttpMethod.DELETE, "/user/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
        )
       // .addFilterBefore(jwtTokenValidator(), BasicAuthenticationFilter.class);
       // .addFilterBefore(jwtTokenValidator(), UsernamePasswordAuthenticationFilter.class);
       // .addFilterAfter(jwtTokenValidator(), UsernamePasswordAuthenticationFilter.class);
    	//.addFilterAfter(jwtTokenValidator(), SecurityContextPersistenceFilter.class);
       // .addFilterAfter(jwtTokenValidator(), SecurityContextHolderFilter.class);
        //.addFilterBefore(jwtTokenValidator(), UsernamePasswordAuthenticationFilter.class);
        .addFilterBefore(jwtTokenValidator(), UsernamePasswordAuthenticationFilter.class);






    return http.build();
    }
    
    @Bean
    public JwtTokenValidator jwtTokenValidator() {
        return new JwtTokenValidator();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of("http://localhost:5173"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE","PATCH", "OPTIONS"));

        // 🔑 Important headers
        //config.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With"));
        config.setAllowedHeaders(List.of("*"));
        config.setExposedHeaders(List.of("Authorization"));

        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
}
