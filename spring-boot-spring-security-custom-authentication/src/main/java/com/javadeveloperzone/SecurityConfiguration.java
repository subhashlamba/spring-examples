package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



/**
 * Created by JavaDeveloperZone on 13-11-2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired      // here is configuration related to spring boot basic authentication
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("mypassword").roles("USER")
            .and()
            .withUser("admin").password("mypassword").roles("ADMIN");// those are user name and password
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests().antMatchers("/loginFailed").permitAll()
            .and()
            .authorizeRequests().antMatchers("/**").authenticated()
            .and()
            .formLogin()
            .loginPage("/login").successForwardUrl("/loginSuccess")
            .permitAll().and().authenticationProvider(new CustomAuthentication());
    }
}


