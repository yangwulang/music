package top.yangwulang.swings.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author yangwulang
 */
public class CustomizeJavaLabel extends JLabel {
    private ImageIcon imageIcon;
    private int width;
    private int height;
    private int radius = 50;
    private final Logger log = LoggerFactory.getLogger(CustomizeJavaLabel.class);

    public CustomizeJavaLabel() {

    }

    public CustomizeJavaLabel(String path, int width, int height, int radius) {
        try {
            URL url = new URL(path);
            log.info("CustomizeJavaLabel 加载图片 地址为 : {}", url.toString());
            imageIcon = new ImageIcon(url, "");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RoundRectangle2D.Double clip = new RoundRectangle2D.Double(0, 0, getWidth() - 10, getHeight() - 10, radius, radius);
        graphics2D.setClip(clip);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        setIcon(imageIcon);
        super.paint(g);
    }

    @Override
    public Insets getInsets() {
        return new Insets(5, 5, 5, 5);
    }
}
