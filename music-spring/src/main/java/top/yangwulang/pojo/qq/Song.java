package top.yangwulang.pojo.qq;

import lombok.Data;

import java.util.List;

/**
 * @author yangwulang
 */
@Data
public class Song {

    /**
     * count : 4
     * itemlist : [{"docid":"247347346","id":"247347346","mid":"001QJyJ32zybEe","name":"句号","singer":"G.E.M. 邓紫棋"},{"docid":"200255722","id":"200255722","mid":"002E3MtF0IAMMY","name":"光年之外","singer":"G.E.M. 邓紫棋"},{"docid":"104913384","id":"104913384","mid":"004dFFPd4JNv8q","name":"来自天堂的魔鬼","singer":"G.E.M. 邓紫棋"},{"docid":"1530858","id":"1530858","mid":"001X0PDf0W4lBq","name":"泡沫","singer":"G.E.M. 邓紫棋"}]
     * name : 单曲
     * order : 0
     * type : 1
     */

    private int count;
    private String name;
    private int order;
    private int type;
    private List<ItemlistBean> itemlist;

}
