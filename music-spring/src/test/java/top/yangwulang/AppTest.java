package top.yangwulang;

import static org.junit.Assert.assertTrue;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.yangwulang.config.BaseConfig;
import top.yangwulang.jsons.BaseRecommendResultTemplate;
import top.yangwulang.jsons.BaseSearchResultKey;
import top.yangwulang.pojo.qq.RecommendResult;
import top.yangwulang.pojo.qq.RecommendResultData;
import top.yangwulang.pojo.qq.SearchResultKey;
import top.yangwulang.pojo.qq.SearchResultSongInfo;
import top.yangwulang.services.QqService;

import java.io.IOException;
import java.util.Map;

/**
 * Unit test for simple App.
 */
//@ComponentScan("top.yangwulang.config")
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testQqServiceInterface() {
        QqService service = new QqService();
        service.aboutSearchSong("邓紫棋", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(BaseConfig.class);
        QqService service = context.getBean(QqService.class);
        service.searchRecommend(new BaseRecommendResultTemplate<RecommendResultData>() {

            @Override
            public void callBack(RecommendResult<RecommendResultData> recommendResultDataRecommendResult, Exception exception) {
                recommendResultDataRecommendResult.getRecomPlaylist()
                        .getData()
                        .getV_hot()
                        .forEach(vHotBean -> {
                            System.out.println(vHotBean.getCover());
                            System.out.println(vHotBean.getTitle());
                        });
            }
        });
/*        SearchResultSongInfo info = new SearchResultSongInfo();
        info.setSongmid("004dFFPd4JNv8q");
        service.searchSongAllInfo(info, new BaseSearchResultKey() {
            @Override
            public void callBack(SearchResultKey searchResultKey, Exception exception) {
                System.out.println(searchResultKey.getReq_0().getData());
                System.out.println(searchResultKey.getReq_0().getData().getMidurlinfo());
            }
        });*/
//        System.out.println(LoadJson.loadJson());
/*        service.search("邓紫棋", 1, 10, new BaseSearchResultTemplate<SearchResultData>() {
            @Override
            public void callBack(SearchResult<SearchResultData> searchResultDataSearchResult, Exception exception) {
                searchResultDataSearchResult.getData().getSong().getList().forEach(System.out::println);
            }
        });*/
        /*service.aboutSearchSong("邓紫棋", new BasePopResultRequestTemplate<Map<String, Song>>() {
            @Override
            public void callBack(PopResult<Map<String, Song>> mapPopResult, Exception exception) {
                mapPopResult.getData().forEach((k, v) -> {
                    v.getItemlist().forEach(System.out::println);
                });
            }
        });*/
    }
}
