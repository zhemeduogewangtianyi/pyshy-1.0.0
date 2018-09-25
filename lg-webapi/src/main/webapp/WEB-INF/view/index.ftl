<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        .about{
            margin: 15%;
        }
        .picture{
            margin-top: -5%;
        }
        .footer{
            margin-top: 8%;
        }
    </style>
    <meta charset="UTF-8">
    <title>首页</title>
    <#include "include/head.ftl">
</head>
<body>

    <!-- 导航栏 -->
    <div class="bs-example bs-navbar-top-example" data-example-id="navbar-fixed-to-top">
        <nav class="navbar navbar-default navbar-fixed-top">
            <!-- We use the fluid option here to avoid overriding the fixed width of a normal container within the narrow content columns. -->
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-6" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">PYSHY</a>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-6">
                    <ul class="nav navbar-nav">
                        <li class="first active"><a href="#">首页</a></li>
                        <li><a class="secend" href="#">二页</a></li>
                        <li><a class="three" href="#">三页</a></li>
                    </ul>
                </div>
            </div>
        </nav>
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
                <img style="width: 100%;height: 537.56px" src="http://originoo-1.b0.upaiyun.com//28/2018/06/06/p_9bybe4rqzty1ms5jouvtbnma8u3t0jq7.jpg!contest" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img style="width: 100%;height: 537.56px" src="http://originoo-1.b0.upaiyun.com//sys/2018/07/17/p_dqwkyjjg1svn09nd01tm2cmeunn2216h.jpg!originoo" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img style="width: 100%;height: 537.56px" src="http://originoo-1.b0.upaiyun.com//originoograde/ExcellentPicture/2924/20180609/4qbdl8pzlf3s8o7hmncx5qmdvy1nuv6u_BVS-P0041648.jpg!style1024" alt="...">
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
                                    <img src="//goss.vcg.com/223a9bb0-a1bc-11e8-a6fe-4d6f889a23c9.jpg" style="margin-left: -75%;margin-bottom: 200px;" />
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
    <footer class="container footer">
        <p class="float-right"><a href="#">回到顶部</a></p>
        <p>© 2017-2018 Company, Inc. · </p>
    </footer>
</body>
</html>