package com.mkyong.aspect;

import com.mkyong.rest.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(RestController.class);

    @Pointcut("execution(public * com.mkyong.rest.RestController.*(..))")
    private void selectAllPublic() {}

    @AfterThrowing(pointcut = "selectAllPublic()", throwing = "ex")
    public void doAfterThrowingTask(Exception ex) {
        System.out.println("Ошибка - " + ex.getMessage());
    }

    @Before(value = "selectAllPublic()", argNames = "joinPoint")
    public void logExecuteMethods(JoinPoint joinPoint) {
        logger.info("Executing: {}", joinPoint.getSignature().toShortString());
    }
}
