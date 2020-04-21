package top.yangwulang.panels;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringUtils;
import top.yangwulang.jsons.BaseSearchResultKey;
import top.yangwulang.jsons.BaseSearchResultTemplate;
import top.yangwulang.pojo.qq.SearchResult;
import top.yangwulang.pojo.qq.SearchResultData;
import top.yangwulang.pojo.qq.SearchResultKey;
import top.yangwulang.services.QqService;
import top.yangwulang.swings.ui.CustomizeJavaButton;
import top.yangwulang.swings.ui.CustomizeJavaDialog;
import top.yangwulang.swings.ui.CustomizeJavaFrame;
import top.yangwulang.swings.ui.StartApplicationFactory;
import top.yangwulang.swings.ui.annotation.AutowiredButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangwulang
 * @date 2020/4/19 增加了QQ接口解析成对象
 * 播放器应该是由于int和double的精度问题在播放歌曲时会有一点重复音质,
 * 设置了自动下一首，但是经过某个未知事件时自动转为false(待修复)
 */
public class BottomPanel extends JPanel {
    /**
     * 上一曲按钮
     */
    @AutowiredButton(buttonName = "playFrontButton", text = "<", radius = 100, backGround = {232, 232, 232}, foreGround = {232, 232, 232})
    private static CustomizeJavaButton playFrontButton;
    /**
     * 下一曲按钮
     */
    @AutowiredButton(buttonName = "playNextButton", text = ">", radius = 100, backGround = {232, 232, 232}, foreGround = {232, 232, 232})
    private static CustomizeJavaButton playNextButton;
    /**
     * 播放或者暂停键
     */
    @AutowiredButton(buttonName = "playOrPauseButton", text = ">>", radius = 100, backGround = {232, 232, 232}, foreGround = {232, 232, 232})
    private static CustomizeJavaButton playOrPauseButton;
    /**
     * 歌曲列表
     */
    private final List<Media> mediaList = new LinkedList<>();
    /**
     * 歌曲的索引
     */
    private int index = 0;
    /**
     * 是否按下过播放键
     */
    private boolean isClickedPlayButton = false;
    /**
     * 是否调整过歌曲进度条
     */
    private boolean isPlayChange = false;
    /**
     * 播放器
     */
    private MediaPlayer player;
    private final JSlider jSlider;
    private final JSlider volumeSlider;
    private final ConfigurableListableBeanFactory beanFactory;

