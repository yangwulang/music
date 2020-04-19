package top.yangwulang.pojo.qq;

import lombok.Data;

import java.util.List;

/**
 * @author yangwulang
 */
public class SearchResultKey {

    /**
     * code : 0
     * ts : 1587216270950
     * req : {"code":0,"data":{"expiration":86400,"freeflowsip":["http://112.29.197.146/amobile.music.tc.qq.com/","http://112.29.197.147/amobile.music.tc.qq.com/","http://112.29.197.148/amobile.music.tc.qq.com/"],"keepalivefile":"C400004TsFuW2mZbRR.m4a?guid=8196006125&vkey=79B1FFC3B05F0D1F76ECE8AA9E5828AEEC88BC8C0699DFD432EA8357E62CAD08D7D7BC371B2F63B15493545E79565DD7B95E18933669D2CD&uin=3299&fromtag=3","msg":"ok","retcode":0,"servercheck":"078e9cf7d6577241057e0ae83d78ccba","sip":["http://ws.stream.qqmusic.qq.com/","http://isure.stream.qqmusic.qq.com/","http://112.29.197.146/amobile.music.tc.qq.com/","http://112.29.197.147/amobile.music.tc.qq.com/","http://112.29.197.148/amobile.music.tc.qq.com/"],"testfile2g":"C400003mAan70zUy5O.m4a?guid=8196006125&vkey=7573A852EA6DAD175F0565CAC5DA9EC5791A7002860E96DB745BE6404E08B2B7ACF0B225402786C23E81412274D64DA11EC950DDE0E8FFC9&uin=3299&fromtag=3","testfilewifi":"C400003mAan70zUy5O.m4a?guid=8196006125&vkey=7573A852EA6DAD175F0565CAC5DA9EC5791A7002860E96DB745BE6404E08B2B7ACF0B225402786C23E81412274D64DA11EC950DDE0E8FFC9&uin=3299&fromtag=3","uin":"","userip":"36.148.48.126","vkey":"1B38C8F21375D7C1A7C6CC6654B81DAAE48AC37471D8FE06E1FAC2AD9F8DD639951BE2886AFE9FC0959DBDEA96E1C8544D04656695E8D8AC"}}
     * req_0 : {"code":0,"data":{"expiration":80400,"login_key":"","midurlinfo":[{"common_downfromtag":0,"errtype":"","filename":"C400001DI2Jj3Jqve9.m4a","flowfromtag":"","flowurl":"","hisbuy":0,"hisdown":0,"isbuy":0,"isonly":0,"onecan":0,"opi128kurl":"","opi192koggurl":"","opi192kurl":"","opi30surl":"","opi48kurl":"","opi96kurl":"","opiflackurl":"","p2pfromtag":0,"pdl":0,"pneed":0,"pneedbuy":0,"premain":0,"purl":"C400001DI2Jj3Jqve9.m4a?guid=8196006125&vkey=C1FF539320E343317D21CDAD89C6C94E08BD65A3B97D1D815535F5CF21DE518DB0713D56EAAC0A8551A252F64496D0A604D88760EB40D360&uin=3299&fromtag=66","qmdlfromtag":0,"result":0,"songmid":"004dFFPd4JNv8q","tips":"","uiAlert":0,"vip_downfromtag":0,"vkey":"C1FF539320E343317D21CDAD89C6C94E08BD65A3B97D1D815535F5CF21DE518DB0713D56EAAC0A8551A252F64496D0A604D88760EB40D360","wififromtag":"","wifiurl":""}],"msg":"36.148.48.126","retcode":0,"servercheck":"078e9cf7d6577241057e0ae83d78ccba","sip":["http://ws.stream.qqmusic.qq.com/","http://isure.stream.qqmusic.qq.com/"],"testfile2g":"C400003mAan70zUy5O.m4a?guid=8196006125&vkey=216A69F8E68A29421C0CDE83DE6DB73B640406CA571600A06209A5935408E5F153AAABC14B6E25F7515ABA8984942387C4B184EE55C1AAB6&uin=&fromtag=3","testfilewifi":"C400003mAan70zUy5O.m4a?guid=8196006125&vkey=216A69F8E68A29421C0CDE83DE6DB73B640406CA571600A06209A5935408E5F153AAABC14B6E25F7515ABA8984942387C4B184EE55C1AAB6&uin=&fromtag=3","thirdip":["",""],"uin":"","verify_type":0}}
     */

    private int code;
    private long ts;
    private ReqBean req;
    private Req0Bean req_0;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public ReqBean getReq() {
        return req;
    }

