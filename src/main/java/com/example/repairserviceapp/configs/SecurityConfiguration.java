package com.example.repairserviceapp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws SecurityException {
//        return httpSecurity.authorizeHttpRequests(registry -> {
//            registry.anyRequest().authenticated();
//            registry.anyRequest().permitAll();
//        })
//    }

}
