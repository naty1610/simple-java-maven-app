package com.bike.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MonitoreoAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "execution(* com.bike.api.monitoreo.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} -> BiciBogo sincronizando monitoreo de usuario: {}", joinPoint, result);
	}
	
	@After(value = "execution(* com.bike.api.monitoreo.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("Despues de {}", joinPoint);
	}
	
}