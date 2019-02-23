package com.javadeveloperzone;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by JavaDeveloperZone on 22-01-2018.
 */
class WeekOffVoter implements AccessDecisionVoter {
    @Override
    public int vote(Authentication authentication, Object object, Collection collection) {
        boolean isRoleUser = authentication.getAuthorities().stream()
                                           .filter(e -> e.getAuthority().equals("ROLE_STAFF"))
                                           .findAny().isPresent();                      // check is staff role
        if (isRoleUser) {
            if (LocalDateTime.now().getDayOfWeek().getValue() == 7)        // check for sunday
                return ACCESS_DENIED;                                   // deny if sunday
            else {
                return ACCESS_ABSTAIN;                  // not granted or not deny, Decision based on other voter
            }
        } else {
            return ACCESS_GRANTED;              // not granted or not deny, Decision based on other voter
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }
}