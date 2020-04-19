package top.yangwulang.jsons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.slf4j.Logger;
import top.yangwulang.jsons.interfaces.CallBack;
import top.yangwulang.pojo.qq.SearchResult;

import java.io.IOException;

/**
 * @author yangwulang
 */
public abstract class BaseSearchResultTemplate<T> implements Callback, CallBack<SearchResult<T>> {
    protected BaseSearchResultTemplate() {
    }

    @Override
    public void onFailure(Call call, IOException e) {
        callBack(null, e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String string = response.body().string();
        LOGGER.info("BaseSearchResultTemplate 请求来的数据 ==>" + string);
        SearchResult<T> tSearchResult = JSON.parseObject(string, new TypeReference<SearchResult<T>>(getHeadType()) {
        }, Feature.OrderedField);
        callBack(tSearchResult, null);
    }
}
