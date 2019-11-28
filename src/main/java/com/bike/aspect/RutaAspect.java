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
public class RutaAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "execution(* com.bike.api.rutas.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("Retorna el siguiente valor: {}", result);
	}
	
	@After(value = "execution(* com.bike.api.rutas.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("Despues de {}", joinPoint);
	}
	
}