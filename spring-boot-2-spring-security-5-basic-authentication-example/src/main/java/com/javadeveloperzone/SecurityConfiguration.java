package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Created by JavaDeveloperZone on 07-04-2018.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired      // here is configuration related to spring boot basic authentication
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()                   // for inMemory Authentication
            .withUser("zone").password("{noop}password").roles("USER")          // {noop} for plain text
            .and()
            .withUser("zone3").password("{noop}password").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()                      // it indicate basic authentication is requires
                .and()
                .authorizeRequests()
                .antMatchers( "/index").permitAll() // /index will be accessible directly no need of any authentication
                .anyRequest().authenticated();    // it's indicate all request will be secure
                 http.csrf().disable();      // to disable csrf
    }
}
