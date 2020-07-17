package com.cqupt.controller;

import com.cqupt.domain.SysLog;
import com.cqupt.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


//import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


@Component
@Aspect
public class LogAop {


    // 获取访问的ip地址
    // 在web。xml中配置 listener
//    @Autowired
//    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;// 开始时间
    private Class clazz; //访问的类
    private Method method; // 访问的类



    @Before("execution(* com.cqupt.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();
        // 具体要访问的类对象
        clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName(); // 获取访问的方法的名称
        Object[] args = joinPoint.getArgs(); // 获取访问方法的参数
        if(args == null || args.length ==0){
            method = clazz.getMethod(methodName);
        }else{
            Class[] classesArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classesArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName,classesArgs);
        }
    }


    // 后置通知
    @After("execution(* com.cqupt.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        // 获取访问时长
        long time = new Date().getTime() - visitTime.getTime();

        /*如何获取url
        * 使用反射
        * */
        String url = "";
        if(clazz != null && method != null && clazz == LogAop.class){
            // 1.获取类上的RequestMapping（0
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if(classAnnotation != null){
                String[] classValue = classAnnotation.value();

                // 2.获取方法上面的@RequestMapping(xxx)
                RequestMapping methodAnnotation = (RequestMapping) method.getAnnotation(RequestMapping.class);
                if(methodAnnotation != null){
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                }
            }
        }

        // 获取访问的ip地址
//        String ip = request.getRemoteAddr();


        // 获取访问的用户
        // 通过Spring Security提供的SecurityContext对象来获取
        SecurityContext context  = SecurityContextHolder.getContext();// 从上下文中获取当前登录的用户
        User user = (User) context.getAuthentication().getPrincipal();
        String userName = user.getUsername();


        // 将日志信息封装到SysLog对象里面
        SysLog sysLog = new SysLog();
        sysLog.setIp("这是个假ip");
        sysLog.setUrl(url);
        sysLog.setUsername(userName);
        sysLog.setVisitTime(visitTime);
        sysLog.setExecutionTime(time);
        sysLog.setMethod("[类名]"+clazz.getName() + "[方法名]" + method.getName());

        // 调用service完成日志数据的存取
        sysLogService.save(sysLog);
    }

}
