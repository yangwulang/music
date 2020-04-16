package top.yangwulang.panels;

import javax.swing.*;
import java.awt.*;

/**
 * @author yangwulang
 */
public class AboutPanel extends JPanel {
    public AboutPanel() {
        setLayout(null);

        JLabel title = new JLabel();
        title.setPreferredSize(new Dimension(100, 50));
        title.setBounds(500, 10, 100, 50);


        title.setText("大家好");
        title.setFont(new Font("Consolas常规", Font.BOLD, 30));
        Font defaultFont = new Font("Consolas常规", Font.PLAIN, 15);
        JLabel one = new JLabel("我是开发者： yangwulang");
        one.setFont(defaultFont);
        one.setBounds(10, 50, 600, 50);


        JLabel two = new JLabel("项            目：一个仿MacOS系统的swing项目，虽然说有点不像，但是好歹能用。");
        two.setFont(defaultFont);
        two.setBounds(10, 90, 600, 50);
        JLabel three = new JLabel("                       这里面用了flatlaf，不得不说它的主题真的好，虽然不怎么会用");
        three.setFont(defaultFont);
        three.setBounds(10, 130, 600, 50);
        add(title);
        add(one);
        add(two);
        add(three);
    }
}
