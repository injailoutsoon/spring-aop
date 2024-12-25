package com.in28minutes.springaop.spring_aop1_springboot.aspect.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor(access = AccessLevel.NONE)
public class CommonJoinPointUtils {
    public final static String BUSINESS = "execution(* com.in28minutes.springaop.spring_aop1_springboot.business.*.*(..))";
    public final static String DATA = "execution(* com.in28minutes.springaop.spring_aop1_springboot.data.*.*(..))";

    // join Pointcut
    public final static String ALL_LAYERS = "com.in28minutes.springaop.spring_aop1_springboot.aspect.config.CommonJoinPointConfig.businessExecution() " +
            "&& com.in28minutes.springaop.spring_aop1_springboot.aspect.config.CommonJoinPointConfig.dataLayerExecution()";

    // create Pointcut by using Bean names (Points are defined by AspectJ and implemented by Spring AOP)
    public final static String BEANS_STARTING_WITH_DAO = "bean(dao*)";
    public final static String BEANS_CONTAINING_WITH_DAO = "bean(*dao*)";

    // Within
    public final static String ALL_CALLS_WITHIN_DATA_LAYER = "within(com.in28minutes.springaop.spring_aop1_springboot.data..*";

    // Annotation
    public final static String TRACK_TIME_ANNOTATION = "@annotation(com.in28minutes.springaop.spring_aop1_springboot.annotation.TrackTime)";

}