    public void setReq(ReqBean req) {
        this.req = req;
    }

    public Req0Bean getReq_0() {
        return req_0;
    }

    public void setReq_0(Req0Bean req_0) {
        this.req_0 = req_0;
    }

    public static class ReqBean {
        /**
         * code : 0
         * data : {"expiration":86400,"freeflowsip":["http://112.29.197.146/amobile.music.tc.qq.com/","http://112.29.197.147/amobile.music.tc.qq.com/","http://112.29.197.148/amobile.music.tc.qq.com/"],"keepalivefile":"C400004TsFuW2mZbRR.m4a?guid=8196006125&vkey=79B1FFC3B05F0D1F76ECE8AA9E5828AEEC88BC8C0699DFD432EA8357E62CAD08D7D7BC371B2F63B15493545E79565DD7B95E18933669D2CD&uin=3299&fromtag=3","msg":"ok","retcode":0,"servercheck":"078e9cf7d6577241057e0ae83d78ccba","sip":["http://ws.stream.qqmusic.qq.com/","http://isure.stream.qqmusic.qq.com/","http://112.29.197.146/amobile.music.tc.qq.com/","http://112.29.197.147/amobile.music.tc.qq.com/","http://112.29.197.148/amobile.music.tc.qq.com/"],"testfile2g":"C400003mAan70zUy5O.m4a?guid=8196006125&vkey=7573A852EA6DAD175F0565CAC5DA9EC5791A7002860E96DB745BE6404E08B2B7ACF0B225402786C23E81412274D64DA11EC950DDE0E8FFC9&uin=3299&fromtag=3","testfilewifi":"C400003mAan70zUy5O.m4a?guid=8196006125&vkey=7573A852EA6DAD175F0565CAC5DA9EC5791A7002860E96DB745BE6404E08B2B7ACF0B225402786C23E81412274D64DA11EC950DDE0E8FFC9&uin=3299&fromtag=3","uin":"","userip":"36.148.48.126","vkey":"1B38C8F21375D7C1A7C6CC6654B81DAAE48AC37471D8FE06E1FAC2AD9F8DD639951BE2886AFE9FC0959DBDEA96E1C8544D04656695E8D8AC"}
         */

        private int code;
        private DataBean data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * expiration : 86400
             * freeflowsip : ["http://112.29.197.146/amobile.music.tc.qq.com/","http://112.29.197.147/amobile.music.tc.qq.com/","http://112.29.197.148/amobile.music.tc.qq.com/"]
             * keepalivefile : C400004TsFuW2mZbRR.m4a?guid=8196006125&vkey=79B1FFC3B05F0D1F76ECE8AA9E5828AEEC88BC8C0699DFD432EA8357E62CAD08D7D7BC371B2F63B15493545E79565DD7B95E18933669D2CD&uin=3299&fromtag=3
             * msg : ok
             * retcode : 0
             * servercheck : 078e9cf7d6577241057e0ae83d78ccba
             * sip : ["http://ws.stream.qqmusic.qq.com/","http://isure.stream.qqmusic.qq.com/","http://112.29.197.146/amobile.music.tc.qq.com/","http://112.29.197.147/amobile.music.tc.qq.com/","http://112.29.197.148/amobile.music.tc.qq.com/"]
             * testfile2g : C400003mAan70zUy5O.m4a?guid=8196006125&vkey=7573A852EA6DAD175F0565CAC5DA9EC5791A7002860E96DB745BE6404E08B2B7ACF0B225402786C23E81412274D64DA11EC950DDE0E8FFC9&uin=3299&fromtag=3
             * testfilewifi : C400003mAan70zUy5O.m4a?guid=8196006125&vkey=7573A852EA6DAD175F0565CAC5DA9EC5791A7002860E96DB745BE6404E08B2B7ACF0B225402786C23E81412274D64DA11EC950DDE0E8FFC9&uin=3299&fromtag=3
             * uin :
             * userip : 36.148.48.126
             * vkey : 1B38C8F21375D7C1A7C6CC6654B81DAAE48AC37471D8FE06E1FAC2AD9F8DD639951BE2886AFE9FC0959DBDEA96E1C8544D04656695E8D8AC
             */

            private int expiration;
            private String keepalivefile;
            private String msg;
            private int retcode;
            private String servercheck;
            private String testfile2g;
            private String testfilewifi;
            private String uin;
            private String userip;
            private String vkey;
            private List<String> freeflowsip;
            private List<String> sip;

            public int getExpiration() {
                return expiration;
            }

            public void setExpiration(int expiration) {
                this.expiration = expiration;
            }

