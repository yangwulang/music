package top.yangwulang.jsons;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import top.yangwulang.jsons.interfaces.CallBack;
import top.yangwulang.pojo.qq.PopResult;

import java.io.IOException;
import java.util.Map;

/**
 * @author yangwulang
 */
public abstract class BasePopResultRequestTemplate<T extends Map<String, ?>> implements Callback, CallBack<PopResult<T>> {
    protected BasePopResultRequestTemplate() {
    }

    @Override
    public void onFailure(Call call, IOException e) {
        callBack(null, e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String string = response.body().string();
        PopResult<T> t = JSON.parseObject(string, new TypeReference<PopResult<T>>(getHeadType()) {
        }, Feature.OrderedField);
        callBack(t, null);
    }
}
