##qq音乐查询接口
https://c.y.qq.com/soso/fcgi-bin/client_search_cp?ct=24&catZhida=1&p=1&n=10&w=邓紫棋&format=json&inCharset=utf8&outCharset=utf-8
p是页数，n是一页数据量，w则是查询信息

#这是查询弹出式的接口
https://c.y.qq.com/splcloud/fcgi-bin/smartbox_new.fcg?is_xml=0
&key=邓紫棋&format=json
&inCharset=utf8
&outCharset=utf-8
&platform=yqq.json

请求后返回的数据
{
    "code":0,
    "data":{
        "album":{
            "count":2,
            "itemlist":[
                {
                    "docid":"9812833",
                    "id":"9812833",
                    "mid":"0049MVh824D7bM",
                    "name":"摩天动物园",
                    "pic":"http://y.gtimg.cn/music/photo_new/T002R180x180M0000049MVh824D7bM_1.jpg",
                    "singer":"G.E.M. 邓紫棋"
                },
                {
                    "docid":"1196826",
                    "id":"1196826",
                    "mid":"003c616O2Zlswm",
                    "name":"新的心跳",
                    "pic":"http://y.gtimg.cn/music/photo_new/T002R180x180M000003c616O2Zlswm_1.jpg",
                    "singer":"G.E.M. 邓紫棋"
                }
            ],
            "name":"专辑",
            "order":2,
            "type":3
        },
        "mv":{
            "count":2,
            "itemlist":[
                {
                    "docid":"1582631",
                    "id":"1582631",
                    "mid":"003Fk1CR3u9pbX",
                    "name":"句号",
                    "singer":"G.E.M. 邓紫棋",
                    "vid":"b0032xtzvw6"
                },
                {
                    "docid":"658093",
                    "id":"658093",
                    "mid":"000Mbp6E0hsgEv",
                    "name":"来自天堂的魔鬼",
                    "singer":"G.E.M. 邓紫棋",
                    "vid":"v001892io9b"
                }
            ],
            "name":"MV",
            "order":3,
            "type":4
        },
        "singer":{
            "count":2,
            "itemlist":[
                {
                    "docid":"13948",
                    "id":"13948",
                    "mid":"001fNHEf1SFEFN",
                    "name":"G.E.M. 邓紫棋",
                    "pic":"http://y.gtimg.cn/music/photo_new/T001R150x150M000001fNHEf1SFEFN_2.jpg",
                    "singer":"G.E.M. 邓紫棋"
                },
                {
                    "docid":"2907567",
                    "id":"2907567",
                    "mid":"001B2drs3Jq4EX",
                    "name":"等什么君",
                    "pic":"http://y.gtimg.cn/music/photo_new/T001R150x150M000001B2drs3Jq4EX_1.jpg",
                    "singer":"等什么君"
                }
            ],
            "name":"歌手",
            "order":1,
            "type":2
        },
        "song":{
            "count":4,
            "itemlist":[
                {
                    "docid":"247347346",
                    "id":"247347346",
                    "mid":"001QJyJ32zybEe",
                    "name":"句号",
                    "singer":"G.E.M. 邓紫棋"
                },
                {
                    "docid":"200255722",
                    "id":"200255722",
                    "mid":"002E3MtF0IAMMY",
                    "name":"光年之外",
                    "singer":"G.E.M. 邓紫棋"
                },
                {
                    "docid":"104913384",
                    "id":"104913384",
                    "mid":"004dFFPd4JNv8q",
                    "name":"来自天堂的魔鬼",
                    "singer":"G.E.M. 邓紫棋"
                },
                {
                    "docid":"1530858",
                    "id":"1530858",
                    "mid":"001X0PDf0W4lBq",
                    "name":"泡沫",
                    "singer":"G.E.M. 邓紫棋"
                }
            ],
            "name":"单曲",
            "order":0,
            "type":1
        }
    },
    "subcode":0
}
#这是查询歌曲接口
https://c.y.qq.com/soso/fcgi-bin/client_search_cp?ct=24
&catZhida=1
&p=2
&n=10
&w=邓紫棋
&format=json
&inCharset=utf8
&outCharset=utf-8
请求返回的数据
{
    "code":0,
    "data":{
        "keyword":"邓紫棋",
        "priority":0,
        "qc":[],
        "semantic":{
            "curnum":0,
            "curpage":2,
            "list":[],
            "totalnum":0
        },
        "song":{
            "curnum":10,
            "curpage":2,
            "list":[
                {
                    "albumid":9812833,
                    "albummid":"0049MVh824D7bM",
                    "albumname":"摩天动物园",
                    "albumname_hilight":"摩天动物园",
                    "alertid":2,
                    "belongCD":0,
                    "cdIdx":4,
                    "chinesesinger":0,
                    "docid":"14628361575978066456",
                    "grp":[],
                    "interval":290,
                    "isonly":0,
                    "lyric":"《可不可以，你也刚好喜欢我》电影主题曲",
                    "lyric_hilight":"《可不可以，你也刚好喜欢我》电影主题曲",
                    "media_mid":"002qtwZJ32UUxO",
                    "msgid":16,
                    "newStatus":2,
                    "nt":560439931,
                    "pay":{
                        "payalbum":0,
                        "payalbumprice":0,
                        "paydownload":1,
                        "payinfo":1,
                        "payplay":0,
                        "paytrackmouth":1,
                        "paytrackprice":200
                    },
                    "preview":{
                        "trybegin":66188,
                        "tryend":94359,
                        "trysize":960887
                    },
                    "pubtime":1577376010,
                    "pure":0,
                    "singer":[
                        {
                            "id":13948,
                            "mid":"001fNHEf1SFEFN",
                            "name":"G.E.M. 邓紫棋",
                            "name_hilight":"G.E.M. <em>邓紫棋</em>"
                        }
                    ],
                    "size128":4645412,
                    "size320":11612617,
                    "sizeape":0,
                    "sizeflac":28172270,
                    "sizeogg":6088270,
                    "songid":248413022,
                    "songmid":"002qtwZJ32UUxO",
                    "songname":"很久以后",
                    "songname_hilight":"很久以后",
                    "strMediaMid":"002qtwZJ32UUxO",
                    "stream":1,
                    "switch":17413891,
                    "t":1,
                    "tag":11,
                    "type":0,
                    "ver":0,
                    "vid":"u00336fqv1a"
                }
            ],
            "totalnum":600
        },
        "tab":0,
        "taglist":[],
        "totaltime":0,
        "zhida":{
            "type":1,
            "zhida_singer":{

            }
        }
    },
    "message":"",
    "notice":"",
    "subcode":0,
    "time":1587209691,
    "tips":""
}