            public String getKeepalivefile() {
                return keepalivefile;
            }

            public void setKeepalivefile(String keepalivefile) {
                this.keepalivefile = keepalivefile;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public int getRetcode() {
                return retcode;
            }

            public void setRetcode(int retcode) {
                this.retcode = retcode;
            }

            public String getServercheck() {
                return servercheck;
            }

            public void setServercheck(String servercheck) {
                this.servercheck = servercheck;
            }

            public String getTestfile2g() {
                return testfile2g;
            }

            public void setTestfile2g(String testfile2g) {
                this.testfile2g = testfile2g;
            }

            public String getTestfilewifi() {
                return testfilewifi;
            }

            public void setTestfilewifi(String testfilewifi) {
                this.testfilewifi = testfilewifi;
            }

            public String getUin() {
                return uin;
            }

            public void setUin(String uin) {
                this.uin = uin;
            }

            public String getUserip() {
                return userip;
            }

            public void setUserip(String userip) {
                this.userip = userip;
            }

            public String getVkey() {
                return vkey;
            }

            public void setVkey(String vkey) {
                this.vkey = vkey;
            }

            public List<String> getFreeflowsip() {
                return freeflowsip;
            }

            public void setFreeflowsip(List<String> freeflowsip) {
                this.freeflowsip = freeflowsip;
            }

            public List<String> getSip() {
                return sip;
            }

            public void setSip(List<String> sip) {
                this.sip = sip;
            }
        }
    }

    public static class Req0Bean {
        /**
         * code : 0
         * data : {"expiration":80400,"login_key":"","midurlinfo":[{"common_downfromtag":0,"errtype":"","filename":"C400001DI2Jj3Jqve9.m4a","flowfromtag":"","flowurl":"","hisbuy":0,"hisdown":0,"isbuy":0,"isonly":0,"onecan":0,"opi128kurl":"","opi192koggurl":"","opi192kurl":"","opi30surl":"","opi48kurl":"","opi96kurl":"","opiflackurl":"","p2pfromtag":0,"pdl":0,"pneed":0,"pneedbuy":0,"premain":0,"purl":"C400001DI2Jj3Jqve9.m4a?guid=8196006125&vkey=C1FF539320E343317D21CDAD89C6C94E08BD65A3B97D1D815535F5CF21DE518DB0713D56EAAC0A8551A252F64496D0A604D88760EB40D360&uin=3299&fromtag=66","qmdlfromtag":0,"result":0,"songmid":"004dFFPd4JNv8q","tips":"","uiAlert":0,"vip_downfromtag":0,"vkey":"C1FF539320E343317D21CDAD89C6C94E08BD65A3B97D1D815535F5CF21DE518DB0713D56EAAC0A8551A252F64496D0A604D88760EB40D360","wififromtag":"","wifiurl":""}],"msg":"36.148.48.126","retcode":0,"servercheck":"078e9cf7d6577241057e0ae83d78ccba","sip":["http://ws.stream.qqmusic.qq.com/","http://isure.stream.qqmusic.qq.com/"],"testfile2g":"C400003mAan70zUy5O.m4a?guid=8196006125&vkey=216A69F8E68A29421C0CDE83DE6DB73B640406CA571600A06209A5935408E5F153AAABC14B6E25F7515ABA8984942387C4B184EE55C1AAB6&uin=&fromtag=3","testfilewifi":"C400003mAan70zUy5O.m4a?guid=8196006125&vkey=216A69F8E68A29421C0CDE83DE6DB73B640406CA571600A06209A5935408E5F153AAABC14B6E25F7515ABA8984942387C4B184EE55C1AAB6&uin=&fromtag=3","thirdip":["",""],"uin":"","verify_type":0}
         */

        private int code;
        private DataBeanX data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public DataBeanX getData() {
            return data;
        }

        public void setData(DataBeanX data) {
            this.data = data;
        }

