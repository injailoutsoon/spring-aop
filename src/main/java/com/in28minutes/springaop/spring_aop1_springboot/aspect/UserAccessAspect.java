package com.in28minutes.springaop.spring_aop1_springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import static com.in28minutes.springaop.spring_aop1_springboot.aspect.config.CommonJoinPointUtils.BUSINESS;

@Aspect
@Configuration
@Slf4j
public class UserAccessAspect {
    // execution(* package.*.*(..))
    // scope(return type: String,.. | * ) package(name | *).class(name | *).method.(arguments: if empty => with no args | * => one arg | .. => we don't care args or not)
//    @Before("execution(* com.in28minutes.springaop.spring_aop1_springboot.business.Business1.returnSomething())")
//    @Before("execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))") // any method in any class inside that package
//    @Before("execution(* com.in28minutes.springaop.spring_aop1_springboot..*.*(..))") // any method in any class inside that package and sub-packages
//    @Before("execution(* returnSomething*(..))") // any method starting with "return something"
//    @Before("execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))")


//     @Before("execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))")
     @Before(BUSINESS)
     public void BeforeAspect(JoinPoint joinPoint) {
        // body called Advice
        log.info("Check for user access");
        log.info("Allowed execution for {}", joinPoint);
    }
}
