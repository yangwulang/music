package top.yangwulang.pojo.qq;

import lombok.Data;

import java.util.List;

/**
 * @author yangwulang
 */
@Data
public class ParamTwo {

    /**
     * guid : 8196006125
     * songmid : ["004dFFPd4JNv8q"]
     * songtype : [0]
     * uin : 1021414627
     * loginflag : 1
     * platform : 20
     */

    private String guid;
    private String uin;
    private int loginflag;
    private String platform;
    private List<String> songmid;
    private List<Integer> songtype;
}
