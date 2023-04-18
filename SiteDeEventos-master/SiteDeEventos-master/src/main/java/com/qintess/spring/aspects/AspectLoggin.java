package com.qintess.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLoggin {

	@Before("execution(* com.qintess.spring.*.*.*(..))")
	public void beforeStuff(JoinPoint join) {
		MethodSignature method = (MethodSignature) join.getSignature();
		System.out.println("Method: " + method);
	}
	
	
}
