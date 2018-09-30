<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <style>
        .carousel-inner img {
            width:100%;
        }
    </style>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <#include "include/head.ftl">
</head>
<body>

<!-- HEADER -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">后台管理</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${realname}</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">帮助 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
                <li><a href="/lgmanager/logout">退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<!-- INNER -->
<div class="container-fluid">

    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-pills nav-stacked">
                <li class="active menu" data-src="/pandect/list"><a href="#">总览</a></li>
                <li class="menu" data-src="/picture/list"><a href="#">图片管理</a></li>
                <li class="menu" data-src="/user/list"><a href="#">用户管理</a></li>
                <li class="menu" data-src="/banner/list"><a href="#">Banner</a></li>
            <#--<li class="menu" data-src="/pandect/list"><a href="#">oracle</a></li>-->
                <li class="menu" data-src="/test/list"><a href="#">Test</a></li>
            </ul>
        </div>

        <!-- 16:9 aspect ratio -->
        <div class="embed-responsive embed-responsive-16by9">
            <iframe id="iframe" class="embed-responsive-item" src="<#if menu??>${menu}<#else>/pandect/list</#if>"></iframe>
        </div>

    </div>
</div>

<!-- FOOTER -->
<footer class="container">
    <p class="float-right"><a href="#">回到顶部</a></p>
    <p>© 2017-2018 Company, Inc. · </p>
</footer>

<script>

    $(function(){
        var iframe = $("#iframe").attr("src");

        $('.menu').each(function(){

            if(iframe == $(this).attr("data-src")){
                $(this).siblings().removeClass("active");
                $(this).addClass("active");
            }

        });
    });

    $('.carousel').carousel({
        interval: 5600
    })

    $(".menu").click(function () {
        $(this).siblings().removeClass("active");
        $(this).addClass("active");
        $("#iframe").attr("src",$(this).attr("data-src"));
    });

</script>

</body>
</html>