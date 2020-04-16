package top.yangwulang.swings.ui;

import com.formdev.flatlaf.FlatLightLaf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.yangwulang.swings.ui.interfaces.ComponentFragment;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author yangwulang
 */
public class CustomizeJavaTextField extends JTextField {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private ComponentFragment<CustomizeJavaTextField> fragment;
    private int radius = 35;

    /**
     * 创建一个空的圆角<span style="color:red">(四个角)</span>输入框
     * 其光标距离左边有5个空格<span style="color:yellow">(应该是)</span>
     */
    public CustomizeJavaTextField() {
        this("");
    }

    public CustomizeJavaTextField(String text) {
        this(text, 0);
    }

    public CustomizeJavaTextField(int columns) {
        this("", columns);
    }

    public CustomizeJavaTextField(String text, int columns) {
        this(null, text, columns);
    }

    public CustomizeJavaTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
        setMargin(new Insets(0, 5, 0, 5));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        if (fragment != null) {
            fragment.print(this);
        } else {
            RoundRectangle2D.Double clip = new RoundRectangle2D.Double(0, 0, getWidth() - 10, getHeight() - 10, radius, radius);
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setClip(clip);
        }
        super.paintComponent(graphics2D);
        graphics2D.dispose();
    }

    /**
     * 重绘这个组件的样式,{@link ComponentFragment#print(Object)}这个是重写组件的接口,重写这个这个接口方法即可,print的参数是
     * 当前的{@link CustomizeJavaTextField}对象
     *
     * @param fragment 重绘接口
     */
    public void paintUi(ComponentFragment<CustomizeJavaTextField> fragment) {
        this.fragment = fragment;
    }

    /**
     * 设置{@link CustomizeJavaTextField}圆角的大小,值越大,边框就越圆,默认为35
     * 如果想要绘制成特殊形状的输入框请实现{@link CustomizeJavaTextField#paintUi(ComponentFragment)}方法
     * 自己画
     *
     * @param radius 圆角值
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

}
