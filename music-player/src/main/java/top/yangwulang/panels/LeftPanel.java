package top.yangwulang.panels;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.yangwulang.PlayerMainPanel;
import top.yangwulang.swings.ui.CustomizeJavaPanel;
import top.yangwulang.swings.ui.StartApplicationFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * @author yangwulang
 */
public class LeftPanel extends CustomizeJavaPanel {

    public LeftPanel() {
    }

    @Override
    public void initUi() {
        AnnotationConfigApplicationContext context = StartApplicationFactory.getContext();


        JLabel nullLabel = new JLabel();
        nullLabel.setPreferredSize(new Dimension((int) getPreferredSize().getWidth(), 15));

        JLabel index = new JLabel("首页");
        JLabel local = new JLabel("本地");
        JLabel setting = new JLabel("设置");
        JLabel download = new JLabel("下载");
        JLabel about = new JLabel("关于");
        Dimension defaultSize = new Dimension((int) getPreferredSize().getWidth(), 50);

        index.setPreferredSize(defaultSize);
        local.setPreferredSize(defaultSize);
        download.setPreferredSize(defaultSize);
        about.setPreferredSize(defaultSize);
        setting.setPreferredSize(defaultSize);

        index.setHorizontalAlignment(SwingConstants.CENTER);
        local.setHorizontalAlignment(SwingConstants.CENTER);
        download.setHorizontalAlignment(SwingConstants.CENTER);
        about.setHorizontalAlignment(SwingConstants.CENTER);
        setting.setHorizontalAlignment(SwingConstants.CENTER);

        addDefaultMouseListener(index);
        addDefaultMouseListener(local);
        addDefaultMouseListener(download);
        addDefaultMouseListener(about);
        addDefaultMouseListener(setting);

        index.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout centerLayout = context.getBean("centerLayout", CardLayout.class);
                JPanel centerPanel = context.getBean("centerPanel", JPanel.class);
                centerLayout.show(centerPanel, "indexPanel");
            }
        });

        local.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout centerLayout = context.getBean("centerLayout", CardLayout.class);
                JPanel centerPanel = context.getBean("centerPanel", JPanel.class);
                centerLayout.show(centerPanel, "localPanel");
            }
        });

        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout centerLayout = context.getBean("centerLayout", CardLayout.class);
                JPanel centerPanel = context.getBean("centerPanel", JPanel.class);
                centerLayout.show(centerPanel, "aboutPanel");
            }
        });
        setting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CardLayout centerLayout = context.getBean("centerLayout", CardLayout.class);
                JPanel centerPanel = context.getBean("centerPanel", JPanel.class);
                centerLayout.show(centerPanel, "settingPanel");
            }
        });


        add(nullLabel);
        add(index);
        add(local);
        add(download);
        add(setting);
        add(about);
    }

    private void addDefaultMouseListener(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setOpaque(true);
                label.setBackground(new Color(255, 187, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setOpaque(true);
                label.setBackground(null);
            }
        });
    }
}
