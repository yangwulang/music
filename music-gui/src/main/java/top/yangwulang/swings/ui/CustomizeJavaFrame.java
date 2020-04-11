package top.yangwulang.swings.ui;

import top.yangwulang.swings.ui.interfaces.Fragment;
import top.yangwulang.swings.ui.interfaces.JavaFrame;
import top.yangwulang.swings.ui.interfaces.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author yangwulang
 */
public class CustomizeJavaFrame extends JFrame implements Window, JavaFrame {
    private final Point org = new Point();
    private final JFrame frame = this;
    private final JPanel panel = new JPanel();
    private int thisWidth = 0;
    private int thisHeight = 0;
    private Fragment fragment;
    /**
     * 记录最大化按钮是否按过,默认没按过
     */
    private boolean maxButtonIsClicked = false;
    private String title = "";
    private JLabel titleLabel;

    private CustomizeJavaButton min;
    private CustomizeJavaButton max;
    private CustomizeJavaButton close;


    public CustomizeJavaFrame() {
        //无边框
        this.setUndecorated(true);
    }

    @Override
    public void setSize(int width, int height) {
        super.setSize(width, height);
        this.thisWidth = width;
        this.thisHeight = height;
    }

    /**
     * 初始化面板，设置面板在最中间，能拖动，整体样式
     */
    private void init() {
        getRootPane().setBorder(new CustomizeJavaBorder(new Color(0, 255, 0)));
        setFrameCenter();
        setCanMove();
        writeTopPanel();
    }


    /**
     * 窗口居中
     */
    private void setFrameCenter() {
        this.setBounds((WINDOW_WIDTH - thisWidth) / 2,
                (WINDOW_HEIGHT - thisHeight) / 2, thisWidth, thisHeight);
    }

    public void startToPrintMainBody(Fragment fragment) {
        startToPrintMainBody(fragment, TitleButton.OTHER);
    }

    /**
     * 启动重写主面板，实现{@link Fragment}或者直接将{@link Fragment}进行new,
     * 重写里面的{@link Fragment#print(JFrame)}方法进行改写注面板
     *
     * @param fragment    主面板接口
     * @param titleButton 禁用三个主要面板中的一个，使之变成灰色并且无功能，有
     *                    <br>{@link TitleButton#MIN}最小化</br>
     *                    <br>{@link TitleButton#MAX}最大化</br>
     *                    <br>{@link TitleButton#CLOSE}关闭</br>
     *                    <br>{@link TitleButton#OTHER}其他按钮，如果不禁用可使用此枚举</br>
     */
    public void startToPrintMainBody(Fragment fragment, TitleButton titleButton) {
        enableTitleButton(titleButton);
        init();
        this.fragment = fragment;
        fragment.setFrameFillet(this, 30D);
        fragment.print(this);
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 写入主要外形框架例如上界面面板和整体的面板样式
     */
    private void writeTopPanel() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT);

        titleLabel = new JLabel(title);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Consolas常规", Font.PLAIN, 18));


        Dimension defaultDimension = new Dimension(20, 20);
        min.setPreferredSize(defaultDimension);
        max.setPreferredSize(defaultDimension);
        close.setPreferredSize(defaultDimension);

        panel.add(min);
        panel.add(max);
        panel.add(close);

        setTitleLabel(thisWidth - ((min.getPreferredSize().width + 30) * 4));

        flowLayout.setHgap(20);
        flowLayout.setVgap(10);
        panel.setLayout(flowLayout);
        panel.setPreferredSize(new Dimension(thisWidth, 40));

        this.add(panel, BorderLayout.NORTH);
    }

    private void setCanMove() {
        //让他能够移动
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                org.x = e.getX();
                org.y = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point points = frame.getLocation();
                frame.setLocation(points.x + e.getX() - org.x, points.y + e.getY() - org.y);
            }
        });

    }

    private void setListener() {
        maxMouseListener();
        minMouseListener();
        closeMouseListener();
    }

    @Override
    public void paintComponents(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 15, 15);
        super.paintComponents(g);
    }

    private void maxMouseListener() {
        max.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //判断最大化按钮是否被点击过
                if (maxButtonIsClicked) {
                    maxButtonIsClicked = false;
                    setFrameCenter();
                    setTitleLabel(thisWidth - ((min.getPreferredSize().width + 30) * 4));
                    frame.setPreferredSize(new Dimension(thisWidth, thisHeight));
                } else {
                    maxButtonIsClicked = true;
                    setTitleLabel(WINDOW_WIDTH - ((min.getPreferredSize().width + 30) * 4));
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }
                fragment.setFrameFillet(frame, 30D);
            }
        });
    }

    private void minMouseListener() {
        min.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(JFrame.ICONIFIED);
            }
        });
    }

    private void closeMouseListener() {
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
            }
        });
    }

    /**
     * 传入宽度创建一个高度为40，宽度自定义的JLabel,并将其添加到panel中
     *
     * @param width JLabel的宽
     */
    private void setTitleLabel(int width) {
        titleLabel.setPreferredSize(new Dimension(width, 40));
        panel.add(titleLabel);
    }

    /**
     * 禁用TitleButton所对应的按钮
     *
     * @param titleButton 待禁的按钮
     */
    public void enableTitleButton(TitleButton titleButton) {
        Color color1 = new Color(130, 130, 130);
        Color color2 = new Color(79, 79, 79);
        switch (titleButton) {
            case MIN:
                max = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(255, 227, 132), new Color(255, 128, 0));
                close = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(255, 0, 0), new Color(255, 127, 80));
                min = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, color1, color2);
                min.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }
                });
                maxMouseListener();
                closeMouseListener();
                break;
            case MAX:
                min = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(0, 255, 0), new Color(127, 255, 0));
                close = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(255, 0, 0), new Color(255, 127, 80));
                max = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, color1, color2);
                max.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }
                });
                minMouseListener();
                closeMouseListener();
                break;
            case CLOSE:
                min = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(0, 255, 0), new Color(127, 255, 0));
                max = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(255, 227, 132), new Color(255, 128, 0));
                close = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, color1, color2);
                close.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }
                });
                minMouseListener();
                maxMouseListener();
                break;
            default:
                min = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(0, 255, 0), new Color(127, 255, 0));
                max = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(255, 227, 132), new Color(255, 128, 0));
                close = new CustomizeJavaButton(CustomizeJavaButton.ROUND_RECT, 0.5F, 20, new Color(255, 0, 0), new Color(255, 127, 80));
                minMouseListener();
                maxMouseListener();
                closeMouseListener();
                break;
        }
    }

    @Override
    public CustomizeJavaButton getMinButton() {
        return this.min;
    }

    @Override
    public CustomizeJavaButton getMaxButton() {
        return this.max;
    }

    @Override
    public CustomizeJavaButton getCloseButton() {
        return this.close;
    }

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);
    }
}
