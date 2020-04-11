package top.yangwulang.swings.ui.interfaces;

import top.yangwulang.swings.ui.CustomizeJavaButton;

/**
 * @author yangwulang
 */
public interface JavaFrame {
    /**
     * 获得{@link top.yangwulang.swings.ui.CustomizeJavaFrame}中顶部的最小按钮
     *
     * @return 返回最小按钮
     */
    CustomizeJavaButton getMinButton();

    /**
     * 获得{@link top.yangwulang.swings.ui.CustomizeJavaFrame}中顶部的最大按钮
     *
     * @return 返回最大按钮
     */
    CustomizeJavaButton getMaxButton();

    /**
     * 获得{@link top.yangwulang.swings.ui.CustomizeJavaFrame}中顶部的关闭按钮
     *
     * @return 返回关闭按钮
     */
    CustomizeJavaButton getCloseButton();

    /**
     * 设置窗口禁用
     *
     * @param v 禁用为true,不禁用为false
     */
    void setEnabled(boolean v);
}
