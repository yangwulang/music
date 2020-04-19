package top.yangwulang.jsons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import top.yangwulang.jsons.interfaces.CallBack;
import top.yangwulang.pojo.qq.SearchResultKey;

import java.io.IOException;

/**
 * @author yangwulang
 */
public abstract class BaseSearchResultKey implements Callback, CallBack<SearchResultKey> {
    @Override
    public void onFailure(Call call, IOException e) {
        callBack(null, e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String string = response.body().string();
        LOGGER.info("BaseSearchResultKey 请求来的数据" + string);
        SearchResultKey searchResultKey = JSON.parseObject(string, new TypeReference<SearchResultKey>() {
        }, Feature.OrderedField);
        callBack(searchResultKey, null);
    }

}
