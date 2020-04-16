package top.yangwulang.swings.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;
import top.yangwulang.swings.ui.CustomizeJavaFrame;
import top.yangwulang.swings.ui.StartApplicationFactory;
import top.yangwulang.swings.ui.annotation.AutowiredFrame;

import java.lang.reflect.Field;

/**
 * @author yangwulang
 */
public class FrameFactory{

    /**
     * 解析{@link AutowiredFrame}注解信息，将值赋给对应的字段
     *
     * @param clazz 类所对应的Class
     * @param field 对应的字段
     * @throws IllegalAccessException 赋值时所抛出的异常
     */
    public static void build(Class<?> clazz, Field field, AnnotationConfigApplicationContext context) throws IllegalAccessException {
        AutowiredFrame annotation = field.getAnnotation(AutowiredFrame.class);
        String frameName = annotation.frameName();
        if (StringUtils.isEmpty(annotation.frameName())) {
            frameName = field.getType().getName() + StartApplicationFactory.index;
            StartApplicationFactory.index += 1;
        }
        context.getBeanFactory().registerSingleton(frameName, new CustomizeJavaFrame());
        context.start();
        CustomizeJavaFrame bean = context.getBean(frameName, CustomizeJavaFrame.class);
        bean.setSize(annotation.width(), annotation.height());
        field.setAccessible(true);
        field.set(clazz, bean);
    }
}