        @Data
        public static class DataBeanX {
            /**
             * expiration : 80400
             * login_key :
             * midurlinfo : [{"common_downfromtag":0,"errtype":"","filename":"C400001DI2Jj3Jqve9.m4a","flowfromtag":"","flowurl":"","hisbuy":0,"hisdown":0,"isbuy":0,"isonly":0,"onecan":0,"opi128kurl":"","opi192koggurl":"","opi192kurl":"","opi30surl":"","opi48kurl":"","opi96kurl":"","opiflackurl":"","p2pfromtag":0,"pdl":0,"pneed":0,"pneedbuy":0,"premain":0,"purl":"C400001DI2Jj3Jqve9.m4a?guid=8196006125&vkey=C1FF539320E343317D21CDAD89C6C94E08BD65A3B97D1D815535F5CF21DE518DB0713D56EAAC0A8551A252F64496D0A604D88760EB40D360&uin=3299&fromtag=66","qmdlfromtag":0,"result":0,"songmid":"004dFFPd4JNv8q","tips":"","uiAlert":0,"vip_downfromtag":0,"vkey":"C1FF539320E343317D21CDAD89C6C94E08BD65A3B97D1D815535F5CF21DE518DB0713D56EAAC0A8551A252F64496D0A604D88760EB40D360","wififromtag":"","wifiurl":""}]
             * msg : 36.148.48.126
             * retcode : 0
             * servercheck : 078e9cf7d6577241057e0ae83d78ccba
             * sip : ["http://ws.stream.qqmusic.qq.com/","http://isure.stream.qqmusic.qq.com/"]
             * testfile2g : C400003mAan70zUy5O.m4a?guid=8196006125&vkey=216A69F8E68A29421C0CDE83DE6DB73B640406CA571600A06209A5935408E5F153AAABC14B6E25F7515ABA8984942387C4B184EE55C1AAB6&uin=&fromtag=3
             * testfilewifi : C400003mAan70zUy5O.m4a?guid=8196006125&vkey=216A69F8E68A29421C0CDE83DE6DB73B640406CA571600A06209A5935408E5F153AAABC14B6E25F7515ABA8984942387C4B184EE55C1AAB6&uin=&fromtag=3
             * thirdip : ["",""]
             * uin :
             * verify_type : 0
             */

            private int expiration;
            private String login_key;
            private String msg;
            private int retcode;
            private String servercheck;
            private String testfile2g;
            private String testfilewifi;
            private String uin;
            private int verify_type;
            private List<MidurlinfoBean> midurlinfo;
            private List<String> sip;
            private List<String> thirdip;

            public static class MidurlinfoBean {
                /**
                 * common_downfromtag : 0
                 * errtype :
                 * filename : C400001DI2Jj3Jqve9.m4a
                 * flowfromtag :
                 * flowurl :
                 * hisbuy : 0
                 * hisdown : 0
                 * isbuy : 0
                 * isonly : 0
                 * onecan : 0
                 * opi128kurl :
                 * opi192koggurl :
                 * opi192kurl :
                 * opi30surl :
                 * opi48kurl :
                 * opi96kurl :
                 * opiflackurl :
                 * p2pfromtag : 0
                 * pdl : 0
                 * pneed : 0
                 * pneedbuy : 0
                 * premain : 0
                 * purl : C400001DI2Jj3Jqve9.m4a?guid=8196006125&vkey=C1FF539320E343317D21CDAD89C6C94E08BD65A3B97D1D815535F5CF21DE518DB0713D56EAAC0A8551A252F64496D0A604D88760EB40D360&uin=3299&fromtag=66
                 * qmdlfromtag : 0
                 * result : 0
                 * songmid : 004dFFPd4JNv8q
                 * tips :
                 * uiAlert : 0
                 * vip_downfromtag : 0
                 * vkey : C1FF539320E343317D21CDAD89C6C94E08BD65A3B97D1D815535F5CF21DE518DB0713D56EAAC0A8551A252F64496D0A604D88760EB40D360
                 * wififromtag :
                 * wifiurl :
                 */

                private int common_downfromtag;
                private String errtype;
                private String filename;
                private String flowfromtag;
                private String flowurl;
                private int hisbuy;
                private int hisdown;
                private int isbuy;
                private int isonly;
                private int onecan;
                private String opi128kurl;
                private String opi192koggurl;
                private String opi192kurl;
                private String opi30surl;
                private String opi48kurl;
                private String opi96kurl;
                private String opiflackurl;
                private int p2pfromtag;
                private int pdl;
                private int pneed;
                private int pneedbuy;
                private int premain;
                private String purl;
                private int qmdlfromtag;
                private int result;
                private String songmid;
                private String tips;
                private int uiAlert;
                private int vip_downfromtag;
                private String vkey;
                private String wififromtag;
                private String wifiurl;

                public int getCommon_downfromtag() {
                    return common_downfromtag;
                }

                public void setCommon_downfromtag(int common_downfromtag) {
                    this.common_downfromtag = common_downfromtag;
                }

                public String getErrtype() {
                    return errtype;
                }

                public void setErrtype(String errtype) {
                    this.errtype = errtype;
                }

                public String getFilename() {
                    return filename;
                }

                public void setFilename(String filename) {
                    this.filename = filename;
                }

