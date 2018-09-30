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
        td{vertical-align: middle !important;}
        #search-from{
            margin-top: 1%;
            margin-bottom: 2%;
        }
        html{
            padding: 1%;
        }
    </style>
    <meta charset="UTF-8">
    <title>首页</title>
    <#include "../include/head.ftl">
</head>
<body>

<form id="search-from" class="form-inline">
    <div class="row">
        <div class="form-group col-md-3">
            <label for="pictureName">图片名称</label>
            <input type="text" id="pictureName" name="pictureName" class="form-control" placeholder="图片名称">
        </div>

        <div class="form-group col-md-3">
            <label for="author">作者</label>
            <input type="text" class="form-control" id="author" name="author" placeholder="作者名称">
        </div>

        <div class="form-group col-md-3">
            <button type="button" class="btn btn-primary query-btn" onclick="query()">查询</button>
        </div>


    </div>

</form>

<hr>

<div id="wl-cont">
    <button type="button" class="btn btn-primary add_btn" onclick="open_add()">新增</button>
    <ul class="nav nav-tabs status-tabs">
        <li class="J_tab active" data-state=""><a href="#" data-toggle="tab">全部</a></li>
        <li class="J_tab" data-state="0"><a href="#" data-toggle="tab">展示中</a></li>
        <li class="J_tab" data-state="1"><a href="#" data-toggle="tab">未展示</a></li>
    </ul>

    <table class="table table-striped"
           data-toggle="table"
           data-url="/picture/pageQuery"
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
           data-show-toggle="true"
           data-query-params="queryParam"
           id="dataTable">
        <thead>

        <tr>
            <th data-width="8%" data-class="text-center align-center" data-field="id">#</th>
            <th data-width="12%" data-class="text-center" data-field="pictureName">图片名称</th>
            <th data-width="15%" data-class="text-center" data-field="imgUrlAll" data-formatter="img_url_formatter">缩略图</th>
            <th data-width="20%" data-class="text-center" data-field="remark" data-formatter="remark_formatter">图片描述</th>
            <th data-width="5%" data-class="text-center" data-field="state" data-formatter="state_formatter">图片状态</th>
            <th data-width="20%" data-class="text-center" data-field="updateTimeStr" data-formatter="update_time_formatter">更新时间</th>
            <th data-width="20%" data-class="text-center" data-formatter="opration_formatter">操作</th>
        </tr>
        </thead>
    </table>
</div>

<script>
    $(function() {
        $('#dataTable').bootstrapTable();

        $('.J_tab').on('click',function(){
            $(this).addClass("active").siblings().removeClass("active");
            query();
        });
    });

    function query(){
        $("#dataTable").bootstrapTable('refresh',{url:'/picture/pageQuery'});
    }

    function queryParam(params){
        var state = "";
        state = $('.J_tab.active').attr('data-state');
        params = {
            pictureName : $('#pictureName').val(),
            author : $("#author").val(),
            state : state,
            order : params.order,
            offset : params.offset,
            limit : params.limit
        }

        return params;
    }

    function img_url_formatter(index,row,value){
        var str = "";
        if(row.imgUrlAll != '' && row.imgUrlAll != null){
            str += "<img width='150px' onclick='show_detail("+row.id+")' height='80px' src='" + row.imgUrlAll + "'>";
        }else{
            str += "<img width='150px' height='80px' src='/static/media/images/9.png'>"
        }
        return str;
    }

    function remark_formatter(index,row,value){
        var str = "";
        if(row.remark){
                if(row.remark.length > 20){
                    str += "<span title="+row.remark+">" + row.remark.substring(0,20) + "...</span>";
                }else{
                    str += "<span title="+row.remark+">" + row.remark + "</span>";
                }

        }else{
            str += "-";
        }

        return str;

    }

    function state_formatter(index,row,value){
        var str = "";
        if(row.state == 0){
            str += "<span title='展示中'>展示中</span>";
        }
        if(row.state == 1){
            str += "<span title='未展示'>未展示</span>";
        }
        return str;
    }

    function update_time_formatter(index,row,value){
        var str = "";
        if(row.updateTimeStr != null && row.updateTimeStr != ''){
            str += "<span title='" + row.updateTimeStr + "'>"+ row.updateTimeStr +"</span>";
        }else{
            str += "<span title='-'> - </span>";
        }

        return str;
    }

    function opration_formatter(index,row,value){
        var str = "";
        str += "<a href='#' onclick='show_detail("+ row.id +")'>详情</a>"
        return str;
    }

    function show_detail(id){
        //iframe窗

        layer.open({
            type: 2,
            title: "图片详情",
            area: ['1188px', '750px'],
            content: '/picture/detail?id=' + id
        });
    }


    function open_add(){
        layer.open({
            type : 2,
            title : "新增图文",
            area: ['880px', '650px'],
            content : '/picture/openAdd',
            btn : ['保存','取消'],
            yes : function (index,layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                iframeWin.save();
            },
            btnAlign : 'c'
        });
    }
</script>

</body>
</html>