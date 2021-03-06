package top.yangwulang.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author yangwulang
 */
@Component
@Aspect
@ComponentScan("top.yangwulang.services")
public class QqServiceAspect {
    private final Logger log = LoggerFactory.getLogger(QqServiceAspect.class);

    @Pointcut("execution(* top.yangwulang.services.QqService.*(..))")
    public void aspectSearch() {

    }

    @Before("aspectSearch()")
    public void before() {
        log.info("前置通知");
    }

    @Around("aspectSearch()")
    public Object around(ProceedingJoinPoint point) {
        log.info("============QQ服务层开始进行环绕日志记录============");
        Object proceed = null;
        try {
            proceed = point.proceed();
            for (Object arg : point.getArgs()) {
                log.info("参数 ==> {}", arg);
            }
        } catch (Throwable throwable) {
            log.info("QQ服务层环绕日志记录 异常 ==>{}", throwable.getMessage());
            throwable.printStackTrace();
        }
        log.info("==============QQ服务层结束环绕日志记录==============");
        return proceed;
    }
}
