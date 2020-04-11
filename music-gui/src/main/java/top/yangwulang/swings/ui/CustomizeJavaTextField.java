package top.yangwulang.swings.ui;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 * @author yangwulang
 */
public class CustomizeJavaTextField extends JTextField {
    private int width;
    private int height;

    public CustomizeJavaTextField() {
        setMargin(new Insets(0, 5, 0, 5));
    }

    public CustomizeJavaTextField(String text) {
        super(text);
    }

    public CustomizeJavaTextField(int columns) {
        super(columns);
    }

    public CustomizeJavaTextField(String text, int columns) {
        super(text, columns);
    }

    public CustomizeJavaTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
    }


    @Override
    protected void paintBorder(Graphics g) {
        int h = getHeight();
        // 从JComponent类获取高宽
        int w = getWidth();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawRoundRect(0, 0, w - 2, h - 2, 15, 15);
        g2d.dispose();
        super.paintBorder(g2d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        RoundRectangle2D.Double clip = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight() , 15D, 15D);
        //   GradientPaint paint = new GradientPaint(0, 0, new Color(255, 255, 255), getWidth() - 2, getHeight() -2, new Color(155, 255, 255));
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 15, 15);
        graphics2D.setClip(clip);
        super.paintComponent(graphics2D);
    }


    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        CustomizeJavaTextField customizeJavaTextField = new CustomizeJavaTextField();
        customizeJavaTextField.setBounds(100, 50, 300, 100);
        jFrame.setSize(500, 500);
        jFrame.setLayout(null);
        jFrame.add(customizeJavaTextField);
        jFrame.setVisible(true);
    }
}
