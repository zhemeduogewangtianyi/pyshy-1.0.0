<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <style>
        .out_row {
            margin-left: 20%;
            margin-top: 15%;
            margin-right: 20%;
        }
        .header{
            margin-left: 40%;
            margin-bottom: -12%;
            padding-top: 12%;
        }
        .count {
            width: 40%;
            margin-top: 10%;
            padding: 40px 60px 60px;
            box-sizing: border-box;
        }
        .btn_login {
            margin-left: 35%;
        }
        body{
            background:url("http://originoo-1.b0.upaiyun.com//28/2018/06/06/p_9bybe4rqzty1ms5jouvtbnma8u3t0jq7.jpg!contest")  no-repeat center center;
            background-size:cover;
            background-attachment:fixed;
            background-color:#CCCCCC;
        }
    </style>
    <meta charset="UTF-8">
    <title>登录</title>
    <#include "../include/head.ftl" />

</head>
<body >

<div class="login-box">
    <form id="form" action="/lgmanager/login" method="post">
        <div class="container-fluid count">

            <div class="header">
                <h1>用户登录</h1>
            </div>

            <div class="out_row block">

                <div class="row">
                    <div class="form-group col-md-12">
                        <input type="hidden" class="form-control" id="message" value="${msg}"/>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="username">账号：</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="请输入账号" />
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="password">密码：</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" />
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="rememberMe">记住账号</label>
                        <input type="checkbox" class="aotoLogin" name="rememberMe" id="rememberMe" />
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-sm-12 btn_login">
                        <input type="submit" class="btn btn-primary btn-round login-btn" value="立即登录" id="loginBtn">
                    </div>
                </div>

            </div>
        </div>
    </form>
</div>
<script>
    $(function(){debugger
        $("#username").focus();

        if($("#message").val()){debugger
            layer.msg($("#message").val());
        }
    });
</script>

</body>
</html>