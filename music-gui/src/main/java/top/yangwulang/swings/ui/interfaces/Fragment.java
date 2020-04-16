package top.yangwulang.swings.ui.interfaces;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author yangwulang
 */
@FunctionalInterface
public interface Fragment extends ComponentFragment<JFrame> {
    /**
     * 在当前的JFrame中添加控件
     *
     * @param frame 待添加控件的JFrame
     */
    @Override
    void print(JFrame frame);

    /**
     * 设置当前的界面圆角化
     *
     * @param jFrame 待圆角化的JFrame
     * @param radius 圆角化程度,越大则圆角程度越大
     */
    default void setFrameFillet(JFrame jFrame, double radius) {
        AWTUtilities.setWindowShape(jFrame,
                new RoundRectangle2D.Double(0.0D, 0.0D, jFrame.getWidth(), jFrame.getHeight(), radius, radius));
    }
}
