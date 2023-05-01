package com.book.Book.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class TestAspect {
    Logger logger = LoggerFactory.getLogger(TestAspect.class);
    @Around(value = "execution(* com.book.Book.service..*(..))")
    public Object printText(ProceedingJoinPoint pointcut) throws Throwable {
        logger.warn("Test Aspect");
        logger.info(pointcut.getSignature().toString());
        Object proceed = pointcut.proceed();
        return proceed;
    }

    @Around(value = "execution(public Object com.book.Book.service.AuthorService.findByEmail(String))")
    public void printTest2 (ProceedingJoinPoint joinPoint) {
        logger.info("Method is running.." + joinPoint.toShortString());
    }
}
