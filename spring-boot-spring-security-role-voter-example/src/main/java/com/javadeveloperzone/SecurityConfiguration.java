package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;


/**
 * Created by JavaDeveloperZone on 13-11-2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired      // here is configuration related to spring boot basic authentication
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
            .withUser("user").password("mypassword").roles("STAFF")
            .and()
            .withUser("admin").password("mypassword").roles("ADMIN");// those are user name and password
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests().antMatchers("/loginFailed").permitAll()
            .and().authorizeRequests().antMatchers("/**").access("hasAnyRole('ADMIN','STAFF')")
            .and().authorizeRequests()
            .and()
            .formLogin()
            .defaultSuccessUrl("/loginSuccess")
            .failureUrl("/failed")
            .loginPage("/login")
            .permitAll();

        http.authorizeRequests()
            .accessDecisionManager(accessDecisionManager());        // password custom access decision manager
    }

    @Bean
    public AccessDecisionManager accessDecisionManager() {
        java.util.List<AccessDecisionVoter<? extends Object>> decisionVoters
                = Arrays.asList(
                new WebExpressionVoter(),
                new RoleVoter(),
                new AuthenticatedVoter(),
                new WeekOffVoter()
        );
        return new UnanimousBased(decisionVoters);
    }
}

