package top.yangwulang.jsons.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author yangwulang
 */
public interface CallBack<T> {
    Logger LOGGER = LoggerFactory.getLogger(CallBack.class);

    /**
     * OkHttp回调接口,如果T 参数不为空那么Exception 参数为空，总之有一个参数为空另一个就不为空
     *
     * @param t         泛型参数
     * @param exception 过程产生的异常
     */
    public void callBack(T t, Exception exception);

    /**
     * 返回当前接口的泛型类型
     *
     * @return 当前接口的泛型类型
     */
    default Type[] getHeadType() {
        ParameterizedType parameterizedType = (ParameterizedType) Objects.requireNonNull(this.getClass().getGenericSuperclass());
        LOGGER.info("当前 CallBack接口 泛型对象为 {}", parameterizedType.getActualTypeArguments()[0]);
        return parameterizedType.getActualTypeArguments();
    }
}
