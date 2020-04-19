package top.yangwulang.swings.ui;

import com.formdev.flatlaf.IntelliJTheme;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import top.yangwulang.config.BaseConfig;
import top.yangwulang.swings.factory.ButtonFactory;
import top.yangwulang.swings.factory.FrameFactory;

import java.lang.reflect.Field;


/**
 * @author yangwulang
 */
@ComponentScan("top.yangwulang.swings.ui.config")
public class StartApplicationFactory {
    private final static AnnotationConfigApplicationContext CONTEXT = new AnnotationConfigApplicationContext(BaseConfig.class);
    public static int index = 0;

    static {
        //刷新spring上下文,以方便在后续进行自定义名字注册bean到spring容器中
        IntelliJTheme.install(StartApplicationFactory.class.getResourceAsStream("/json/light.json"));
    }

    public static void start(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        for (Field declaredField : clazz.getDeclaredFields()) {
            if (CustomizeJavaFrame.class.isAssignableFrom(declaredField.getType())) {
                FrameFactory.build(clazz, declaredField, CONTEXT);
            } else if (CustomizeJavaButton.class.isAssignableFrom(declaredField.getType())) {
                ButtonFactory.build(clazz, declaredField, CONTEXT);
            }
        }
    }

    /**
     * 获取spring容器
     *
     * @return spring容器
     */
    public static AnnotationConfigApplicationContext getContext() {
        return CONTEXT;
    }
}
