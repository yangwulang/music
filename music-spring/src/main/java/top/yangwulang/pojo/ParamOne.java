package top.yangwulang.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yangwulang
 */
@Data
public class ParamOne implements Serializable {

    /**
     * guid : 8196006125
     * calltype : 0
     * userip :
     */

    private String guid;
    private int calltype;
    private String userip;
}
