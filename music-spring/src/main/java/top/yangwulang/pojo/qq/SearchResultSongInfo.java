package top.yangwulang.pojo.qq;

import lombok.Data;

import java.util.List;

/**
 * @author yangwulang
 */
@Data
public class SearchResultSongInfo {

    /**
     * albumid : 9812833
     * albummid : 0049MVh824D7bM
     * albumname : 摩天动物园
     * albumname_hilight : 摩天动物园
     * alertid : 2
     * belongCD : 0
     * cdIdx : 4
     * chinesesinger : 0
     * docid : 14628361575978066456
     * grp : []
     * interval : 290
     * isonly : 0
     * lyric : 《可不可以，你也刚好喜欢我》电影主题曲
     * lyric_hilight : 《可不可以，你也刚好喜欢我》电影主题曲
     * media_mid : 002qtwZJ32UUxO
     * msgid : 16
     * newStatus : 2
     * nt : 560439931
     * pay : {"payalbum":0,"payalbumprice":0,"paydownload":1,"payinfo":1,"payplay":0,"paytrackmouth":1,"paytrackprice":200}
     * preview : {"trybegin":66188,"tryend":94359,"trysize":960887}
     * pubtime : 1577376010
     * pure : 0
     * singer : [{"id":13948,"mid":"001fNHEf1SFEFN","name":"G.E.M. 邓紫棋","name_hilight":"G.E.M. <em>邓紫棋<\/em>"}]
     * size128 : 4645412
     * size320 : 11612617
     * sizeape : 0
     * sizeflac : 28172270
     * sizeogg : 6088270
     * songid : 248413022
     * songmid : 002qtwZJ32UUxO
     * songname : 很久以后
     * songname_hilight : 很久以后
     * strMediaMid : 002qtwZJ32UUxO
     * stream : 1
     * switch : 17413891
     * t : 1
     * tag : 11
     * type : 0
     * ver : 0
     * vid : u00336fqv1a
     */

    private long albumid;
    private String albummid;
    private String albumname;
    private String albumname_hilight;
    private int alertid;
    private int belongCD;
    private int cdIdx;
    private int chinesesinger;
    private String docid;
    private int interval;
    private int isonly;
    private String lyric;
    private String lyric_hilight;
    private String media_mid;
    private int msgid;
    private int newStatus;
    private long nt;
    private Pay pay;
    private Preview preview;
    private long pubtime;
    private int pure;
    private long size128;
    private long size320;
    private long sizeape;
    private long sizeflac;
    private long sizeogg;
    private long songid;
    private String songmid;
    private String songname;
    private String songname_hilight;
    private String strMediaMid;
    private int stream;
    private int switchX;
    private int t;
    private int tag;
    private int type;
    private int ver;
    private String vid;
    private List<?> grp;
    private List<SearchResultSinger> singer;
}
