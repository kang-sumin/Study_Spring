package com.standard.sparta.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * dptmvorxm : 모듈 : 어드바이스와 포인트컷을 하나로 묶은 모듈
 */
@Slf4j
@Aspect
public class AspectPractice {
    // 포인트 컷 : 횡단 관심사를 적용할 범위지정

//    /**
//     * 포인트 컷 : 서비스(Service) 패키지 기반
//     */
//    @Pointcut("execution(* com.standard.sparta.service..*(..))")
//    private void serviceLayer() {
//
//    }

    /**
     * 포인트컷 : 어노테이션 범위 기반
     */
    @Pointcut("@annotation(com.standard.sparta.annotation.TrackTime)")
    private void trackTimeAnnotation(){

    }

    /**
     * 어드바이스 : 어노테이션 범위 기반
     */
    @Around("trackTimeAnnotation()")
    public Object adviceAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        // 메서드 실행 전
        // 측정 시작
        long startTime = System.currentTimeMillis();
        try{
            Object result = joinPoint.proceed();
            return result;
        }finally {
            // 측정 완료
            long endTime = System.currentTimeMillis();
            long excutionTime = endTime - startTime;
            log.info("::: ExcutionTime: {}ms", excutionTime);
        }

    }



//    @Around("serviceLayer()")
//    public Object advicePackageMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 측정 시작
//        long startTime = System.currentTimeMillis();
//        try {
//            Object result = joinPoint.proceed();
//            return result;
//        }finally {
//            // 측정 완료
//            long endTime = System.currentTimeMillis();
//            long excutionTime = endTime - startTime;
//            log.info("::: ExcutionTime: {}ms", excutionTime);
//
//        }
//    }



//    // 어드바이스들
//
//    /**
//     * 어드바이스 : @Before
//     * 메서드 실행 전에 수행되는 로직을 처리할때 사용합니다.
//     */
//    @Before("serviceLayer()")
//    public void beforeMethod() {
//        log.info("::: Before :::");
//    }
//
//    /**
//     * 어드바이스 : @AfterReturning
//     * 메서드가 ㅈ어상적으로 반환된 후에 실행됩니다.
//     * 예외가 발생하지 않고 정상적으로 결과값이 반환됐을때 동작합니다.
//     */
//    @AfterReturning(pointcut = "serviceLayer()", returning = "result")
//    public void afterReturningMethod(Object result) {
//        log.info("::: After Returning :::");
//    }
//
//    /**
//     * 어드바이스 : @AfterThrowing
//     * 메서드 실행 중 예외가 발생했을 때만 실행됩니다.
//     */
//    @AfterThrowing(pointcut = "serviceLayer()", throwing = "ex")
//    public void afterThrowingMethod(Throwable ex) {
//        // ex <- 예외가 발생했을 때 필요한 조작
//        log.info("::: After Throwing :::");
//    }
//
//    /**
//     * 어드바이스 : @After
//     * 메서드가 정상적으로 실행되건, 예외가 발생하건, 항상 실행됩니다.
//     */
//    @After("serviceLayer()")
//    public void afterMethod() {
//        log.info("::: After :::");
//    }
//
//    /**
//     * 어드바이스 : @Around
//     * 가장 강력한 어드바이스, 전체 흐름을 제어할 수 있는 어드바이스
//     */
//    @Around("serviceLayer()")
//    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("::: Before :::");
//        try {
//            Object result = joinPoint.proceed();
//            log.info("::: After Returning :::");
//            return result;
//        } catch (Exception e) {
//            log.info("::: After Throwing :::");
//            throw e;
//        } finally {
//            log.info("::: After :::");
//        }
//
//    }

}
