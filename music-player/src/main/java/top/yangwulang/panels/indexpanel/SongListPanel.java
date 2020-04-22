package top.yangwulang.panels.indexpanel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.yangwulang.swings.ui.StartApplicationFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

/**
 * 这是歌曲列表面板
 *
 * @author yangwulang
 * @date 2020/4/22 这是歌曲列表专用于下部列表展示勿在此类中刻画歌手或者歌单信息,
 * 这个面板想出一个分页条(数据实在太多)(能实现则实现，不行则慢慢搞)，
 * 列表展示歌曲名  歌手  时长(没找到规律，暂放)  最后在后面加上播放和下载按钮
 */
public class SongListPanel extends JPanel {
    public SongListPanel() {
        AnnotationConfigApplicationContext context = StartApplicationFactory.getContext();
        Stack<String> panelStack = context.getBean("panelStack", Stack.class);
        JButton backButton = new JButton("回退");
        JPanel indexCenterPanel = context.getBean("indexCenterPanel", JPanel.class);
        CardLayout indexCenterLayout = context.getBean("indexCenterLayout", CardLayout.class);

        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                indexCenterLayout.show(indexCenterPanel, panelStack.pop());
            }
        });

        add(backButton);
    }
}
