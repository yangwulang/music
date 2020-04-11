package top.yangwulang.swings.ui;

import top.yangwulang.swings.ui.interfaces.BaseButton;
import top.yangwulang.swings.ui.interfaces.Fragment;
import top.yangwulang.swings.ui.interfaces.JavaFrame;

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
    private final CustomizeJavaDialog dialog = this;
    private final JavaFrame superFrame;
    private CustomizeJavaButton ok, cancel;
    private String bodyMessage;

    /**
     * 一个简单的提示消息框，输入信息与从哪个{@link CustomizeJavaFrame}中来,例如:
     * CustomizeJavaFrame customizeJavaFrame = new CustomizeJavaFrame();</br>
     * CustomizeJavaDialog dialog = new CustomizeJavaDialog("你好", customizeJavaFrame);</br>
     * 注:传入的这个customizeJavaFrame必须实现{@link JavaFrame}这个接口
     *
     * @param bodyMessage 提示信息
     * @param superFrame  调用的窗口
     */
    public CustomizeJavaDialog(String bodyMessage, JavaFrame superFrame) {
        this.superFrame = superFrame;
        this.bodyMessage = bodyMessage;
        initUi(null);
    }

    /**
     * 一个可自定义的提示消息框，可以直接new{@link Fragment}这个接口,也可以用这个{@link Fragment}接口的实例，
     * 重写{@link Fragment#print(JFrame)}方法,传入的参数就是当前的消息窗。
     * {@link CustomizeJavaFrame}表示调用者的窗口,例如:<br>
     * CustomizeJavaFrame customizeJavaFrame = new CustomizeJavaFrame();<br>
     * CustomizeJavaDialog dialog = new CustomizeJavaDialog("你好", customizeJavaFrame);<br>
     *
     * <p style="color:red">
     * <span style="color:white">注:</span>
     * 传入的这个customizeJavaFrame必须实现{@link JavaFrame}这个接口。<br>
     * 重写界面请不要动{@link BorderLayout#NORTH},这个是窗口最主要的部件,其他地区请随意,
     * 如果一定要用,请{@link BorderLayout#CENTER}中加入{@link BorderLayout}布局然后在使用其北部。<br>
     * </p>
     *
     * @param fragment   提示信息
     * @param superFrame 调用的窗口
     */
    public CustomizeJavaDialog(Fragment fragment, JavaFrame superFrame) {
        this.superFrame = superFrame;
        initUi(fragment);
    }

    /**
     * 初始化界面
     *
     * @param fragment 可重写的主界面的接口
     */
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
                    dialog.close();
                }
            });
            addCancelMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dialog.close();
                }
            });

            customizeJavaFrame.getCloseButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dialog.close();
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

    /**
     * 这是确定按钮的事件监听，此方法中必须执行消息框中的{@link CustomizeJavaDialog#close()}方法
     *
     * @param adapter 鼠标事件监听适配器
     */
    public void addOkMouseListener(MouseAdapter adapter) {
        ok.addMouseListener(adapter);
    }

    /**
     * 这是取消按钮的事件监听，此方法中必须执行消息框中的{@link CustomizeJavaDialog#close()}方法
     *
     * @param adapter 鼠标事件监听适配器
     */
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
     * 此方法已被禁用
     */
    @Override
    @Deprecated
    public void show() {
    }

    @Override
    public void setModal(boolean modal) {
        customizeJavaFrame.setAlwaysOnTop(true);
        System.out.println(modal);
        superFrame.setEnabled(false);
    }

    /**
     * 关闭当前对话框，同时释放传入进来的{@link JavaFrame},不管它是否被禁用
     */
    public void close() {
        superFrame.setEnabled(true);
        customizeJavaFrame.dispose();
    }
}
