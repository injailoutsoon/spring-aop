package com.in28minutes.springaop.spring_aop1_springboot.business;

import com.in28minutes.springaop.spring_aop1_springboot.annotation.TrackTime;
import com.in28minutes.springaop.spring_aop1_springboot.data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {
    @Autowired
    private Dao1 dao1;
    @TrackTime
    public String returnSomething() { return dao1.retrieveData(); }
}
