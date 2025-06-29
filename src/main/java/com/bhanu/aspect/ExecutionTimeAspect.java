package com.bhanu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {


  @Around("@annotation(com.bhanu.annotations.LogExecutionTime)")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();

    try {
      Object result = joinPoint.proceed();
      return result;
    } finally {
      long endTime = System.currentTimeMillis();
      long executionTimeMs = endTime - startTime;

      String methodName = joinPoint.getSignature().getName();
      String className = joinPoint.getTarget().getClass().getSimpleName();
      log.info("Method {}.{} executed in {} ms{}",
          className, methodName, executionTimeMs);
    }
  }
}
