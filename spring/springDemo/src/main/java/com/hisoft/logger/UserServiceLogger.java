package com.hisoft.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component("logger")
@Aspect//说明该类是增强类
public class UserServiceLogger {

    private static final Logger logger = Logger.getLogger(UserServiceLogger.class);
    @Pointcut("execution(public * com.hisoft.service..*.*(..))")
    public void pointcut(){}
    //前置增强
    @Before("pointcut()")
    public void before(JoinPoint jp){
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，方法入参："+ Arrays.toString(jp.getArgs()));
    }
    //后置增强 -方法正常结束
    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，方法返回值："+result);
    }
    //异常抛出增强
    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e){
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，抛出了异常："+ e);
    }
    //最终增强
    @After(value = "pointcut()")
    public void after(JoinPoint jp){
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，方法执行完毕");
    }
    //环绕增强
    @Around(value = "pointcut()")
    public void around(ProceedingJoinPoint jp){
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，参数列表："+ Arrays.toString(jp.getArgs()));
        Object result =null;
        try {
            result=jp.proceed();//执行目标方法
        }catch (Throwable throwable){
            throwable.printStackTrace();
            logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，抛出了异常："+ throwable);
        }finally {
            logger.info("方法执行结束，调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，方法返回值："+result);
        }
    }
}




























