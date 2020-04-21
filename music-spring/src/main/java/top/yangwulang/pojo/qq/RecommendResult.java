package top.yangwulang.pojo.qq;

import lombok.Data;

/**
 * @author yangwulang
 */
@Data
public class RecommendResult<T> {

    /**
     * code : 0
     * ts : 1587356732069
     * category : {}
     * recomPlaylist : {}
     * playlist : {}
     * new_song : {}
     * new_album : {}
     * new_album_tag : {}
     * toplist : {}
     * focus : {}
     */

    private int code;
    private long ts;
    private T recomPlaylist;
}
