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
    <title>Banner展示</title>
    <#include "../include/head.ftl">
</head>
<body>

<img id="span" src="" />

<form id="search-from" class="form-inline">
    <div class="row">
        <div class="form-group col-md-3">
            <label for="pictureName">图片名称</label>
            <input type="text" id="pictureName" name="name" class="form-control" placeholder="图片名称">
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
           data-url="/banner/pageQuery"
           data-striped="true"
           data-cache="false"
           data-data-type="json"
           data-pagination="true"
           data-side-pagination="server"
           data-page-number="1"
           data-page-size="5"
           data-page-list="[]"
           data-search="false"
           data-card-view="false"
           data-show-toggle="true"
           data-query-params="queryParam"
           id="dataTable">
        <thead>

        <tr>
            <th data-width="8%" data-class="text-center align-center banner_id" data-field="id">#</th>
            <th data-width="12%" data-class="text-center" data-field="name">图片名称</th>
            <th data-width="15%" data-class="text-center" data-field="picture" data-formatter="pickture_formatter">缩略图</th>
            <th data-width="20%" data-class="text-center" data-field="sort">排序</th>
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

    function show_detail(id){
        //iframe窗

        layer.open({
            type: 2,
            title: "Banner详情",
            area: ['1188px', '650px'],
            content: '/banner/detail?id=' + id
        });
    }


    function open_add(){
        layer.open({
            type : 2,
            title : "新增Banner",
            area: ['880px', '650px'],
            content : '/banner/openAdd',
            btn : ['保存','取消'],
            yes : function (index,layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                iframeWin.save();
            },
            btnAlign : 'c'
        });
    }

    function update_banner(id){
        layer.open({
            type : 2,
            title : "编辑Banner",
            area: ['880px', '650px'],
            content : '/banner/openUpdate?id='+id,
            btn : ['保存','取消'],
            yes : function (index,layero){
                var iframeWin = window[layero.find('iframe')[0]['name']];
                iframeWin.update();
            },
            btnAlign : 'c'
        });
    }

    function delete_banner(id){
        layer.confirm("您确定要删除吗？",{title : "提示",skin : 'pop-box'},function(){
            $.ajax({
                type : 'post',
                url : '/banner/delete',
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

    function getBannerId(){
        var ids = '';
        $('.banner_id').each(function(){
            ids += ($(this).text() + ",");
        })
        return ids.substring(0,ids.length - 1);
    }

    function query(){
        $("#dataTable").bootstrapTable('refresh',{url:'/banner/pageQuery'});
    }

    function queryParam(params){
        var state = "";
        state = $('.J_tab.active').attr('data-state');
        params = {
            name : $('#name').val(),
            state : state,
            order : params.order,
            offset : params.offset,
            limit : params.limit
        }

        return params;
    }

    // data:,文本数据
    // data:text/plain,文本数据
    // data:text/html,HTML代码
    // data:text/html;base64,base64编码的HTML代码
    // data:text/css,CSS代码
    // data:text/css;base64,base64编码的CSS代码
    // data:text/JavaScript,Javascript代码
    // data:text/javascript;base64,base64编码的Javascript代码
    // data:image/gif;base64,base64编码的gif图片数据
    // data:image/png;base64,base64编码的png图片数据
    // data:image/jpeg;base64,base64编码的jpeg图片数据
    // data:image/x-icon;base64,base64编码的icon图片数据

    function pickture_formatter(index,row,value){
        var str = "";
        if(row != '' && row != null){
            str += "<img width='150px' onclick='show_detail("+row.id+")' height='80px' src='data:image/jpeg;base64," + row.picture + "'>";
        }else{
            str += "<img width='150px' height='80px' src='/static/media/images/9.png'>"
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
        str += "<a href='#' onclick='show_detail("+ row.id +")'>详情</a>&emsp;";
        str += "<a href='#' onclick='update_banner("+ row.id +")'>编辑</a>&emsp;";
        str += "<a href='#' onclick='delete_banner("+ row.id +")'>删除</a>";
        return str;
    }


</script>

</body>
</html>