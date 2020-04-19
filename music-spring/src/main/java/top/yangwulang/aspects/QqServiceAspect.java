package top.yangwulang.aspects;

import okhttp3.Callback;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import top.yangwulang.pojo.qq.SearchResultSongInfo;

/**
 * @author yangwulang
 */
@Component
@Aspect
@ComponentScan("top.yangwulang.services")
public class QqServiceAspect {
    private final Logger log = LoggerFactory.getLogger(QqServiceAspect.class);

    @Pointcut("execution(* top.yangwulang.services.QqService.searchSongAllInfo())")
    public void aspectSearch() {

    }
    @Before("aspectSearch()  && args(searchResultSongInfo, callback )")
    public void before(SearchResultSongInfo searchResultSongInfo, Callback callback){
        System.out.println(searchResultSongInfo);
    }

    @Around("aspectSearch()")
    public Object around(ProceedingJoinPoint point) {
        log.info("============QQ服务层开始进行环绕日志记录============");
        System.out.println("循环记录");
        Object proceed = null;
        try {
            proceed = point.proceed();
            log.info(proceed.toString());
        } catch (Throwable throwable) {
            log.info("QQ服务层环绕日志记录 异常 ==>{}", throwable.getMessage());
        }
        log.info("============QQ服务层结束环绕日志记录============");
        return proceed;
    }
}
