package com.respeso.springwebproject;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	/*
	 * If I want to execute this method when 'getAliens' method is called, 
	 * getAliens is my join point. To achieve that we need a point cut:
	 * Before is the advice type and the point cut is the expression.
	 * Notice that we have to mention quelifyed name of the method (name with package and class)
	 */
	@Before("execution(public * com.respeso.springwebproject.AlienController.getAliens())")
	public void logBefore() {
		LOGGER.info("'getAliens' method called");
	}
	
	/*
	 * By default this advice is After-finally and it is always executed, even a exception is thrown.
	 */
	@After("execution(public * com.respeso.springwebproject.AlienController.getAliens())")
	public void logAfter() {
		LOGGER.info("'getAliens' method END");
	}
	
	/*
	 * 
	 */
	@AfterReturning("execution(public * com.respeso.springwebproject.AlienController.getAliens())")
	public void logAfterReturning() {
		LOGGER.info("'getAliens' method executed WELL :)");
	}
	
	/*
	 * 
	 */
	@AfterThrowing("execution(public * com.respeso.springwebproject.AlienController.getAliens())")
	public void logAfterThrowing() {
		LOGGER.info("'getAliens' method WITH EXCEPTION :(");
	}
	
}
