package com.javadeveloperzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


/**
 * Created by JavaDeveloperZone on 04-08-2017.
 */
@Configuration
@EnableAuthorizationServer
public class SecurityOAuth2Configuration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                   .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
               .withClient("javadeveloperzone")
               .secret("secret")
               .accessTokenValiditySeconds(2000)        // expire time for access token
               .refreshTokenValiditySeconds(-1)         // expire time for refresh token
               .scopes("read", "write")                         // scope related to resource server
               .authorizedGrantTypes("password", "refresh_token");      // grant type

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @EventListener
    public void authSuccessEventListener(AuthenticationSuccessEvent authorizedEvent){
        // write custom code here for login success audit
        System.out.println("User Oauth2 login success");
        System.out.println("This is success event : "+authorizedEvent.getAuthentication().getPrincipal());
    }

    @EventListener
    public void authFailedEventListener(AbstractAuthenticationFailureEvent oAuth2AuthenticationFailureEvent){
        // write custom code here login failed audit.
        System.out.println("User Oauth2 login Failed");
        System.out.println(oAuth2AuthenticationFailureEvent.getAuthentication().getPrincipal());
    }
}
