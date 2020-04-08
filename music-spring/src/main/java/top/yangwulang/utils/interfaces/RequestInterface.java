package top.yangwulang.utils.interfaces;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;

/**
 * @author yangwulang
 */
public interface RequestInterface {
    /**
     * 设置请求头
     *
     * @param name  键
     * @param value 值
     * @return {@link Request.Builder}构造器
     */
    Request.Builder addHead(String name, String value);

    /**
     * 设置post请求的报文
     *
     * @param name  键
     * @param value 值
     * @return {@link FormBody.Builder}构造器
     */
    FormBody.Builder addBody(String name, String value);

    /**
     * 发生get请求，请求返回的内容在callback中
     *
     * @param url      请求地址
     * @param callback 接口回调
     */
    void doGet(String url, Callback callback);

    /**
     * 发生post请求，请求返回的内容在callback中
     *
     * @param url      请求地址
     * @param callback 接口回调
     */
    void doPost(String url, Callback callback);
}