    public BottomPanel() {
        try {
            StartApplicationFactory.start(this.getClass());
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        beanFactory = StartApplicationFactory.getContext().getBeanFactory();

        //前面
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Logger log = LoggerFactory.getLogger(BottomPanel.class);

        playOrPauseButton.setFont(new Font("Consolas常规", Font.PLAIN, 20));


        playFrontButton.setPreferredSize(new Dimension(40, 40));
        playNextButton.setPreferredSize(new Dimension(40, 40));
        playOrPauseButton.setPreferredSize(new Dimension(70, 70));

        JLabel rightNullLabel = new JLabel();
        rightNullLabel.setPreferredSize(new Dimension(150, 40));

        volumeSlider = new JSlider();
        volumeSlider.setValue(10);
        volumeSlider.setPreferredSize(new Dimension(100, 20));

        JLabel leftNullLabel = new JLabel();
        leftNullLabel.setPreferredSize(new Dimension(150, 40));

        JPanel buttonGroup = new JPanel();
        buttonGroup.add(leftNullLabel);
        buttonGroup.add(playFrontButton);
        buttonGroup.add(playOrPauseButton);
        buttonGroup.add(playNextButton);
        buttonGroup.add(rightNullLabel);
        buttonGroup.add(volumeSlider);

        JPanel topProgressBarPanel = new JPanel();
        jSlider = new JSlider();
        jSlider.setValue(0);
        jSlider.setPreferredSize(new Dimension(700, 20));
        topProgressBarPanel.add(jSlider);
        //调用JavaFX的线程启动媒体播放器
        QqService qqService = beanFactory.getBean(QqService.class);
        PlatformImpl.startup(() -> qqService.search("追梦赤子心", 1, 10, new BaseSearchResultTemplate<SearchResultData>() {
            @Override
            public void callBack(SearchResult<SearchResultData> searchResultDataSearchResult, Exception exception) {
                searchResultDataSearchResult.getData()
                        .getSong()
                        .getList()
                        .forEach(searchResultSongInfo -> {
                            synchronized (this) {
                                qqService.searchSongAllInfo(searchResultSongInfo, new BaseSearchResultKey() {
                                    @Override
                                    public void callBack(SearchResultKey searchResultKey, Exception exception) {
                                        String suffix = searchResultKey.getReq_0().getData().getMidurlinfo().get(0).getPurl();
                                        //防止有数据没有地址
                                        if (!StringUtils.isEmpty(suffix)) {
                                            String url = QqService.MUSIC_PLAY_URL_PREFIX + suffix;
                                            log.info("歌曲的真实地址 ==> {}", url);
                                            try {
                                                URL urls = new URL(url);
                                                Media media = new Media(urls.toString());
                                                mediaList.add(media);
                                                player = new MediaPlayer(mediaList.get(0));
                                                flushPlayer(true);
                                            } catch (MalformedURLException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            }
                        });
            }
        }));
        //根据滑动条的值控制歌曲进度,有误差
        jSlider.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPlayChange = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPlayChange = false;
                player.seek(Duration.seconds(jSlider.getValue()));
            }
        });
        //根据音量控制条设置播放的音量
        volumeSlider.addChangeListener(e -> this.player.setVolume(((double) volumeSlider.getValue()) / 100));
        playOrPauseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlatformImpl.startup(() -> {
                    if (isClickedPlayButton) {
                        player.pause();
                        isClickedPlayButton = false;
                        playOrPauseButton.setText(">>");
                    } else {
                        player.play();
                        isClickedPlayButton = true;
                        playOrPauseButton.setText("II");
                    }
                });
            }
        });
        //设置按钮事件当下一曲按钮被点击索引加一，但是当索引超过了播放歌曲的长度时索引自动减一并提示
        //如果上述不成立直接播放下一首歌
        playNextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playNextSong();
            }
        });
        playFrontButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index--;
                if (index < 0) {
                    CustomizeJavaDialog dialog = new CustomizeJavaDialog("已经是第一首歌了!!!"
                            , beanFactory.getBean("PlayerMainPanel", CustomizeJavaFrame.class));
                    dialog.showDialog();
                    index++;
                } else {
                    if (player != null) {
                        player.dispose();
                    }
                    player = new MediaPlayer(mediaList.get(index));
                    flushPlayer(false);
                    player.play();
                }
            }
        });

        add(topProgressBarPanel);
        add(buttonGroup);
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    /**
     * 播放下一首音乐
     */
    public void playNextSong() {
        index++;
        if (index >= mediaList.size()) {
            CustomizeJavaDialog dialog = new CustomizeJavaDialog("已经是最后一首歌了!!!"
                    , beanFactory.getBean("PlayerMainPanel", CustomizeJavaFrame.class));
            dialog.showDialog();
            index--;
        } else {
            //如果当前播放器不为空释放当前播放器
            if (player != null) {
                player.dispose();
            }
            player = new MediaPlayer(mediaList.get(index));
            flushPlayer(false);
            player.play();
        }
    }

    /**
     * 刷新播放器设置滑动条跟随音乐跑
     *
     * @param isAutoPlayNextSong 是否开启自动播放下一首歌 true为自动播放反之则不自动
     */
    public void flushPlayer(boolean isAutoPlayNextSong) {
        player.setVolume(((double) volumeSlider.getValue()) / 100);
        jSlider.setMinimum(0);
        player.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            if (!isPlayChange) {
                Duration currentTime = player.getCurrentTime();
                jSlider.setMaximum((int) player.getMedia().getDuration().toSeconds());
                if (jSlider.getValue() == jSlider.getMaximum() && isAutoPlayNextSong) {
                    player.dispose();
                    playNextSong();
                }
                jSlider.setValue((int) currentTime.toSeconds());
            }
        });
    }
}
