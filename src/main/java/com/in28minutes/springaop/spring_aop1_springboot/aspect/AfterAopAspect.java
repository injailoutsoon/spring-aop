package com.in28minutes.springaop.spring_aop1_springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import static com.in28minutes.springaop.spring_aop1_springboot.aspect.config.CommonJoinPointUtils.BUSINESS;

@Aspect
@Configuration
@Slf4j
public class AfterAopAspect {

    // called in both scenarios: success or exception
//    @After("execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))")
    @After(BUSINESS)
    public void AfterAspect(JoinPoint joinPoint, Object result) { log.info("After execution of {}", joinPoint); }

    // called after successful execution
//    @AfterReturning(value = "execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))", returning = "result")
    @After(BUSINESS)
    public void AfterReturningAspect(JoinPoint joinPoint, Object result) { log.info("{} returned with value {}", joinPoint, result); }

    // click on AfterThrowing to get more details on the annotation
//    @AfterThrowing(value = "execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))", throwing = "exception")
    @After(BUSINESS)
    public void AfterThrowingAspect(JoinPoint joinPoint, Object exception) { log.info("{} threw exception {}", joinPoint, exception); }
}
