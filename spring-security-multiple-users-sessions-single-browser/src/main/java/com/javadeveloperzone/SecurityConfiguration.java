package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.session.web.http.HttpSessionManager;


/**
 * Created by Java Developer Zone on 15-11-2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired      // here is configuration related to spring boot basic authentication
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()                                               // static users
            .withUser("zone1").password("mypassword").roles("USER")
            .and()
            .withUser("zone2").password("mypassword").roles("USER")
            .and()
            .withUser("zone3").password("mypassword").roles("USER")
            .and()
            .withUser("zone4").password("mypassword").roles("USER")
            .and()
            .withUser("zone5").password("mypassword").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .successHandler((httpServletRequest, httpServletResponse, authentication) -> {              // login success handler
                HttpSessionManager httpSessionManager = (HttpSessionManager) httpServletRequest
                        .getAttribute(HttpSessionManager.class.getName());
                String url = httpSessionManager
                        .encodeURL("loginSuccess", httpSessionManager.getCurrentSessionAlias(httpServletRequest));  // on login success add session alias in url
                httpServletResponse.sendRedirect(url);
            })
            .failureUrl("/loginFailed")                     // on login failed redirect to this user
            .loginPage("/login")                        // login page
            .permitAll();
    }


}