                public String getFlowfromtag() {
                    return flowfromtag;
                }

                public void setFlowfromtag(String flowfromtag) {
                    this.flowfromtag = flowfromtag;
                }

                public String getFlowurl() {
                    return flowurl;
                }

                public void setFlowurl(String flowurl) {
                    this.flowurl = flowurl;
                }

                public int getHisbuy() {
                    return hisbuy;
                }

                public void setHisbuy(int hisbuy) {
                    this.hisbuy = hisbuy;
                }

                public int getHisdown() {
                    return hisdown;
                }

                public void setHisdown(int hisdown) {
                    this.hisdown = hisdown;
                }

                public int getIsbuy() {
                    return isbuy;
                }

                public void setIsbuy(int isbuy) {
                    this.isbuy = isbuy;
                }

                public int getIsonly() {
                    return isonly;
                }

                public void setIsonly(int isonly) {
                    this.isonly = isonly;
                }

                public int getOnecan() {
                    return onecan;
                }

                public void setOnecan(int onecan) {
                    this.onecan = onecan;
                }

                public String getOpi128kurl() {
                    return opi128kurl;
                }

                public void setOpi128kurl(String opi128kurl) {
                    this.opi128kurl = opi128kurl;
                }

                public String getOpi192koggurl() {
                    return opi192koggurl;
                }

                public void setOpi192koggurl(String opi192koggurl) {
                    this.opi192koggurl = opi192koggurl;
                }

                public String getOpi192kurl() {
                    return opi192kurl;
                }

                public void setOpi192kurl(String opi192kurl) {
                    this.opi192kurl = opi192kurl;
                }

                public String getOpi30surl() {
                    return opi30surl;
                }

                public void setOpi30surl(String opi30surl) {
                    this.opi30surl = opi30surl;
                }

                public String getOpi48kurl() {
                    return opi48kurl;
                }

                public void setOpi48kurl(String opi48kurl) {
                    this.opi48kurl = opi48kurl;
                }

                public String getOpi96kurl() {
                    return opi96kurl;
                }

                public void setOpi96kurl(String opi96kurl) {
                    this.opi96kurl = opi96kurl;
                }

                public String getOpiflackurl() {
                    return opiflackurl;
                }

                public void setOpiflackurl(String opiflackurl) {
                    this.opiflackurl = opiflackurl;
                }

                public int getP2pfromtag() {
                    return p2pfromtag;
                }

                public void setP2pfromtag(int p2pfromtag) {
                    this.p2pfromtag = p2pfromtag;
                }

                public int getPdl() {
                    return pdl;
                }

                public void setPdl(int pdl) {
                    this.pdl = pdl;
                }

                public int getPneed() {
                    return pneed;
                }

                public void setPneed(int pneed) {
                    this.pneed = pneed;
                }

                public int getPneedbuy() {
                    return pneedbuy;
                }

                public void setPneedbuy(int pneedbuy) {
                    this.pneedbuy = pneedbuy;
                }

                public int getPremain() {
                    return premain;
                }

                public void setPremain(int premain) {
                    this.premain = premain;
                }

                public String getPurl() {
                    return purl;
                }

                public void setPurl(String purl) {
                    this.purl = purl;
                }

                public int getQmdlfromtag() {
                    return qmdlfromtag;
                }

                public void setQmdlfromtag(int qmdlfromtag) {
                    this.qmdlfromtag = qmdlfromtag;
                }

                public int getResult() {
                    return result;
                }

                public void setResult(int result) {
                    this.result = result;
                }

                public String getSongmid() {
                    return songmid;
                }

                public void setSongmid(String songmid) {
                    this.songmid = songmid;
                }

                public String getTips() {
                    return tips;
                }

                public void setTips(String tips) {
                    this.tips = tips;
                }

                public int getUiAlert() {
                    return uiAlert;
                }

                public void setUiAlert(int uiAlert) {
                    this.uiAlert = uiAlert;
                }

                public int getVip_downfromtag() {
                    return vip_downfromtag;
                }

                public void setVip_downfromtag(int vip_downfromtag) {
                    this.vip_downfromtag = vip_downfromtag;
                }

                public String getVkey() {
                    return vkey;
                }

                public void setVkey(String vkey) {
                    this.vkey = vkey;
                }

                public String getWififromtag() {
                    return wififromtag;
                }

                public void setWififromtag(String wififromtag) {
                    this.wififromtag = wififromtag;
                }

                public String getWifiurl() {
                    return wifiurl;
                }

                public void setWifiurl(String wifiurl) {
                    this.wifiurl = wifiurl;
                }
            }
        }
    }
}
