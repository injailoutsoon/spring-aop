package com.in28minutes.springaop.spring_aop1_springboot;

import com.in28minutes.springaop.spring_aop1_springboot.business.Business1;
import com.in28minutes.springaop.spring_aop1_springboot.business.Business2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAop1SpringbootApplication implements CommandLineRunner {
	public static void main(String[] args) {SpringApplication.run(SpringAop1SpringbootApplication.class, args);}
	@Autowired
	private Business1 business1;
	@Autowired
	private Business2 business2;
	@Override
	// invoked as soon as the app is launched
	public void run(String... args) throws Exception {
		business1.returnSomething();
		business2.returnSomething();
	}
}
