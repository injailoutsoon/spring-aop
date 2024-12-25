package com.in28minutes.springaop.spring_aop1_springboot.data;

import com.in28minutes.springaop.spring_aop1_springboot.annotation.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    @TrackTime
    public String retrieveData() { return "Dao1"; }
}
