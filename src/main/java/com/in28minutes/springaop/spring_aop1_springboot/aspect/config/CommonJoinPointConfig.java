package com.in28minutes.springaop.spring_aop1_springboot.aspect.config;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonJoinPointConfig {
    @Pointcut("execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))")
    public void businessExecution(){}
    @Pointcut("execution(* com.in28minutes.springaop.spring_aop1_springboot.data.*.*(..))")
    public void dataLayerExecution(){}

    // join Pointcut
    @Pointcut("com.in28minutes.springaop.spring_aop1_springboot.aspect.config.CommonJoinPointConfig.businessExecution() " +
            "&& com.in28minutes.springaop.spring_aop1_springboot.aspect.config.CommonJoinPointConfig.dataLayerExecution()")
    public void allLayerExecution(){}

    // create Pointcut by using Bean names (Points are defined by AspectJ and implemented by Spring AOP)
    @Pointcut("bean(dao*)")
    public void beanStartingWithDao(){}
    @Pointcut("bean(*dao*)")
    public void beanContainingDao(){}

    // Within
    @Pointcut("within(com.in28minutes.springaop.spring_aop1_springboot.data..*")
    public void allCallsWithinDataLayer(){}

    // Annotation
    @Pointcut("@Annotation(com.in28minutes.springaop.spring_aop1_springboot.annotation.TrackTime)")
    public void trackTimeAnnotation(){}

}
