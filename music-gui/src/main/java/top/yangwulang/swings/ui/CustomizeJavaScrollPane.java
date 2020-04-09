package top.yangwulang.swings.ui;

import top.yangwulang.swings.ui.interfaces.ComponentFragment;

import javax.swing.*;
import java.awt.*;

/**
 * @author yangwulang
 */
public class CustomizeJavaScrollPane extends JScrollPane {

    public CustomizeJavaScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
        super(view, vsbPolicy, hsbPolicy);
        setBarUi(null);
    }

    public CustomizeJavaScrollPane(Component view) {
        super(view);
        setBarUi(null);
    }

    public CustomizeJavaScrollPane(int vsbPolicy, int hsbPolicy) {
        super(vsbPolicy, hsbPolicy);
        setBarUi(null);
    }

    public CustomizeJavaScrollPane() {
        setBarUi(null);
    }

    /**
     * 创建滚动面板，并修改其中滚动条的样式
     *
     * @param componentFragment s
     */
    public CustomizeJavaScrollPane(ComponentFragment<CustomizeJavaScrollPane> componentFragment) {
        setBarUi(componentFragment);
    }

    /**
     * 创建滚动面板，并修改其中滚动条的样式和增加组件到面板中
     *
     * @param componentFragment s
     * @param view              组件面板
     */
    public CustomizeJavaScrollPane(ComponentFragment<CustomizeJavaScrollPane> componentFragment, Component view) {
        super(view);
        setBarUi(componentFragment);
    }

    /**
     * 设置滚动条的样式,可以自行修改不适用默认样式,只需要实现{@link ComponentFragment#print(Object)}方法,
     * 在其中调用{@link CustomizeJavaScrollPane#getVerticalScrollBar()#setBarUi(ComponentFragment)}
     * 或者{@link CustomizeJavaScrollPane#getVerticalScrollBar()#setBarUi(ComponentFragment)}
     *
     * @param fragment 待修改的样式
     */
    private void setBarUi(ComponentFragment<CustomizeJavaScrollPane> fragment) {
        if (fragment != null) {
            fragment.print(this);
        } else {
            getVerticalScrollBar().setUI(new CustomizeJavaScrollBar());
            getHorizontalScrollBar().setUI(new CustomizeJavaScrollBar());
        }
    }
}
