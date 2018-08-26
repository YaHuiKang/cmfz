package com.baizhi.kyh.aop;

import com.baizhi.kyh.enity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
@Configuration
@Aspect
public class LogAspect {
    @Pointcut(value = "execution(* com.baizhi.kyh.service.BannerService.*(..))")
    public void pointcut(){
    }

    @Around(value = "pointcut()")
    public Object arround(ProceedingJoinPoint pjp){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        User user = (User) session.getAttribute("user");
        Date date = new Date();
        String name = pjp.getSignature().getName();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        LogAnnotation annotation = signature.getMethod().getAnnotation(LogAnnotation.class);
        String annotationName = annotation.name();
        boolean flag = false;
        Object obj = null;
        try {
            obj= pjp.proceed();
            flag = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(annotationName);
        return obj;
    }
}
