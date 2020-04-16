package top.yangwulang.swings.ui.annotation;

import top.yangwulang.swings.ui.interfaces.BaseButton;

import java.lang.annotation.*;

/**
 * 注解形式从spring容器中获得{@link top.yangwulang.swings.ui.CustomizeJavaButton},
 * 如果没有{@link top.yangwulang.swings.ui.CustomizeJavaButton}它则会创建一个
 * {@link top.yangwulang.swings.ui.CustomizeJavaButton}并赋值给字段。如果没有在spring指定具体名字
 * 则使用top.yangwulang.swings.ui.CustomizeJavaButton+StartApplicationFactory.index命名
 *
 * @author yangwulang
 */
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AutowiredButton {
    /**
     * 设置{@link top.yangwulang.swings.ui.CustomizeJavaButton}的样式
     * 样式在{@link BaseButton}中
     *
     * @return 按钮的样式
     */
    int style() default BaseButton.ROUND_RECT;

    /**
     * 按钮在spring容器中的名字
     *
     * @return s
     */
    String buttonName() default "";

    /**
     * 设置按钮的文字
     *
     * @return 按钮的文字
     */
    String text() default "";

    /**
     * 设置按钮的透明度
     *
     * @return 按钮透明度
     */
    float options() default 0.5f;

    /**
     * 设置圆角
     *
     * @return 按钮圆角值
     */
    int radius() default 20;

    /**
     * 设置按钮前景色(渐变前景)
     * <span style="color:red">只能三个数值!!!</span>
     *
     * @return s
     */
    int[] foreGround() default {205, 255, 205};

    /**
     * 设置按钮背景色(渐变背景)
     * <span style="color:red">只能三个数值!!!</span>
     *
     * @return s
     */
    int[] backGround() default {88, 87, 125};
}
