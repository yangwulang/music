package top.yangwulang.swings.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;
import top.yangwulang.swings.ui.CustomizeJavaButton;
import top.yangwulang.swings.ui.CustomizeJavaFrame;
import top.yangwulang.swings.ui.StartApplicationFactory;
import top.yangwulang.swings.ui.annotation.AutowiredButton;

import java.awt.*;
import java.lang.reflect.Field;

/**
 * @author yangwulang
 */
public class ButtonFactory {
    public static void build(Class<?> clazz, Field field, AnnotationConfigApplicationContext context) throws IllegalAccessException {
        AutowiredButton annotation = field.getAnnotation(AutowiredButton.class);
        String buttonName = annotation.buttonName();
        if (StringUtils.isEmpty(annotation.buttonName())) {
            buttonName = field.getType().getName() + StartApplicationFactory.index;
            StartApplicationFactory.index += 1;
        }
        Color foreGround = new Color(annotation.foreGround()[0], annotation.foreGround()[1], annotation.foreGround()[2]);
        Color backGround = new Color(annotation.backGround()[0], annotation.backGround()[1], annotation.backGround()[2]);
        CustomizeJavaButton button = new CustomizeJavaButton(annotation.style(), annotation.options(), annotation.radius(), foreGround, backGround);
        context.getBeanFactory().registerSingleton(buttonName, button);
        context.start();
        CustomizeJavaButton bean = context.getBean(buttonName, CustomizeJavaButton.class);
        bean.setText(annotation.text());
        field.setAccessible(true);
        field.set(clazz, bean);
    }
}
