package top.yangwulang.pojo.qq;

import lombok.Data;

import java.util.List;

/**
 * @author yangwulang
 */
@Data
public class RecommendResultData {

    /**
     * code : 0
     * data : {"page":0,"v_hot":[{"album_pic_mid":"001hGx1Z0so1YX","content_id":7382629476,"cover":"http://qpic.y.qq.com/music_cover/Z89aLA93LOSOicz0QOnMboqgLaiaFohjweglHh6JSoL8hrjOfFOC6DXw/300?n=1","creator":1968987427,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":246923932,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"精选 | 好听到单曲循环的热歌","tjreport":"","type":10014,"username":"故事未完待续"},{},{},{},{},{},{},{},{},{},{},{}]}
     */

    private int code;
    private DataBean data;

    @Data
    public static class DataBean {
        /**
         * page : 0
         * v_hot : [{"album_pic_mid":"001hGx1Z0so1YX","content_id":7382629476,"cover":"http://qpic.y.qq.com/music_cover/Z89aLA93LOSOicz0QOnMboqgLaiaFohjweglHh6JSoL8hrjOfFOC6DXw/300?n=1","creator":1968987427,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":246923932,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"精选 | 好听到单曲循环的热歌","tjreport":"","type":10014,"username":"故事未完待续"},{},{},{},{},{},{},{},{},{},{},{}]
         */

        private int page;
        private List<VHotBean> v_hot;

        @Data
        public static class VHotBean {
            /**
             * album_pic_mid : 001hGx1Z0so1YX
             * content_id : 7382629476
             * cover : http://qpic.y.qq.com/music_cover/Z89aLA93LOSOicz0QOnMboqgLaiaFohjweglHh6JSoL8hrjOfFOC6DXw/300?n=1
             * creator : 1968987427
             * edge_mark :
             * id : 0
             * is_dj : false
             * is_vip : true
             * jump_url :
             * listen_num : 246923932
             * pic_mid :
             * rcmdcontent :
             * rcmdtemplate : 编辑推荐
             * rcmdtype : 0
             * singerid : 0
             * title : 精选 | 好听到单曲循环的热歌
             * tjreport :
             * type : 10014
             * username : 故事未完待续
             */

            private String album_pic_mid;
            private String content_id;
            private String cover;
            private long creator;
            private String edge_mark;
            private int id;
            private boolean is_dj;
            private boolean is_vip;
            private String jump_url;
            private long listen_num;
            private String pic_mid;
            private String rcmdcontent;
            private String rcmdtemplate;
            private int rcmdtype;
            private int singerid;
            private String title;
            private String tjreport;
            private int type;
            private String username;
        }
    }
}
