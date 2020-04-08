package top.yangwulang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import top.yangwulang.services.Test;
import top.yangwulang.utils.RequestsUtils;

/**
 * @author yangwulang
 */
@ComponentScan("top.yangwulang.service")
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
    public Test getTest(){
        return new Test();
    }
}
