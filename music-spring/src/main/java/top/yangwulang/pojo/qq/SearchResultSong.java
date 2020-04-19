package top.yangwulang.pojo.qq;

import lombok.Data;

import java.util.List;

/**
 * @author yangwulang
 */
@Data
public class SearchResultSong {

    /**
     * curnum : 10
     * curpage : 2
     * list : [{},{},{},{},{},{},{},{},{},{}]
     * totalnum : 600
     */

    private int curnum;
    private int curpage;
    private int totalnum;
    private List<SearchResultSongInfo> list;

}
