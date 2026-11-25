package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // Toutes les methodes de la couche service
    private static final String SERVICE_METHODS = "execution(* tn.esprit.autoloc.service..*.*(..))";

    @Before(SERVICE_METHODS)
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("[BEFORE] Methode appelee : {} | Parametres : {}", methodName, Arrays.toString(args));
    }

    @After(SERVICE_METHODS)
    public void logAfter(JoinPoint joinPoint) {
        log.info("[AFTER] Fin d'execution de la methode : {}", joinPoint.getSignature().getName());
    }
}