package com.codegym.blog_spring_security.aspect;

import com.codegym.blog_spring_security.error.LoginBeforeAction;
import com.codegym.blog_spring_security.repository.IAuthenticationFacade;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class checkLogin {

    Logger logger = LoggerFactory.getLogger(checkLogin.class);

    @Autowired
    IAuthenticationFacade authenticationFacade;

    @Pointcut("execution( * com.codegym.blog_spring_security.controller.APIBlogController.createData(..)) ")
    public void checkBeforeCreate() {
    }

    @Pointcut("execution( * com.codegym.blog_spring_security.controller.APIBlogController.editData(..))")
    public void checkBeforeEdit() {
    }

    @Pointcut("execution( * com.codegym.blog_spring_security.controller.APIBlogController.deleteData(..))")
    public void checkBeforeDelete() {
    }

    @Before(value = "checkBeforeCreate() || checkBeforeEdit() || checkBeforeDelete()")
    public void checkHandle() throws LoginBeforeAction {
        if(authenticationFacade.getAuthentication().getPrincipal().equals("anonymousUser")) {
            throw new LoginBeforeAction("Login before do something");
        }
    }
}
