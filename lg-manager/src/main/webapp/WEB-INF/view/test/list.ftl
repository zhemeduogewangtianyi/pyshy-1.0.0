<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <style>
        .carousel-inner img {
            width:100%;
        }
        .add_btn{
            margin-left: 95%;
        }
        #search-from{
            margin-top: 1%;
            margin-bottom: 2%;
        }
        html{
            padding: 1%;
        }
    </style>
    <meta charset="UTF-8">
    <title>Test</title>
    <#include "../include/head.ftl">
</head>
<body>
<form id="search-from" class="form-inline">
    <div class="row">
        <div class="form-group col-md-3">
            <label for="category">分类名称</label>
            <input type="text" id="category" name="category" class="form-control" placeholder="分类名称">
        </div>

        <div class="form-group col-md-3">
            <button type="button" class="btn btn-primary query-btn" onclick="query()">查询</button>
        </div>


    </div>

</form>

<div id="wl-cont">
    <ul class="nav nav-tabs status-tabs">
        <li class="J_tab active" data-state=""><a href="#" data-toggle="tab">全部</a></li>
        <li class="J_tab" data-state="0"><a href="#" data-toggle="tab">启用</a></li>
        <li class="J_tab" data-state="1"><a href="#" data-toggle="tab">停用</a></li>
    </ul>

        <button type="button" class="btn btn-primary add_btn" onclick="addCategory()">新增</button>

    <table class="table table-striped"
           data-toggle="table"
           data-url="/test/pageQuery"
           data-striped="true"
           data-cache="false"
           data-data-type="json"
           data-pagination="true"
           data-side-pagination="server"
           data-page-number="1"
           data-page-size="10"
           data-page-list="[]"
           data-search="false"
           data-query-params="queryParams"
           data-card-view="false"
           id="dataTable">
        <thead>
        <tr>
            <th data-width="15%" data-class="text-center" data-field="id" data-formatter="id_formatter">#</th>
            <th data-width="25%" data-class="text-center" data-field="category" data-formatter="category_formatter">分类名称</th>
            <th data-width="15%" data-class="text-center" data-formatter="state_formatter">分类状态</th>
            <th data-width="25%" data-class="text-center" data-field="updateTime" data-formatter="update_time_formatter">更新时间</th>
            <th data-width="20%" data-class="text-center" data-formatter="opration_formatter">操作</th>
        </tr>
        </thead>
    </table>
</div>

<script>
    $(function() {
        $('#dataTable').bootstrapTable();

        $('.J_tab').on('click',function(){
            $(this).addClass('active').siblings().removeClass('active');
            query();
        });
    });

    function query(){
        $('#dataTable').bootstrapTable('refresh',{url:'/test/pageQuery'});
    }

    function queryParams(params){
        if(!params){
            params = {}
        }
        var state = $('.J_tab.active').attr('data-state');
        params = {
            category : $('#category').val(),
            state : state
        }
        return params;
    }

    /*#################formatter#################*/

    function id_formatter(index,row,value){
        var str = "";
        str += "<span title='" + row.id + "'>"+ row.id +"</span>";
        return str;
    }

    function category_formatter(index,row,value){
        var str = "";
        str += "<span title='" + row.category + "'>"+ row.category +"</span>";
        return str;
    }

    function update_time_formatter(index,row,value){
        var str = "";
        if(row.updateStr != null && row.updateStr != ''){
            str += "<span title='" + row.updateStr + "'>"+ row.updateStr +"</span>";
        }else{
            str += "<span title='-'> - </span>";
        }

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
        str += "<span title='" + row.category + "详情'><a href='#' onclick='show_detail("+ row.id +")'>详情</a></span>&nbsp&nbsp";
        str += "<span title='" + row.category + "修改'><a href='#' onclick='update_category("+ row.id +")'>修改</a></span>&nbsp&nbsp";
        str += "<span title='" + row.category + "删除'><a href='#' onclick='deleteAll("+ row.id +")'>删除</a></span>&nbsp&nbsp";
        if(row.state == 0){
            str += "<span title='" + row.category + "启用'><a href='#' >启用</a></span>&nbsp&nbsp";
        }else{
            str += "<span title='" + row.category + "停用'><a href='#' >停用</a></span>&nbsp&nbsp";
        }
        return str;
    }

    /*#################formatter#################*/

    function addCategory(){
        layer.open({
            type : 2,
            title : "新增",
            area: ['880px', '650px'],
            content : '/test/openAdd',
            btn : ['保存','取消'],
            yes : function (index,layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                iframeWin.save();
            },
            btnAlign : 'c'
        });
    }

    function show_detail(id){
        //iframe窗

        layer.open({
            type: 2,
            title: "用户详情",
            area: ['880px', '650px'],
            content: '/test/detail?id=' + id
        });
    }

    function update_category(id){
        layer.open({
            type : 2 ,
            title : "修改分类" ,
            area : ['880px', '650px'],
            content : '/test/openUpdate?id='+id,
            btn : ['保存','取消'],
            yes : function (index,layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                iframeWin.update();
            },
            btnAlign : 'c'
        });
    }

    function deleteAll(id){
        layer.confirm("您确定要删除吗？",{title : "提示",skin : 'pop-box'},function(){
            $.ajax({
                type : 'post',
                url : '/test/delete',
                data : {"id":id},
                success : function(data){
                    if(data.code == 200){
                        layer.closeAll();
                        layer.msg(data.message,{time:1000},function(e){
                            window.location.reload();
                        });

                    }else{
                        layer.msg(data.message);
                    }
                }
            })
        })
    }
</script>

</body>
</html>