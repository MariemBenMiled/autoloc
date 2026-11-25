package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionHandlingAspect {

    @AfterThrowing(pointcut = "execution(* tn.esprit.autoloc.service..*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        log.error("[EXCEPTION] Methode : {} | Type : {} | Message : {}",
                joinPoint.getSignature().getName(),
                ex.getClass().getName(),
                ex.getMessage());
    }
}