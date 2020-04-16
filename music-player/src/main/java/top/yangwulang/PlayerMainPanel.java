package top.yangwulang;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import top.yangwulang.panels.*;
import top.yangwulang.swings.ui.*;
import top.yangwulang.swings.ui.annotation.AutowiredFrame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Hello world!
 *
 * @author yangwulang
 */
public class PlayerMainPanel {
    @AutowiredFrame(width = 1300, height = 800, frameName = "frame")
    private static CustomizeJavaFrame frames;

    public PlayerMainPanel() {
        frames.startToPrintMainBody(frame -> {
            ConfigurableListableBeanFactory beanFactory = StartApplicationFactory.getContext().getBeanFactory();

            CardLayout centerLayout = new CardLayout();

            //主面板
            JPanel jPanel = new JPanel();
            BorderLayout layout = new BorderLayout();
            jPanel.setLayout(layout);
            jPanel.setOpaque(true);
            jPanel.setBackground(Color.magenta);

            LeftPanel left = new LeftPanel();
            left.setPreferredSize(new Dimension(200, jPanel.getHeight()));
            left.initUi();
            //注入左边面板
            beanFactory.registerSingleton("leftPanel", left);




            IndexPanel indexPanel = new IndexPanel();
            //注入首页面板
            beanFactory.registerSingleton("indexPanel", indexPanel);

            LocalPanel localPanel = new LocalPanel();
            //注入本地面板
            beanFactory.registerSingleton("localPanel", localPanel);

            AboutPanel aboutPanel = new AboutPanel();
            //注入关于面板
            beanFactory.registerSingleton("aboutPanel", aboutPanel);

            SettingPanel settingPanel = new SettingPanel();
            //注入设置面板
            beanFactory.registerSingleton("settingPanel", settingPanel);

            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(centerLayout);
            centerPanel.add("indexPanel", indexPanel);
            centerPanel.add("localPanel", localPanel);
            centerPanel.add("aboutPanel", aboutPanel);
            centerPanel.add("settingPanel", settingPanel);
            //将主要的中心区域面板设置为卡片布局注入spring中
            beanFactory.registerSingleton("centerPanel", centerPanel);
            //将卡片布局注入spring中，以方便在其他面板用其对象
            beanFactory.registerSingleton("centerLayout", centerLayout);

            jPanel.add(centerPanel, BorderLayout.CENTER);
//            jPanel.add(bottomPanel, BorderLayout.SOUTH);

            frame.add(jPanel, BorderLayout.CENTER);
            frame.add(left, BorderLayout.WEST);
        });
        frames.setVisible(true);
    }

    @SuppressWarnings("all")
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        StartApplicationFactory.start(PlayerMainPanel.class);
        SwingUtilities.invokeLater(() -> {
            new PlayerMainPanel();
        });
    }
}
