package top.yangwulang.swings.ui.interfaces;

import java.awt.*;

/**
 * @author yangwulang
 */
public interface BaseButton {
    /**
     * 默认按钮前景色
     */
    Color DEFAULT_BUTTON_FOREGROUND_COLOR = new Color(205, 255, 205);
    /**
     * 默认按钮背景色
     */
    Color DEFAULT_BUTTON_BACKGROUND_COLOR = new Color(88, 87, 125);
    /**
     * 最大透明度
     */
    float MAX_OPTION = 1F;
    /**
     * 最小透明度
     */
    float MIN_OPTION = 0F;

    int ROUND_RECT = 0;
    int LEFT_ROUND_RECT = 1;
    int RIGHT_ROUND_RECT = 2;
    int BALL = 3;
    int STAR = 4;
}
