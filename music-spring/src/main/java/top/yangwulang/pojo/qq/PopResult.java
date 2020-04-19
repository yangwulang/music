package top.yangwulang.pojo.qq;

import lombok.Data;

/**
 * 这是搜索框弹出对象
 *
 * @author yangwulang
 */
@Data
public class PopResult<T> {

    /**
     * code : 0
     * data : {}
     * subcode : 0
     */

    private int code;
    private T data;
    private int subcode;

}
