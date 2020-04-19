package top.yangwulang.pojo.qq;

import lombok.Data;

/**
 * @author yangwulang
 */
@Data
public class Result<T> {

    /**
     * code : 0
     * ts : 1585732191624
     * songinfo : {"code":0,"data":{"info":{},"extras":{},"track_info":{"id":104913384,"type":0,"mid":"004dFFPd4JNv8q","name":"来自天堂的魔鬼","title":"来自天堂的魔鬼","subtitle":"","singer":[{"id":13948,"mid":"001fNHEf1SFEFN","name":"G.E.M. 邓紫棋","title":"G.E.M. 邓紫棋","type":1,"uin":0}],"album":{"id":1196826,"mid":"003c616O2Zlswm","name":"新的心跳","title":"新的心跳","subtitle":"","time_public":"2015-11-06","pmid":"003c616O2Zlswm_1"},"mv":{"id":658093,"vid":"v001892io9b","name":"","title":"","vt":0},"interval":245,"isonly":0,"language":0,"genre":1,"index_cd":0,"index_album":4,"time_public":"2015-11-06","status":0,"fnote":4009,"file":{"media_mid":"001DI2Jj3Jqve9","size_24aac":0,"size_48aac":1493159,"size_96aac":2989483,"size_192ogg":5405648,"size_192aac":5932642,"size_128mp3":3929034,"size_320mp3":9822259,"size_ape":0,"size_flac":29903656,"size_dts":0,"size_try":0,"try_begin":42933,"try_end":144018,"url":"","size_hires":0,"hires_sample":0,"hires_bitdepth":0,"b_30s":0,"e_30s":0,"size_96ogg":2746509},"pay":{"pay_month":1,"price_track":200,"price_album":0,"pay_play":0,"pay_down":1,"pay_status":0,"time_free":0},"action":{"switch":17413891,"msgid":14,"alert":2,"icons":8527740,"msgshare":0,"msgfav":0,"msgdown":0,"msgpay":6},"ksong":{"id":181305,"mid":"0042FDVH27bIZD"},"volume":{"gain":-9.203,"peak":0.989,"lra":7.267},"label":"4611686018444165121","url":"","bpm":68,"version":0,"trace":"","data_type":0,"modify_stamp":0,"pingpong":"","ppurl":"","tid":0,"ov":0,"sa":0,"es":""}}}
     */

    private int code;
    private long ts;
    private T songinfo;
}
