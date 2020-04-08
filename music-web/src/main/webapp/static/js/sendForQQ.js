let param_json = '{"comm":{"ct":24},"category":{"method":"get_hot_category","param":{"qq":""},"module":"music.web_category_svr"},"recomPlaylist":{"method":"get_hot_recommend","param":{"async":1,"cmd":2},"module":"playlist.HotRecommendServer"},"playlist":{"method":"get_playlist_by_category","param":{"id":8,"curPage":1,"size":40,"order":5,"titleid":8},"module":"playlist.PlayListPlazaServer"},"new_song":{"module":"newsong.NewSongServer","method":"get_new_song_info","param":{"type":5}},"new_album":{"module":"newalbum.NewAlbumServer","method":"get_new_album_info","param":{"area":1,"sin":0,"num":10}},"new_album_tag":{"module":"newalbum.NewAlbumServer","method":"get_new_album_area","param":{}},"toplist":{"module":"musicToplist.ToplistInfoServer","method":"GetAll","param":{}},"focus":{"module":"QQMusic.MusichallServer","method":"GetFocus","param":{}}}';
let urls = "https://u.y.qq.com/cgi-bin/musics.fcg?-=recom0203443812888795&sign=zzarzyyjd58lfqyaje6a87a3905322d58dff74cc847b1770f&hostUin=0&format=json&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq.json&needNewCode=0&data=" + param_json;

let s = $.ajax({
    url: urls,
    async: false,
    method: 'get',
    dataType: 'jsonp',
    beforeSend: function (request) {
        request.setRequestHeader("Origin", "https://y.qq.com")
            .setRequestHeader("Referer", "https://y.qq.com");
    },
    success: function (data) {
        getNavForJson(data)
    }
});


/**
 * 往导航栏添加控件，从json数据中
 * @param data
 */
function getNavForJson(data) {
    let element = document.getElementById("category");
    console.log(data.category.data.category[0].items);
    let str = "";
    let items = data.category.data.category[0].items;
    for (let i = 0; i < items.length; i++) {
        if (i === 12) {
            break;
        }
        str += "<li class=''><a href='#'>" + items[i].item_name + "</a></li>";
    }
    element.innerHTML = str;
}

