package com.example.repairserviceapp.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    //TODO добавить в дто клиента email


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.authorizeHttpRequests(registry -> {
//            registry.requestMatchers("/api/history/**").hasRole("ADMIN");
////            registry.anyRequest().authenticated();
//        }).build();
//    }

}
