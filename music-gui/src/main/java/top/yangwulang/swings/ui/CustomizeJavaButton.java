package top.yangwulang.swings.ui;

import top.yangwulang.swings.exception.OutOptionException;
import top.yangwulang.swings.ui.interfaces.BaseButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;

/**
 * @author yangwulang
 */
public class CustomizeJavaButton extends JButton implements BaseButton {
    private boolean hover;
    private final int style;
    private int width;
    private int height;
    private final int radius;
    private float options = 0F;
    private Color foreGround;
    private Color backGround;


    public CustomizeJavaButton() {
        this(ROUND_RECT, 0.5F, 20, null, null);
    }

    public CustomizeJavaButton(int style, float options, int radius, Color foreGround, Color backGround) {
        this.style = style;
        try {
            setOptions(options);
        } catch (OutOptionException e) {
            e.printStackTrace();
        }
        //如果未指定颜色使用默认颜色
        if (foreGround == null) {
            this.foreGround = DEFAULT_BUTTON_FOREGROUND_COLOR;
        } else {
            this.foreGround = foreGround;
        }
        if (backGround == null) {
            this.backGround = DEFAULT_BUTTON_BACKGROUND_COLOR;
        } else {
            this.backGround = backGround;
        }
        this.radius = radius;
        initUi();
    }

