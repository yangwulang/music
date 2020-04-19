package top.yangwulang;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

public class MusicTest {

    @Test
    public void playTest2() {
        URL resource = MusicTest.class.getResource("/music/魔鬼中的天使.m4a");
        System.out.println(resource.getPath());
        PlatformImpl.startup(() -> {
            Media media = new Media(resource.getFile());
            MediaPlayer player = new MediaPlayer(media);
            player.play();
        });
    }
}
