package top.yangwulang.pojo.qq;

import lombok.Data;

/**
 * @author yangwulang
 */
@Data
public class SearchResult<T> {

    /**
     * code : 0
     * data : {}
     * message :
     * notice :
     * subcode : 0
     * time : 1587209691
     * tips :
     */

    private int code;
    private T data;
    private String message;
    private String notice;
    private int subcode;
    private int time;
    private String tips;
}
