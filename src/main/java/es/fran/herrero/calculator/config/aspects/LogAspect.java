package es.fran.herrero.calculator.config.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {

	@Around("execution(* es.fran.herrero.calculator.service.v1.*.*(..))")
	public Object executeTime(ProceedingJoinPoint jPoint) throws Throwable {

		Long time1 = System.currentTimeMillis();
		Object proceed = jPoint.proceed();
		Long time2 = System.currentTimeMillis();
		Long total = time2 - time1;
		if (total > 0 && jPoint.getSignature()!=null) {
			log.info(String.format("Method : %s execution time: %d\n", jPoint.getSignature().toString(), total));	
		}
		return proceed;
	}
}