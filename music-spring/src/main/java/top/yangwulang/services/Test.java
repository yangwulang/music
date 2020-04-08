package top.yangwulang.services;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import org.apache.commons.io.IOUtils;
import top.yangwulang.pojo.ParamOne;
import top.yangwulang.pojo.ParamTwo;
import top.yangwulang.pojo.RequestParam;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangwulang
 */
public class Test {
    public void get() throws IOException {
        InputStream inputStream = new FileInputStream(Test.class.getResource("/static/json/request.json").getFile());
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        
    }
}
