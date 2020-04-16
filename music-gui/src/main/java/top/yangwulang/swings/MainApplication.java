package top.yangwulang.swings;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.IntelliJTheme;
import top.yangwulang.swings.ui.*;
import top.yangwulang.swings.ui.annotation.AutowiredFrame;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.io.IOException;

/**
 * @author yangwulang
 */
public class MainApplication {
    @AutowiredFrame(width = 1000, height = 500)
    private static CustomizeJavaFrame customizeJavaFrame;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        StartApplicationFactory.start(MainApplication.class);

        IntelliJTheme.install(MainApplication.class.getResourceAsStream("/json/light.json"));
        UIManager.put("Button.arc", 15);
        customizeJavaFrame.setTitle("你好");

        customizeJavaFrame.startToPrintMainBody(frame -> {
            JPanel jPanel = new JPanel();
            CustomizeJavaTextField customizeJavaTextField = new CustomizeJavaTextField();
            customizeJavaTextField.setPreferredSize(new Dimension(300, 60));
            jPanel.add(customizeJavaTextField);
/*            DefaultMutableTreeNode mutableTreeNode = new DefaultMutableTreeNode();
            for (int i = 0; i < 40; i++) {
                mutableTreeNode.add(new DefaultMutableTreeNode());
            }
            JTree tree = new JTree(mutableTreeNode);
            CustomizeJavaScrollPane customizeJavaScrollPane = new CustomizeJavaScrollPane(tree);
            customizeJavaScrollPane.setPreferredSize(new Dimension(200, 300));
            jPanel.add(customizeJavaScrollPane);*/
            frame.add(jPanel);
        });
        customizeJavaFrame.setVisible(true);
    }
}
