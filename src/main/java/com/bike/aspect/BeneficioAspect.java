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
public class BeneficioAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "execution(* com.bike.api.beneficios.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("BiciBogo -> retorna el siguiente valor: {}", result);
	}
	
	@After(value = "execution(* com.bike.api.beneficios.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("Despues de {}", joinPoint);
	}
	
}