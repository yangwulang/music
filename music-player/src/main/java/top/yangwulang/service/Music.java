package top.yangwulang.service;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @author yangwulang
 */
public class Music extends Thread {
    private final InputStream inputStream;

    public Music(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void play() throws JavaLayerException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        Player player = new Player(bufferedInputStream);
        player.play();
    }
}
