# Chapter 8 : Spring Level 5 - Spring AOP (Aspect Oriented Programming)
  ![image](https://github.com/user-attachments/assets/f7378c6c-62d0-4787-a614-807981b02380)
  ![image](https://github.com/user-attachments/assets/8e711282-9788-4476-b453-48d52a04346f)

	- https://www.baeldung.com/spring-aop
	- https://www.baeldung.com/aspectj
	- https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/aop.html
	- https://www.baeldung.com/spring-aop-pointcut-tutorial
	- https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html
	- It's for cross-cutting concerns (not a single layer concern like business layer, data layer, web layer, ..), ex: track performance across all the layers, logging security

	- Springboot 3.4.1 with:
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-aop</artifactId>
	</dependency>
	<dependency>
	    <groupId>org.aspectj</groupId>
	    <artifactId>aspectjrt</artifactId>
	</dependency>
	<dependency>
	    <groupId>org.aspectj</groupId>
	    <artifactId>aspectjweaver</artifactId>
	</dependency>
	
## Step 01 – Understanding the AOP Terminology - Pointcut, Advice, Aspect, and JoinPoint
  ![image](https://github.com/user-attachments/assets/a82b1ac7-b3de-4597-af1e-80496d020b6b)
  ![image](https://github.com/user-attachments/assets/f3fdc9f3-9098-4fc9-90ca-a47f72d765fd)
	
 => @ Before is executed before the JointPoint method being executed: usually is an aspect checking if user has the right access before allowing method execution
	Body of it is called Advice (what we want to do)
	The process is called Weaving, lib: Weaver
	=> Aspect = Advice + JoinPoint
  ![image](https://github.com/user-attachments/assets/d6e46292-7daf-4e22-96da-1084042eb8b8)
	
	 [           main] c.i.s.s.aspect.BeforeAspect              : Intercepted method calls execution(String com.in28minutes.springaop.spring_aop1_springboot.business.Business1.returnSomething())
	 [           main] c.i.s.s.aspect.BeforeAspect              : Intercepted method calls execution(String com.in28minutes.springaop.spring_aop1_springboot.business.Business2.returnSomething())
	
	
## Step 02 - Using the @After, @AfterReturning, @AfterThrowing Advices
	![image](https://github.com/user-attachments/assets/960abd91-b0b1-4517-8f64-1e8d1e34e875)
	
	main] c.i.s.s.aspect.AfterAopAspect            : execution(String com.in28minutes.springaop.spring_aop1_springboot.business.Business1.returnSomething()) returned with value Dao1
	main] c.i.s.s.aspect.AfterAopAspect            : execution(String com.in28minutes.springaop.spring_aop1_springboot.business.Business2.returnSomething()) returned with value Dao2
	
	
## Step 03 – Using the @Around Advice to Implement Performance Tracing
	- ProceedingJoinPoint => allow to continue with method execution
    ![image](https://github.com/user-attachments/assets/ea17ba0b-d635-45a2-a604-b55c0d19e6f9)
	
	main] i.s.s.a.MethodExecutionCalculationAspect : execution(String com.in28minutes.springaop.spring_aop1_springboot.business.Business1.returnSomething()) Took: 61600 nanoseconds
	main] i.s.s.a.MethodExecutionCalculationAspect : execution(String com.in28minutes.springaop.spring_aop1_springboot.business.Business2.returnSomething()) Took: 73600 nanoseconds
	
	
## Step 04 - Best Practice – Using Common Pointcut Configuration => separate file to define the PoinPont
	- It can be used now everywhere => DRY
	![image](https://github.com/user-attachments/assets/dc2540d2-a531-44c0-96a0-87d59629386f)
  ![image](https://github.com/user-attachments/assets/bae8b39a-d159-4a7b-99a9-400f22a2ab2a)

## Step 05 - Quick Summary of Other Pointcuts
	![image](https://github.com/user-attachments/assets/fea99cc0-e636-437a-9183-040f7c05ec9d)

## Step 06 - Creating Custom Annotation and an Aspect for Tracking Time
	- All methods annotated with @TrackTime, at runtime
   ![image](https://github.com/user-attachments/assets/ee3ea95c-0ee0-4543-b86a-26639f1b8b48)
   
	
![image](https://github.com/user-attachments/assets/5f380a04-ae6e-42af-a18e-3337ca4ab35f)
