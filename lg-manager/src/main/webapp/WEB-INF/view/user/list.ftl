<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <style>
        .carousel-inner img {
            width:100%;
        }
    </style>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <#include "../include/head.ftl">
</head>
<body>
<form id="searchUserForm" name="searchUserForm" method="post">
    <input id="state" name="state" type="hidden" value="" />
</form>
<div id="wl-cont">
    <ul class="nav nav-tabs status-tabs">
        <li class="J_tab active" onclick="queryByState()" data-check-status="0"><a href="#" data-toggle="tab">全部</a></li>
        <li class="J_tab" onclick="queryByState(0)" data-check-status="1"><a href="#" data-toggle="tab">启用</a></li>
        <li class="J_tab" onclick="queryByState(1)" data-check-status="2"><a href="#" data-toggle="tab">停用</a></li>
    </ul>

    <table class="table table-striped"
           data-toggle="table"
           data-url="/user/pageQuery"
           data-striped="true"
           data-cache="false"
           data-data-type="json"
           data-pagination="true"
           data-side-pagination="server"
           data-page-number="1"
           data-page-size="10"
           data-page-list="[]"
           data-search="false"
           data-card-view="false"
           data-query-params="queryParams"
           id="dataTable">
        <thead>
        <tr>
            <th data-width="15%" data-class="text-center" data-field="uid" data-formatter="uid_formatter">#</th>
            <th data-width="25%" data-class="text-center" data-field="name" data-formatter="name_formatter">用户名称</th>
            <th data-width="25%" data-class="text-center" data-field="username" data-formatter="username_formatter">用户账号</th>
            <th data-width="15%" data-class="text-center" data-formatter="state_formatter">用户状态</th>
            <th data-width="20%" data-class="text-center" data-formatter="opration_formatter">操作</th>
        </tr>
        </thead>
    </table>
</div>

<script>
    $(function() {
        $('#dataTable').bootstrapTable();
    });

    function queryParams(params){
        if(!params){
            params = {}
        }
        var state = $('.J_tab.active').attr('data-state');
        params = {
            state : state,
            order : params.order,
            offset : params.offset,
            limit : params.limit
        }
        return params;
    }

    function queryByState(data){
        $("#state").val(data);
        $.ajax({
            url : "/user/pageQuery",
            data : $("#searchUserForm").serialize(),
            success : function(){

            }
        });
    }

    /*#################formatter#################*/

    function uid_formatter(index,row,value){
        var str = "";
        str += "<span title='" + row.uid + "'>"+ row.uid +"</span>";
        return str;
    }

    function name_formatter(index,row,value){
        var str = "";
        str += "<span title='" + row.name + "'>"+ row.name +"</span>";
        return str;
    }

    function username_formatter(index,row,value){
        var str = "";
        str += "<span title='" + row.username + "'>"+ row.username +"</span>";
        return str;
    }

    function state_formatter(index,row,value){
        var str = "";
        if(row.state == 0){
            str += "<span title='启用中'>启用中</span>";
        }
        if(row.state == 1){
            str += "<span title='已停用'>已停用</span>";
        }
        return str;
    }

    function opration_formatter(index,row,value){
        var str = "";
        str += "<span title='" + row.name + "详情'><a href='#' onclick='show_detail("+ row.uid +")'>详情</a></span>&nbsp&nbsp";
        str += "<span title='" + row.name + "修改密码'><a href='#' onclick='update_password("+ row.uid +")'>修改密码</a></span>";
        return str;
    }

    /*#################formatter#################*/

    function query(){
        $.ajax({
            type : 'get',
            url : "/user/pageQuery",
            success : function(data){

            }
        })
    }

    function show_detail(user_id){
        //iframe窗

        layer.open({
            type: 2,
            title: "用户详情",
            area: ['880px', '650px'],
            content: '/user/detail?uid=' + user_id
        });
    }

    function update_password(user_id){
        layer.open({
            type : 2 ,
            title : "修改密码" ,
            area : ['550px','350px'],
            content : '/user/openUpdate?uid='+user_id,
            btn : ['保存','取消'],
            yes : function (index,layero){
              var iframeWin = window[layero.find('iframe')[0]['name']];
              iframeWin.update_password();
            },
            btnAlign : 'c'
        });
    }
</script>

</body>
</html>