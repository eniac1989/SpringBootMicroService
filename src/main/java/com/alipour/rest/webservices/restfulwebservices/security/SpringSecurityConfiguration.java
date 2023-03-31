package com.alipour.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Paniz Alipour
 */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //		1) All requests should be authenticated
        http.authorizeRequests(auth->auth.anyRequest().authenticated());
        //		2) If a request is not authenticated, a web page is shown
        http.httpBasic(Customizer.withDefaults());
        //		3) CSRF -> POST, PUT
        http.csrf().disable();

    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
////		1) All requests should be authenticated
//         http.authorizeRequests(
//                auth -> auth.anyRequest().authenticated()
//        );
////		2) If a request is not authenticated, a web page is shown
//        http.httpBasic(Customizer.withDefaults());
//
////		3) CSRF -> POST, PUT
//        http.csrf().disable();
//
//
//        return http.build();
//    }

}
