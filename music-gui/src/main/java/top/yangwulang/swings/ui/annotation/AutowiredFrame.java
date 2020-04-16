package top.yangwulang.swings.ui.annotation;


import java.lang.annotation.*;

/**
 * 注解形式从spring容器中获得{@link top.yangwulang.swings.ui.CustomizeJavaFrame},
 * 如果没有{@link top.yangwulang.swings.ui.CustomizeJavaFrame}它则会创建一个
 * {@link top.yangwulang.swings.ui.CustomizeJavaFrame}并赋值给字段。如果没有在spring指定具体名字
 * 则使用top.yangwulang.swings.ui.CustomizeJavaFrame+StartApplicationFactory.index命名
 *
 * @author yangwulang
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutowiredFrame {
    /**
     * 这是{@link top.yangwulang.swings.ui.CustomizeJavaFrame}的宽
     *
     * @return {@link top.yangwulang.swings.ui.CustomizeJavaFrame}的宽度
     */
    int width() default 0;

    /**
     * 这是{@link top.yangwulang.swings.ui.CustomizeJavaFrame}的高
     *
     * @return {@link top.yangwulang.swings.ui.CustomizeJavaFrame}的高度
     */
    int height() default 0;

    /**
     * 在容器中的名字
     *
     * @return {@link top.yangwulang.swings.ui.CustomizeJavaFrame}在容器中的名字
     */
    String frameName() default "";

}
