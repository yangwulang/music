package top.yangwulang.swings.ui;

import top.yangwulang.swings.ui.interfaces.BasePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 上图下文字型
 *
 * @author yangwulang
 * @date 2020/4/20 未实现圆角
 */
public class CustomizeJavaImagePanel extends JPanel implements BasePanel {
    private final int height;
    private final int width;
    private final String imgPath;
    private final int radius;
    private final String title;


    public CustomizeJavaImagePanel(String imgPath, String title, int width, int height, int radius) {
        this.imgPath = imgPath;
        this.width = width;
        this.height = height;
        this.radius = radius;
        this.title = title;
    }


    @Override
    public void initUi() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        CustomizeJavaLabel customizeJavaLabel = new CustomizeJavaLabel(imgPath, width - 30, height - 30, radius);
        customizeJavaLabel.setPreferredSize(new Dimension(width - 30, height - 30));
        JPanel mainPanel = new JPanel();
        mainPanel.add(customizeJavaLabel);
        mainPanel.setPreferredSize(new Dimension(width, height - 30));

        setPreferredSize(new Dimension(width, height));

        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel(this.title);

        titlePanel.setPreferredSize(new Dimension(width, 30));
        title.setPreferredSize(new Dimension(titlePanel.getPreferredSize().width, titlePanel.getPreferredSize().height));
        title.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(title);

        add(mainPanel);
        add(titlePanel);
    }
}
