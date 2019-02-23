package com.javadeveloperzone;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Collections;

/**
 * Created by Java Developer Zone on 25-12-2017.
 * This class will check custom Authentication and return Authentication object if username and password is current
 *
 */
public class CustomAuthentication implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String user = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (user.equalsIgnoreCase("user") && password.equals("mypassword")) {           // replace your custom code here for custom authentication
            return new UsernamePasswordAuthenticationToken
                    (user, password, Collections.emptyList());
        } else {
            throw new BadCredentialsException("External system authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