    private void initUi() {
        if (BALL == style) {
            setPreferredSize(new Dimension(42, 42));
        } else if (STAR == style) {
            setPreferredSize(new Dimension(42, 42));
        }
        setFont(new Font("system", Font.PLAIN, 12));
        setBorderPainted(false);
        setForeground(DEFAULT_BUTTON_BACKGROUND_COLOR);
        setFocusPainted(false);
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(DEFAULT_BUTTON_FOREGROUND_COLOR);
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(DEFAULT_BUTTON_BACKGROUND_COLOR);
                hover = false;
                repaint();
            }
        });
    }

    public int getRadius() {
        return radius;
    }

    public Color getForeGround() {
        return foreGround;
    }

    public void setForeGround(Color foreGround) {
        this.foreGround = foreGround;
    }

    public Color getBackGround() {
        return backGround;
    }

    public void setBackGround(Color backGround) {
        this.backGround = backGround;
    }

    public void setOptions(float options) throws OutOptionException {
        if (options > MAX_OPTION || options < MIN_OPTION) {
            throw new OutOptionException("透明度超出限度 options ==> " + options);
        }
        this.options = options;
    }

    public float getOptions() {
        return this.options;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g.create();
        this.width = getWidth();
        this.height = getHeight();
        float tran = 1F;
        if (!hover) {
            tran = getOptions();
        }
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint p1;
        GradientPaint p2;
        if (getModel().isPressed()) {
            p1 = new GradientPaint(0, 0, new Color(0, 0, 0), 0, height - 1,
                    new Color(100, 100, 100));
            p2 = new GradientPaint(0, 1, new Color(0, 0, 0, 50), 0, height - 3,
                    new Color(255, 255, 255, 100));
        } else {
            p1 = new GradientPaint(0, 0, new Color(100, 100, 100), 0, height - 1,
                    new Color(0, 0, 0));
            p2 = new GradientPaint(0, 1, new Color(255, 255, 255, 100), 0,
                    height - 3, new Color(0, 0, 0, 50));
        }
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                tran));
        GradientPaint gp = new GradientPaint(0.0F, 0.0F, foreGround, 0.0F,
                height, backGround, true);
        graphics2D.setPaint(gp);
        switch (style) {
            case ROUND_RECT: {
                roundRect(graphics2D, p1, p2);
                break;
            }
            case LEFT_ROUND_RECT: {
                leftRoundRect(graphics2D, p1, p2);
                break;
            }
            case RIGHT_ROUND_RECT: {
                rightRoundRect(graphics2D, p1, p2);
                break;
            }
            case BALL: {
                ball(graphics2D, p1, p2);
                break;
            }
            case STAR: {
                star(graphics2D, p1, p2);
                break;
            }
            default:
                break;
        }
        graphics2D.dispose();
        super.paintComponent(g);
    }

    private void roundRect(Graphics2D graphics2D, GradientPaint p1, GradientPaint p2) {
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
                width - 1, height - 1, radius, radius);
        Shape clip = graphics2D.getClip();
        graphics2D.clip(r2d);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setClip(clip);
        graphics2D.setPaint(p1);
        graphics2D.drawRoundRect(0, 0, width - 1, height - 1, radius, radius);
        graphics2D.setPaint(p2);
        graphics2D.drawRoundRect(1, 1, width - 3, height - 3, 10, 10);
    }

    private void leftRoundRect(Graphics2D graphics2D, GradientPaint p1, GradientPaint p2) {
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0,
                (width - 1) + 20, height - 1, radius, radius);
        Shape clip = graphics2D.getClip();
        graphics2D.clip(r2d);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setClip(clip);
        graphics2D.setPaint(p1);
        graphics2D.drawRoundRect(0, 0, (width - 1) + 20, height - 1, radius, radius);
        graphics2D.setPaint(p2);
        graphics2D.drawRoundRect(1, 1, (width - 3) + 20, height - 3, 18, 18);
        graphics2D.setPaint(p1);
        graphics2D.drawLine(width - 1, 1, width - 1, height);
        graphics2D.setPaint(p2);
        graphics2D.drawLine(width - 2, 2, width - 2, height - 1);
    }

    private void rightRoundRect(Graphics2D graphics2D, GradientPaint p1, GradientPaint p2) {
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(-20, 0,
                (width - 1) + 20, height - 1, radius, radius);
        Shape clip = graphics2D.getClip();
        graphics2D.clip(r2d);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setClip(clip);
        graphics2D.setPaint(p1);
        graphics2D.drawRoundRect(-20, 0, (width - 1) + 20, height - 1, radius, radius);
        graphics2D.setPaint(p2);
        graphics2D.drawRoundRect(-19, 1, (width - 3) + 20, height - 3, 18, 18);
        graphics2D.setPaint(p1);
        graphics2D.drawLine(0, 1, 0, height);
        graphics2D.setPaint(p2);
        graphics2D.drawLine(1, 2, 1, height - 1);
    }

    private void star(Graphics2D graphics2D, GradientPaint p1, GradientPaint p2) {
        int x = width / 2;
        int y = height / 2;
        int r = width / 2;
        // 计算五个顶点
        Point[] ps = new Point[5];
        for (int i = 0; i <= 4; i++) {
            ps[i] = new Point((int) (x - r
                    * Math.sin((i * 72 + 36) * 2 * Math.PI / 360)),
                    (int) (y + r
                            * Math.cos((i * 72 + 36) * 2 * Math.PI / 360)));
        }
        GeneralPath star = new GeneralPath();
        star.moveTo(ps[3].x, ps[3].y);
        star.lineTo(ps[0].x, ps[0].y);
        star.lineTo(ps[2].x, ps[2].y);
        star.lineTo(ps[4].x, ps[4].y);
        star.lineTo(ps[1].x, ps[1].y);
        star.lineTo(ps[3].x, ps[3].y);
        star.closePath();
        Shape clip = graphics2D.getClip();
        graphics2D.clip(star);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setClip(clip);
        graphics2D.setPaint(p1);
        graphics2D.draw(star);
        graphics2D.setPaint(p2);
        graphics2D.draw(star);
    }

    private void ball(Graphics2D graphics2D, GradientPaint p1, GradientPaint p2) {
        Arc2D.Float a2d = new Arc2D.Float(0, 0, width, height, 0, 360, Arc2D.CHORD);
        Shape clip = graphics2D.getClip();
        graphics2D.clip(a2d);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setClip(clip);
        graphics2D.setPaint(p1);
        graphics2D.drawOval(0, 0, width - 1, height - 1);
        graphics2D.setPaint(p2);
        graphics2D.drawOval(1, 1, width - 3, height - 3);
    }
}
