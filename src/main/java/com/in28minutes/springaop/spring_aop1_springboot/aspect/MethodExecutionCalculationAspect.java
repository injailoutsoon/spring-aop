package com.in28minutes.springaop.spring_aop1_springboot.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import static com.in28minutes.springaop.spring_aop1_springboot.aspect.config.CommonJoinPointUtils.BUSINESS;
import static com.in28minutes.springaop.spring_aop1_springboot.aspect.config.CommonJoinPointUtils.TRACK_TIME_ANNOTATION;

@Aspect
@Configuration
@Slf4j
public class MethodExecutionCalculationAspect {
    @SneakyThrows
     @Around(BUSINESS)
    // @Around("execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))")
    public void timeExecutionAspect(ProceedingJoinPoint proceedingJoinPoint) {
        Long startTime = System.nanoTime();
        proceedingJoinPoint.proceed(); // allow method to execute
        Long timeTaken = System.nanoTime() - startTime;
        log.info("{} Took: {} nanoseconds", proceedingJoinPoint, timeTaken);
    }

    @SneakyThrows
    @Around(TRACK_TIME_ANNOTATION)
    // "@annotation(com.in28minutes.springaop.spring_aop1_springboot.annotation.TrackTime)"
    public void timeExecutionWitTrackTimeAnnotationAspect(ProceedingJoinPoint proceedingJoinPoint) {
        Long startTime = System.nanoTime();
        proceedingJoinPoint.proceed(); // allow method to execute
        Long timeTaken = System.nanoTime() - startTime;
        log.info("@TrackTime: {} took {} nanoseconds", proceedingJoinPoint, timeTaken);
    }













}
