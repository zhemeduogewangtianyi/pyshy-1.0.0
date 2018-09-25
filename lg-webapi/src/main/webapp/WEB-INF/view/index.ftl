<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        .about{
            margin: 10%;
        }
        .picture{
            margin-top: -5%;
        }
        .footer {
            color: #9e9e9e;
            padding: 30px 0;
            border-top: 1px solid #e5e5e5;
            margin-top: 70px;
        }
        .footer-top .about>div h4 {
            color: #563d7c;
            font-size: 16px;
        }
        .footer a {
            color: #9e9e9e;
        }
        .footer-top .about>div {
            height: 110px;
            margin-bottom: 10px;
        }
    </style>
    <meta charset="UTF-8">
    <title>首页</title>
    <#include "include/head.ftl">
</head>
<body>

    <!-- 导航栏 -->
    <div class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand hidden-sm" href="http://localhost:8083" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'navbar-首页'])">PYSHY</a>
            </div>
            <div class="navbar-collapse collapse" role="navigation">
                <ul class="nav navbar-nav">
                    <li class="hidden-sm hidden-md"><a href="https://v2.bootcss.com/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v2doc'])">PYSHY简介</a></li>
                    <li><a href="https://v3.bootcss.com/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v3doc'])">PYSHY活动通知</a></li>
                    <li><a href="https://v4.bootcss.com/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'v4doc'])">PYSHY我要投稿</a></li>
                    <li><a href="/p/lesscss/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'less'])">PYSHY 网站教程</a></li>
                    <li><a href="https://www.jquery123.com/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'jquery'])">PYSHY 对外API</a></li>
                    <li><a class="reddot" href="http://www.youzhan.org/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'youzhan-main-nav'])">PYSHY 以往实例</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right hidden-sm">
                    <li><a href="/about/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'about'])">关于</a></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- 滚动图片 -->
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img style="width: 100%;height: 750px" src="http://originoo-1.b0.upaiyun.com//sys/2018/07/17/p_dqwkyjjg1svn09nd01tm2cmeunn2216h.jpg!originoo" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img style="width: 100%;height: 750px" src="http://originoo-1.b0.upaiyun.com//28/2018/06/06/p_9bybe4rqzty1ms5jouvtbnma8u3t0jq7.jpg!contest" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img style="width: 100%;height: 750px" src="http://originoo-1.b0.upaiyun.com//originoograde/ExcellentPicture/2924/20180609/4qbdl8pzlf3s8o7hmncx5qmdvy1nuv6u_BVS-P0041648.jpg!style1024" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <!-- 小菜单 -->


    <!-- 描述 -->
    <div class="about" id="over-ons">
        <!-- 具体描述 -->
        <div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-2 col-md-1"></div>
                    <div class="col-lg-8 col-md-10">
                        <article>

                            <header class="post-header">
                                <span class="editable" data-cms-source="/_layouts/home.html" data-cms-index="0">关于网站</span>
                                <h1 class="post-title editable" data-cms-source="/_layouts/home.html" data-cms-index="1">学习和展示</h1>
                            </header>

                            <div class="post-content"><div class="editable" data-cms-source="/_layouts/home.html" data-cms-index="2">
                                <p>人最宝贵的生命，生命属于每个人只有一次。人的一生应当这样度过。回首往事，不应虚度年华而悔恨，也不因碌碌无为而羞愧，临终时能说：我的整个生命和全部精力都献给了世界上最壮丽的事业——为人类的解放而斗争。”看到这时我又是怎样的震惊！那是在怎样的情景下说的话，那种坚韧，那种无惧，他是伟大的战士，我为他高声歌颂。
                                <#--<a target="_blank" href="#">Read more...</a>-->
                                </p></div>
                            <#--<a href="#" class="btn btn-primary">Our collections</a>-->
                            </div>

                        </article>
                    </div>
                    <div class="col-lg-2 col-md-1"></div>
                </div>
            </div>
        </div>
    </div>


    <!--内容展示-->
    <div class="twocols">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-lg-6">
                    <article>
                        <div class="post-content">
                            <div class="editable" data-cms-source="/_layouts/home.html" data-cms-index="8">
                                <p>
                                    <img src="//goss.vcg.com/223a9bb0-a1bc-11e8-a6fe-4d6f889a23c9.jpg" style="margin-left: -70%;margin-bottom: 200px;" />
                                </p>
                            </div>
                        </div>
                    </article>
                </div>
            </div>
        </div>
    </div>

    <div class="picture">
        <div class="row" style="margin-left: 15%;margin-top: 3%;">
            <div class="col-sm-6 col-md-5">
                <div class="thumbnail">
                    <img src="//goss.vcg.com/3a750b70-faa0-11e7-a964-b7ed0e8248ba.jpg" alt="...">
                    <div class="caption">
                        <h3>图片名称</h3>
                        <p>图片描述</p>
                        <p><a href="#" class="btn btn-primary" role="button">赞</a> <a href="#" class="btn btn-default" role="button">踩</a></p>
                    </div>
                </div>
            </div>

            <div class="col-sm-6 col-md-5">
                <div class="thumbnail">
                    <img src="//goss.vcg.com/5d46dfd0-96d0-11e8-a1e2-2d7e6e186c78.jpg" alt="...">
                    <div class="caption">
                        <h3>图片名称</h3>
                        <p>图片描述</p>
                        <p><a href="#" class="btn btn-primary" role="button">赞</a> <a href="#" class="btn btn-default" role="button">踩</a></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row" style="margin-left: 15%;margin-top: 3%;">
            <div class="col-sm-6 col-md-5">
                <div class="thumbnail">
                    <img src="//goss.vcg.com/8f6f0b70-492f-11e8-9489-53a1f1be40ec.jpg" alt="...">
                    <div class="caption">
                        <h3>图片名称</h3>
                        <p>图片描述</p>
                        <p><a href="#" class="btn btn-primary" role="button">赞</a> <a href="#" class="btn btn-default" role="button">踩</a></p>
                    </div>
                </div>
            </div>

            <div class="col-sm-6 col-md-5">
                <div class="thumbnail">
                    <img src="//goss.vcg.com/20f282e0-bd69-11e8-8a56-3b117dc7520d.jpg" alt="...">
                    <div class="caption">
                        <h3>图片名称</h3>
                        <p>图片描述</p>
                        <p><a href="#" class="btn btn-primary" role="button">赞</a> <a href="#" class="btn btn-default" role="button">踩</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- FOOTER -->
    <footer class="footer ">
        <div class="container">
            <div class="row footer-top">
                <div class="col-md-6 col-lg-6">
                    <h4>
                        <img src="https://assets.bootcss.com/www/assets/img/logo.png?1532594948592">
                    </h4>
                    <p>我们一直致力于为广大劳动人民提供最优质的页面！</p>
                </div>
                <div class="col-md-6  col-lg-5 col-lg-offset-1">
                    <div class="row about">
                        <div class="col-sm-3">
                            <h4>关于</h4>
                            <ul class="list-unstyled">
                                <li><a href="/about/">关于我们</a></li>
                                <li><a href="/ad/">广告合作</a></li>
                                <li><a href="/links/">友情链接</a></li>
                                <li><a href="/hr/">找我谈谈</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-3">
                            <h4>联系方式</h4>
                            <ul class="list-unstyled">
                                <li><a href="http://weibo.com/bootcss" title="王富贵中文网官方微博" target="_blank">新浪微博</a></li>
                                <li><a href="mailto:admin@bootcss.com">电子邮件</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-4">
                            <h4>旗下网站</h4>
                            <ul class="list-unstyled">
                                <li><a href="http://www.golaravel.com/" target="_blank">Laravel中文网</a></li>
                                <li><a href="http://www.ghostchina.com/" target="_blank">Ghost中国</a></li>
                                <li><a href="http://www.bootcdn.cn/" target="_blank">BootCDN</a></li>
                                <li><a href="https://pkg.phpcomposer.com/" target="_blank">Packagist中国镜像</a></li>
                                <li><a href="https://www.return.net/" target="_blank">燃腾教育</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-2">
                            <h4>赞助商</h4>
                            <ul class="list-unstyled">
                                <li><a href="https://www.jdcloud.com/" target="_blank">京东云</a></li>
                                <li><a href="https://www.upyun.com" target="_blank">又拍云</a></li>
                            </ul>
                        </div>
                    </div>

                </div>
            </div>
            <hr>
            <div class="row footer-bottom">
                <ul class="list-inline text-center">
                    <li><a href="http://www.miibeian.gov.cn/" target="_blank">京ICP备11008151号</a></li><li>京公网安备11010802014853</li>
                    <p class="float-right"><a href="#">回到顶部</a></p>
                </ul>
            </div>
        </div>
    </footer>
</body>
</html>