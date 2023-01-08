package com.codegym.phone_manager.AOP;

import com.codegym.phone_manager.error.phone.NotFoundById;
import com.codegym.phone_manager.service.IPhoneService;
import lombok.SneakyThrows;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CheckFindById {

    @Autowired
    IPhoneService phoneService;

    @Pointcut("execution(* com.codegym.phone_manager.controller.APIPhoneController.findById(..)) && args(id)")
    public void checkResultInFindById(Long id) {

    }

    @Pointcut("execution(* com.codegym.phone_manager.controller.APIPhoneController.deletePhone_updateDB(..)) && args(id)")
    public void checkResultInDeletePhone_UpdateDB(Long id) {

    }

    @SneakyThrows
    @Before(value = "checkResultInFindById(id) || checkResultInDeletePhone_UpdateDB(id)", argNames = "id")
    public void checkFindByIdInRequest(Long id) {
        if (phoneService.findById(id) == null) {
            throw new NotFoundById("Not found with " + id);
        }
    }
}
