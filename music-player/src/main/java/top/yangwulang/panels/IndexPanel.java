package top.yangwulang.panels;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.yangwulang.swings.ui.CustomizeJavaButton;
import top.yangwulang.swings.ui.CustomizeJavaTextField;
import top.yangwulang.swings.ui.StartApplicationFactory;

import javax.swing.*;
import java.awt.*;

/**
 * @author yangwulang
 */
public class IndexPanel extends JPanel {
    private AnnotationConfigApplicationContext context = StartApplicationFactory.getContext();

    public IndexPanel() {
        setLayout(new BorderLayout());

        SearchPanel searchPanel = new SearchPanel();
        context.getBeanFactory().registerSingleton("searchPanel", searchPanel);

        CustomizeJavaTextField searchField = context.getBean("searchField", CustomizeJavaTextField.class);
        CustomizeJavaButton searchButton = context.getBean("searchButton", CustomizeJavaButton.class);

        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.setSize(getWidth(), 200);
        //注入下边面板
        context.getBeanFactory().registerSingleton("bottomPanel", bottomPanel);


        add(searchPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
