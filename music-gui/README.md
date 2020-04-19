#Mac风格的swing

这个模块依赖了flatlaf，这玩意最吊的是这个ui风格，
Materila Theme ui这个idea插件不陌生吧，主题是flatlaf制作的

==============================================================================
当然我也不是全部用的它的风格，自己百度敲敲打打搞出来的，画图的代码大部分来源于网络 |
==============================================================================

##swing包
这个包下面有两个包，一个<a href="#ui">UI包</a>，一个<a href="#exception">exception包</a>，明眼人一眼就能明白，不多解释


##<a id="exception">exception包</a>
这个包下面有：
            1、OutOptionException异常，这个异常主要是在设置透明度时候抛出的像CustomizeJavaButton#setOptions(float options)方法
            
            

##<a id="ui">UI包</a>
这个包下东西就多，有：
             1、CustomizeJavaFrame:继承的JFrame
             2、CustomizeJavaButton:继承的JButton,
                能不用这个按钮就不要用这个按钮,用swing自带的JButton,因为swing自带的有flatlaf加持,并且不需要你去绘制圆角等
                这玩意最大的作用是,我放在CustomizeJavaFrame顶部的三个必带的按钮
             3、CustomizeJavaDialog:继承的JDialog,但是实际上使用的CustomizeJavaFrame绘制的，改写了主体部分，
             4、CustomizeJavaScrollBar:继承的BasicScrollBarUI,将其绘制成了圆角的长条状,这代码来源于一篇博客,全是,我只是改写了一些数值
             5、CustomizeJavaScrollPane:继承的JScrollPane,老规矩圆角界面圆角长条的CustomizeJavaScrollBar,有一定的缺陷，不过好在有flatlaf加持
             6、CustomizeJavaTextField:继承的JTextField,圆角矩形输入框,无边框,一定要有flatlaf加持,不然刻画有点问题
             7、TitleButton这玩意是个枚举,就是CustomizeJavaFrame顶部的三个必带的按钮中的哪一个
             8、interfaces包
