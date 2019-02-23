package com.javadeveloperzone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

/**
 * Created by JavaDeveloperZone on 04-08-2017.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.addFilter(digestAuthenticationFilter())              // register digest entry point
            .exceptionHandling().authenticationEntryPoint(digestEntryPoint())       // on exception ask for digest authentication
            .and()
            .httpBasic()                      // it indicate basic authentication is requires
            .and()
            .authorizeRequests()
            .antMatchers( "/home").permitAll() // /index will be accessible directly, no need of any authentication
            .anyRequest().authenticated();

    }

    DigestAuthenticationFilter digestAuthenticationFilter() throws Exception {

        DigestAuthenticationFilter digestAuthenticationFilter=new DigestAuthenticationFilter();
        digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
        digestAuthenticationFilter.setAuthenticationEntryPoint(digestEntryPoint());
        return digestAuthenticationFilter;
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(User.withUsername("zone").password("password").roles("USER").build());
        return inMemoryUserDetailsManager;

    }

    @Bean
    DigestAuthenticationEntryPoint digestEntryPoint() {
        DigestAuthenticationEntryPoint bauth = new DigestAuthenticationEntryPoint();
        bauth.setRealmName("Digest WF Realm");
        bauth.setKey("MySecureKey");
        return bauth;
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
}