F826792845ECAFE7751C012F36FB429CF8E268430F8F0DCFF1CA48A1AC92DBF736D0A157EABCE9D07924D86F8CFB7CAA69715D3FF88BA78A
#取vkey地址
https://u.y.qq.com/cgi-bin/musics.fcg?sign=zzax6o4b3yoz93ty14b575e160eb879011cbb67b146f383fb3
&format=json
&inCharset=utf8
&outCharset=utf-8
&platform=yqq.json
&data={"req":{"module":"CDN.SrfCdnDispatchServer","method":"GetCdnDispatch","param":{"guid":"8196006125","calltype":0,"userip":""}},"req_0":{"module":"vkey.GetVkeyServer","method":"CgiGetVkey","param":{"guid":"8196006125","songmid":["004dFFPd4JNv8q"],"songtype":[0],"uin":"1021414627","loginflag":1,"platform":"20"}},"comm":{"uin":1021414627,"format":"json","ct":24,"cv":0}}
#歌曲地址
https://isure.stream.qqmusic.qq.com/C400001DI2Jj3Jqve9.m4a?guid=8196006125
&vkey=59A1797D0D76F380EFB147F52DCB17CC044D39DBEE72AEAD57361324CD5711EBE63A2EF949DD9BA2368CC71A345BBDD1A31AFD9CC2F1A40
3&uin=3299
&fromtag=66


