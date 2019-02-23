package com.javadeveloperzone.controller;


import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.HttpSessionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


/**
 * Created by Java Developer Zone on 19-07-2017.
 */
@Controller
public class SpringBootExampleController {

    @RequestMapping(value = "login")
    public String login(HttpServletRequest httpRequest,ModelMap map) {
        HttpSessionManager sessionManager = (HttpSessionManager) httpRequest.getAttribute(HttpSessionManager.class.getName());
        String addAlias = sessionManager.getNewSessionAlias(httpRequest);           // it will create new alis used when new user login
        map.put("s",addAlias);
        map.put("currentLoginUsers",getAssociatedUsers(httpRequest));

        return "login";
    }

    @RequestMapping(value = "loginSuccess")
    public String loginSuccess(HttpServletRequest request,Principal pricipal,ModelMap modelMap){
       Integer integer =(Integer) request.getSession().getAttribute("hitCounter");
       if(integer==null){
           integer=new Integer(0);
           integer++;
           request.getSession().setAttribute("hitCounter",integer);
       }else{
           integer++;
           request.getSession().setAttribute("hitCounter",integer);
       }
        HttpSessionManager httpSessionManager = (HttpSessionManager)request.getAttribute(HttpSessionManager.class.getName());
        modelMap.put("currentLoginUsers",getAssociatedUsers(request));
        modelMap.put("currentLoginUser",pricipal.getName());
        modelMap.put("currentLoginUserKey",httpSessionManager.getCurrentSessionAlias(request) );
        return "welcome";
    }
    public java.util.Map<String,String> getAssociatedUsers(HttpServletRequest request){  // it will return all Associated accounts from request come
        java.util.Map<String,String>  currentLoginUSer=new java.util.HashMap<>();
        SessionRepository<Session> repo =
                (SessionRepository<Session>) request.getAttribute(SessionRepository.class.getName());
        HttpSessionManager httpSessionManager = (HttpSessionManager)request.getAttribute(HttpSessionManager.class.getName());
        java.util.Map<String,String> stringStringMap=  httpSessionManager.getSessionIds(request); // it  will return all session id of same browser from request comes
        java.util.Set<String> keys = stringStringMap.keySet();
        for(String key:keys) {                                                      // logic to get user information from session id
            Session session = repo.getSession(stringStringMap.get(key));
            if(session!=null) {
                SecurityContextImpl securityContext = ((SecurityContextImpl) session
                        .getAttribute("SPRING_SECURITY_CONTEXT"));                      // get spring security context
                if(securityContext!=null) {
                    User user = (User) securityContext.getAuthentication().getPrincipal();          // get user name from spring security context
                    currentLoginUSer.put(key, user.getUsername());
                }
            }
        }
        return currentLoginUSer;
    }

    @RequestMapping(value = "loginFailed")
    public String loginFailed(){
        return "loginFailed";
    }


}
