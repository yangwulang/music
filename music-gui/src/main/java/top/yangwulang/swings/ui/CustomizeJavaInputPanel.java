package top.yangwulang.swings.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author yangwulang
 */
public class CustomizeJavaInputPanel extends JPanel {
    private Component component;
    private Color color;

    public CustomizeJavaInputPanel() {
    }

    public CustomizeJavaInputPanel(Component component, Color color) {
        this.component = component;
        this.color = color;
        add(component);
    }

    public CustomizeJavaInputPanel(Component component) {
        this(component, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    /**
     * 返回输入面板边框颜色，如果未设置则为灰色，否则为设置色
     *
     * @return 面板边框颜色
     */
    public Color getColor() {
        if (color == null) {
            return new Color(181, 181, 181);
        } else {
            return color;
        }
    }
}
