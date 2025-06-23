package com.practice.member_jpa_aop2.common.aop;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ServiceLoggerAdvice {

    @Before("execution(* com.practice.member_jpa_aop2.service.MemberDAOService*.*(..))")
    // 첫번째 별은 리턴값
    // @After("execution(* com.kh.spring_aop.service.BoardDAOService*.*(..))")
    // @Around("execution(* com.kh.spring_aop.service.BoardDAOService*.*(..))")
    public void startLog(JoinPoint jp){
        log.info("startLog");
        log.info("startLog : " + jp.getSignature());
        if(jp.getArgs() != null) {
            log.info("startLog : " + Arrays.toString(jp.getArgs()));
        }
    }

    // @Before("execution(* com.kh.spring_aop.service.BoardDAOService*.*(..))")
    // 첫번째 별은 리턴값
    // @After("execution(* com.kh.spring_aop.service.BoardDAOService*.*(..))")
    @Around("execution(* com.practice.member_jpa_aop2.service.MemberDAOService*.*(..))")
    public void timeLog(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.currentTimeMillis();
        // 핵심 관심이 실행되는 부분
        // Object result = pjp.proceed();
        
        long endTime = System.currentTimeMillis();
        log.info(pjp.getSignature().getName() + " : " + (endTime - startTime));
    }

}
