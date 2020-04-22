package top.yangwulang.panels;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.yangwulang.panels.indexpanel.RecommendPanel;
import top.yangwulang.panels.indexpanel.SongListPanel;
import top.yangwulang.swings.ui.CustomizeJavaButton;
import top.yangwulang.swings.ui.CustomizeJavaTextField;
import top.yangwulang.swings.ui.StartApplicationFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

/**
 * @author yangwulang
 * @date 2020/4/19 想将这个页的中心变成一个卡片布局,将所有的卡片放indexPanel这个包下(未实现)
 * @date 2020/4/22 已部分实现卡片布局，待新增面板
 */
public class IndexPanel extends JPanel {

    public IndexPanel() {
        //推荐
        setLayout(new BorderLayout());
        SearchPanel searchPanel = new SearchPanel();
        AnnotationConfigApplicationContext context = StartApplicationFactory.getContext();
        context.getBeanFactory().registerSingleton("searchPanel", searchPanel);

        Stack<String> jPanelStack = new Stack<>();
        context.getBeanFactory().registerSingleton("panelStack", jPanelStack);

        CustomizeJavaTextField searchField = context.getBean("searchField", CustomizeJavaTextField.class);
        CustomizeJavaButton searchButton = context.getBean("searchButton", CustomizeJavaButton.class);


        JPanel indexCenterPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        indexCenterPanel.setLayout(cardLayout);
        context.getBeanFactory().registerSingleton("indexCenterLayout", cardLayout);
        context.getBeanFactory().registerSingleton("indexCenterPanel", indexCenterPanel);

        //创建推荐页，将推荐页加入到indexCenterPanel的布局中
        RecommendPanel recommendPanel = new RecommendPanel();
        indexCenterPanel.add("recommendPanel", recommendPanel);

        SongListPanel songListPanel = new SongListPanel();
        indexCenterPanel.add("songListPanel", songListPanel);

        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.setSize(getWidth(), 200);
        //注入下边面板
        context.getBeanFactory().registerSingleton("bottomPanel", bottomPanel);
//专辑

        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jPanelStack.add("recommendPanel");
                cardLayout.show(indexCenterPanel, "songListPanel");
            }
        });

        add(indexCenterPanel, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
