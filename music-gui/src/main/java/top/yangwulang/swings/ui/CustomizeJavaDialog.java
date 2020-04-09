package top.yangwulang.swings.ui;

import top.yangwulang.swings.ui.interfaces.BaseButton;
import top.yangwulang.swings.ui.interfaces.Fragment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 自定义的dialog框,禁止了最大化
 *
 * @author yangwulang
 */
public class CustomizeJavaDialog extends JDialog {
    private final CustomizeJavaFrame customizeJavaFrame = new CustomizeJavaFrame();
    private CustomizeJavaButton ok, cancel;
    private String bodyMessage;

    public CustomizeJavaDialog(String bodyMessage) {
        this.bodyMessage = bodyMessage;
        initUi(null);
    }

    public CustomizeJavaDialog(Fragment fragment) {
        initUi(fragment);
    }


    private void initUi(Fragment fragment) {
        customizeJavaFrame.setSize(500, 300);
        customizeJavaFrame.startToPrintMainBody(frame -> {

            if (fragment == null) {
                JLabel label = new JLabel(bodyMessage);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                frame.add(label, BorderLayout.CENTER);
            } else {
                fragment.print(customizeJavaFrame);
            }
            ok = new CustomizeJavaButton(BaseButton.ROUND_RECT, 0.5F, 20,
                    new Color(156, 156, 156), new Color(141, 238, 238));
            cancel = new CustomizeJavaButton(BaseButton.ROUND_RECT, 0.5F, 20,
                    new Color(156, 156, 156), new Color(141, 238, 238));
            ok.setText("确定");
            cancel.setText("取消");
            Dimension dimension = new Dimension(80, 30);
            ok.setPreferredSize(dimension);
            cancel.setPreferredSize(dimension);

            addOkMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    customizeJavaFrame.dispose();
                }
            });
            addCancelMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    customizeJavaFrame.dispose();
                }
            });

            FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);
            flowLayout.setHgap(15);
            flowLayout.setVgap(15);

            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(flowLayout);
            bottomPanel.add(ok);
            bottomPanel.add(cancel);
            frame.add(bottomPanel, BorderLayout.SOUTH);
        }, TitleButton.MAX);
    }

    public void addOkMouseListener(MouseAdapter adapter) {
        ok.addMouseListener(adapter);
    }

    public void addCancelMouseListener(MouseAdapter adapter) {
        cancel.addMouseListener(adapter);
    }

    @Override
    public void setTitle(String title) {
        customizeJavaFrame.setTitle(title);
    }

    /**
     * 显现对话框
     */
    public void showDialog() {
        customizeJavaFrame.setVisible(true);
    }

    /**
     * 关闭当前对话框
     */
    public void close() {
        customizeJavaFrame.dispose();
    }
}
