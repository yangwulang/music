package top.yangwulang.utils;

import okhttp3.*;
import top.yangwulang.utils.interfaces.RequestInterface;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author yangwulang
 */
public class RequestsUtils implements RequestInterface {

    private final Request.Builder builder = new Request.Builder();
    private final FormBody.Builder bodyBuilder = new FormBody.Builder();
    private final OkHttpClient client = new OkHttpClient().newBuilder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .build();

    @Override
    public Request.Builder addHead(String name, String value) {
        return builder.addHeader(name, value);
    }

    @Override
    public FormBody.Builder addBody(String name, String value) {
        return bodyBuilder.add(name, value);
    }

    @Override
    public void doGet(String url, Callback callback) {
        Request build = builder.url(url).build();
        client.newCall(build).enqueue(callback);
    }

    @Override
    public void doPost(String url, Callback callback) {
        FormBody body = bodyBuilder.build();
        Request build = builder.url(url).post(body).build();
        client.newCall(build).enqueue(callback);
    }
}
