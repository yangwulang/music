package top.yangwulang.panels;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import top.yangwulang.swings.ui.CustomizeJavaButton;
import top.yangwulang.swings.ui.CustomizeJavaTextField;
import top.yangwulang.swings.ui.StartApplicationFactory;
import top.yangwulang.swings.ui.annotation.AutowiredButton;

import javax.swing.*;
import java.awt.*;

/**
 * @author yangwulang
 */
public class SearchPanel extends JPanel {
    private final CustomizeJavaTextField searchField = new CustomizeJavaTextField();
    @AutowiredButton(buttonName = "searchButton", options = 0.8f, text = "搜索", radius = 10, foreGround = {255, 250, 250}, backGround = {193, 205, 205})
    private static CustomizeJavaButton searchButton;


    public SearchPanel() {
        try {
            StartApplicationFactory.start(SearchPanel.class);
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel nullLabel = new JLabel();
        nullLabel.setPreferredSize(new Dimension(40, 60));

        ConfigurableListableBeanFactory beanFactory = StartApplicationFactory.getContext().getBeanFactory();
        beanFactory.registerSingleton("searchField", searchField);
        searchField.setPreferredSize(new Dimension(500, 60));

        JLabel searchLabel = new JLabel("搜索");


        add(nullLabel, BorderLayout.NORTH);
        add(searchLabel);
        add(searchField);
        add(searchButton);
    }
}