#获取mv的vid地址
https://u.y.qq.com/cgi-bin/musics.fcg?sign=zzan1ajfx27pvf95b6e18bcfea6883cbe9acf42a3957757
&hostUin=0
&format=json
&inCharset=utf8
&outCharset=utf-8
&notice=0
&platform=yqq.json
&needNewCode=0
&data={"comm":{"ct":24,"cv":0},"mv":{"module":"MvService.MvInfoProServer","method":"GetMvBySongid","param":{"mids":["004dFFPd4JNv8q"]}}}




String url = QqService.MUSIC_PLAY_URL_PREFIX + searchResultSongInfoSearchResult.getData().getPure();
                                    System.out.println(url);
                                    try {
                                        URL urls = new URL(url);
//                                        URL resource = PlayerMainPanel.class.getResource("/music/魔鬼中的天使.m4a");
                                        Media media = new Media(urls.toString());
                                        mediaList.add(media);
                                        player = new MediaPlayer(media);
                                        player.setVolume(((double) volumeSlider.getValue()) / 100);
                                        jSlider.setMinimum(0);
                                        player.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                                            if (!isPlayChange) {
                                                Duration currentTime = player.getCurrentTime();
                                                jSlider.setMaximum((int) player.getMedia().getDuration().toSeconds());
                                                jSlider.setValue((int) currentTime.toSeconds());
                                            }
                                        });
                                    } catch (MalformedURLException e) {
                                        e.printStackTrace();
                                    }
                                    
                                    
https://u.y.qq.com/cgi-bin/musicu.fcg?format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&data={"req":{"module":"CDN.SrfCdnDispatchServer","method":"GetCdnDispatch","param":{"guid":"6676641631","calltype":0,"userip":""}},"req_0":{"module":"vkey.GetVkeyServer","method":"CgiGetVkey","param":{"guid":"6676641631","songmid":["002TNUCE0M6XJH"],"songtype":[0],"uin":"1021414627","loginflag":1,"platform":"20"}},"comm":{"uin":1021414627,"format":"json","ct":24,"cv":0}}
https://u.y.qq.com/cgi-bin/musicu.fcg?g_tk=847635201&format=jsonp&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0&data={"req":{"module":"CDN.SrfCdnDispatchServer","method":"GetCdnDispatch","param":{"guid":"6676641631","calltype":0,"userip":""}},"req_0":{"module":"vkey.GetVkeyServer","method":"CgiGetVkey","param":{"guid":"6676641631","songmid":["004dFFPd4JNv8q"],"songtype":[0],"uin":"1021414627","loginflag":1,"platform":"20"}},"comm":{"uin":1021414627,"format":"json","ct":24,"cv":0}}
    {"req":{"module":"CDN.SrfCdnDispatchServer","method":"GetCdnDispatch","param":{"guid":"6676641631","calltype":0,"userip":""}},"req_0":{"module":"vkey.GetVkeyServer","method":"CgiGetVkey","param":{"guid":"6676641631","songmid":["00394z9S2ciPAD"],"songtype":[0],"uin":"1021414627","loginflag":1,"platform":"20"}},"comm":{"uin":1021414627,"format":"json","ct":24,"cv":0}}
    {"req":{"module":"CDN.SrfCdnDispatchServer","method":"GetCdnDispatch","param":{"guid":"6676641631","calltype":0,"userip":""}},"req_0":{"module":"vkey.GetVkeyServer","method":"CgiGetVkey","param":{"guid":"6676641631","songmid":["004dFFPd4JNv8q"],"songtype":[0],"uin":"1021414627","loginflag":1,"platform":"20"}},"comm":{"uin":1021414627,"format":"json","ct":24,"cv":0}}