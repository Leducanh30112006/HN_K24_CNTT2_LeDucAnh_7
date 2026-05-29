package com.ra.hn_k24_cntt2_leducanh_7.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @AfterReturning(pointcut = "" +
            "execution(* com.ra.hn_k24_cntt2_leducanh_7.service.RoomServiceImpl.addRoom(..)) || " +
            "execution(* com.ra.hn_k24_cntt2_leducanh_7.service.RoomServiceImpl.updateRoom(..)) || " +
            "execution(* com.ra.hn_k24_cntt2_leducanh_7.service.RoomServiceImpl.patchRoom(..))")
    public void logSuccess(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info(" OPERATION SUCCESS - Method: {} executed successfully", methodName);
    }

    @AfterThrowing(pointcut = "execution(* com.ra.hn_k24_cntt2_leducanh_7.service.*.*(..))", throwing = "ex")
    public void logExceptions(JoinPoint joinPoint, Exception ex) {
        logger.error(" EXCEPTION in method: {} - Message: {}",
                joinPoint.getSignature().getName(), ex.getMessage(), ex);
    }
}