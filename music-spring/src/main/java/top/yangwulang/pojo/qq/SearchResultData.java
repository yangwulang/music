package top.yangwulang.pojo.qq;

import lombok.Data;

import java.util.List;

/**
 * @author yangwulang
 */
@Data
public class SearchResultData {

    /**
     * keyword : 邓紫棋
     * priority : 0
     * qc : []
     * semantic : {}
     * song : {}
     * tab : 0
     * taglist : []
     * totaltime : 0
     * zhida : {}
     */

    private String keyword;
    private int priority;
    private SemanticBean semantic;
    private SearchResultSong song;
    private int tab;
    private int totaltime;
    private Zhida zhida;
    private List<?> qc;
    private List<?> taglist;
}
