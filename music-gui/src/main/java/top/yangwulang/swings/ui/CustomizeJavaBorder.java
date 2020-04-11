package top.yangwulang.swings.ui;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * 自定义圆角边框
 *
 * @author yangwulang
 */
public class CustomizeJavaBorder extends AbstractBorder {
    private Color color;

    public CustomizeJavaBorder() {

    }

    public CustomizeJavaBorder(Color color) {
        this.color = color;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(color);
        g.drawRoundRect(0, 0, c.getWidth() - 10, c.getHeight() - 1, 12, 12);
    }

}
