package top.yangwulang.utils;

import java.io.*;

/**
 * @author yangwulang
 * @date 2020/4/19 增加读取资源目录下的文件转化成string
 */
public class LoadJson {
    /**
     * 读取resources目录下的request.json文件到内存
     *
     * @return 加载文件到内存中
     * @throws IOException s
     */
    public static String loadJson() throws IOException {
        return loadJson("/static/json/request.json");
    }

    /**
     * 加载{@link LoadJson}classpath环境下的指定路径数据转成string
     *
     * @param path 文件地址(相对路径)
     * @return 以字符串形式的文件
     * @throws IOException s
     */
    public static String loadJson(String path) throws IOException {
        InputStream resourceAsStream = LoadJson.class.getResourceAsStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuffer = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}
