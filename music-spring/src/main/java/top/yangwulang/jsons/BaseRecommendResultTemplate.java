package top.yangwulang.jsons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import top.yangwulang.jsons.interfaces.CallBack;
import top.yangwulang.pojo.qq.RecommendResult;
import top.yangwulang.pojo.qq.Result;

import java.io.IOException;

/**
 * @author yangwulang
 */
public abstract class BaseRecommendResultTemplate<T> implements Callback, CallBack<RecommendResult<T>> {
    @Override
    public void onFailure(Call call, IOException e) {
        callBack(null, e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String string = response.body().string();
        LOGGER.info("BaseRecommendResultTemplate 请求回的数据 ==> {}", string);
        RecommendResult<T> tRecommendResult = JSON.parseObject(string, new TypeReference<RecommendResult<T>>(getHeadType()) {
        }, Feature.OrderedField);
        callBack(tRecommendResult, null);
    }
}
