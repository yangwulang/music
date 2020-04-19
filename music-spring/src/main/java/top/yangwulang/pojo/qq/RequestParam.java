package top.yangwulang.pojo.qq;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangwulang
 */
@Data
public class RequestParam<T> implements Serializable {

    /**
     * module : vkey.GetVkeyServer
     * method : CgiGetVkey
     * param : {"guid":"8196006125","songmid":["004dFFPd4JNv8q"],"songtype":[0],"uin":"1021414627","loginflag":1,"platform":"20"}
     */

    private String module;
    private String method;
    private T param;
}
