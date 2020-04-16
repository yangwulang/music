package top.yangwulang.swings.ui.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.yangwulang.swings.ui.CustomizeJavaFrame;

/**
 * @author yangwulang
 */
@Configuration
public class SwingConfig {

    @Bean
    public CustomizeJavaFrame getCustomizeJavaFrame() {
        return new CustomizeJavaFrame();
    }
}
