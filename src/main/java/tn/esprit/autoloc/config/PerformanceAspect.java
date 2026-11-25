package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    private static final long SEUIL_MS = 1000;

    @Around("execution(* tn.esprit.autoloc.service..*.*(..))")
    public Object mesurerTemps(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        long debut = System.currentTimeMillis();
        try {
            return pjp.proceed();   // execution de la methode interceptee
        } finally {
            long duree = System.currentTimeMillis() - debut;
            log.info("[PERFORMANCE] {} execute en {} ms", methodName, duree);
            if (duree > SEUIL_MS) {
                log.warn("[PERFORMANCE] ATTENTION : la methode {} est lente ({} ms > {} ms)",
                        methodName, duree, SEUIL_MS);
            }
        }
    }
}