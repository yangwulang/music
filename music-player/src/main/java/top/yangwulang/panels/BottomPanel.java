package top.yangwulang.panels;

import top.yangwulang.swings.ui.CustomizeJavaButton;
import top.yangwulang.swings.ui.StartApplicationFactory;
import top.yangwulang.swings.ui.annotation.AutowiredButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author yangwulang
 */
public class BottomPanel extends JPanel {
    @AutowiredButton(buttonName = "playFrontButton", text = "<", radius = 100, backGround = {232, 232, 232}, foreGround = {232, 232, 232})
    private static CustomizeJavaButton playFrontButton;
    @AutowiredButton(buttonName = "playNextButton", text = ">", radius = 100, backGround = {232, 232, 232}, foreGround = {232, 232, 232})
    private static CustomizeJavaButton playNextButton;
    @AutowiredButton(buttonName = "playOrPauseButton", text = ">>", radius = 100, backGround = {232, 232, 232}, foreGround = {232, 232, 232})
    private static CustomizeJavaButton playOrPauseButton;

    private boolean isClickedPlayButton = false;

    public BottomPanel() {
        try {
            StartApplicationFactory.start(this.getClass());
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        //前面
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        playOrPauseButton.setFont(new Font("Consolas常规", Font.PLAIN, 20));


        playFrontButton.setPreferredSize(new Dimension(40, 40));
        playNextButton.setPreferredSize(new Dimension(40, 40));
        playOrPauseButton.setPreferredSize(new Dimension(70, 70));
        JPanel buttonGroup = new JPanel();
        buttonGroup.add(playFrontButton);
        buttonGroup.add(playOrPauseButton);
        buttonGroup.add(playNextButton);

        JPanel topProgressBarPanel = new JPanel();
        /*JProgressBar jProgressBar = new JProgressBar();
        topProgressBarPanel.add(jProgressBar);

        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(100);

        jProgressBar.setStringPainted(true);*/
        JSlider jSlider = new JSlider();
        jSlider.setPreferredSize(new Dimension(700, 20));
        topProgressBarPanel.add(jSlider);


        playOrPauseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isClickedPlayButton) {
                    isClickedPlayButton = false;
                    playOrPauseButton.setText(">>");
                } else {
                    isClickedPlayButton = true;
                    playOrPauseButton.setText("II");
                }
            }
        });

        add(topProgressBarPanel);
        add(buttonGroup);
    }
}
