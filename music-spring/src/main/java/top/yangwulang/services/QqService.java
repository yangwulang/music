package top.yangwulang.services;

import okhttp3.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import top.yangwulang.config.BaseConfig;
import top.yangwulang.pojo.qq.SearchResultKey;
import top.yangwulang.pojo.qq.SearchResultSongInfo;
import top.yangwulang.utils.LoadJson;
import top.yangwulang.utils.interfaces.RequestInterface;

import java.io.IOException;

/**
 * @author yangwulang
 */
@Component
public class QqService {

    private final Logger log = LoggerFactory.getLogger(QqService.class);
    @Autowired
    private RequestInterface request ;
    /**
     * 播放歌曲的前缀地址
     */
    public static final String MUSIC_PLAY_URL_PREFIX = "https://isure.stream.qqmusic.qq.com/";

    /**
     * 模糊查询Song信息,接收用Map,BasePopResultRequestTemplate<Map<String, Song>>()
     *
     * @param songName 查询信息
     * @param callback 回调方法
     */
    public void aboutSearchSong(String songName, Callback callback) {
        String aboutSearchUrl = "https://c.y.qq.com/splcloud/fcgi-bin/smartbox_new.fcg?is_xml=0&key=%s" +
                "&format=json&inCharset=utf8&outCharset=utf-8&platform=yqq.json";
        String url = String.format(aboutSearchUrl, songName);
        log.info("模糊查询Song信息 来自于aboutSearchSong 请求地址 ==> " + url);
        request.doGet(url, callback);
    }

    /**
     * 查询有关于songInfo的信息，尽量封装成BaseSearchResultTemplate<SearchResultData>以便获取数据
     *
     * @param songInfo 带查询的信息
     * @param page     页数
     * @param pageSize 一页有多少条数据
     * @param callback 回调方法
     */
    public void search(String songInfo, int page, int pageSize, Callback callback) {
        String searchUrl = "https://c.y.qq.com/soso/fcgi-bin/client_search_cp?ct=24&catZhida=1" +
                "&p=%d&n=%d&w=%s&format=json&inCharset=utf8&outCharset=utf-8";
        String url = String.format(searchUrl, page, pageSize, songInfo);
        log.info("查询有关于songInfo的信息 来自于 search 请求地址 ==> " + url);
        request.doGet(url, callback);
    }

    /**
     * 从{@link SearchResultSongInfo}中获取songmid请求Purl(直接的播放地址),用https://isure.stream.qqmusic.qq.com/拼接即可得出音乐地址
     * <p>对应的泛型对象为{@link SearchResultKey} new BaseSearchResultKey<SearchResultKey></p>
     *
     * @param searchResultSongInfo 搜索获得的歌曲信息
     * @param callback             回调方法
     */
    public void searchSongAllInfo(SearchResultSongInfo searchResultSongInfo, Callback callback) {
        String songInfoUrl = null;
        try {
            songInfoUrl = "https://u.y.qq.com/cgi-bin/musicu.fcg?g_tk=847635201&format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0&data=" + LoadJson.loadJson().replace("@#s#@", searchResultSongInfo.getSongmid()).replace(" ", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert songInfoUrl != null;
        log.info("查询所有关于songInfo的信息 来自于 searchSongAllInfo  请求地址 ==> " + songInfoUrl);
        request.doGet(songInfoUrl, callback);
    }

    public void searchMv(SearchResultSongInfo searchResultSongInfo, Callback callback) {
        request.addBody("getMvUrl", "\"module\": \"gosrf.Stream.MvUrlProxy\",\n" +
                "    \"method\": \"GetMvUrls\",\n" +
                "    \"param\": {\n" +
                "      \"vids\": [\n" +
                "        \"%s\"\n" +
                "      ],\n" +
                "      \"request_typet\": 10001,\n" +
                "      \"addrtype\": 3\n" +
                "    }");
        request.doPost("https://u.y.qq.com/cgi-bin/musicu.fcg", callback);

    }
}
