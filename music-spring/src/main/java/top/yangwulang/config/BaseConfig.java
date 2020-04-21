package top.yangwulang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import top.yangwulang.aspects.QqServiceAspect;
import top.yangwulang.services.QqService;
import top.yangwulang.services.Test;
import top.yangwulang.utils.RequestsUtils;

/**
 * spring的配置类
 *
 * @author yangwulang
 * @date 2020/4/19 本来想在其中加入日志，不知何缘故能将Aspect类扫描进spring但是切面无效果(待修复)
 */

@ComponentScans(value = {
        @ComponentScan("top.yangwulang.aspects")
})
public class BaseConfig {
    /**
     * 构造请求工具类，将其注入到spring中
     *
     * @return 工具类实例
     */
    @Bean
    public RequestsUtils getRequest() {
        return new RequestsUtils();
    }

    @Bean
    public Test getTest() {
        return new Test();
    }


}
