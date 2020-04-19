package top.yangwulang.services;


import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author yangwulang
 */
public class Test {
    public void get() throws IOException {
        InputStream inputStream = new FileInputStream(Test.class.getResource("/static/json/request.json").getFile());
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }
}
