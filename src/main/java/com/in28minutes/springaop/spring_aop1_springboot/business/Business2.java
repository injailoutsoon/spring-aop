package com.in28minutes.springaop.spring_aop1_springboot.business;

import com.in28minutes.springaop.spring_aop1_springboot.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {
    @Autowired
    private Dao2 dao2;
    public String returnSomething() { return dao2.retrieveData(); }
}
