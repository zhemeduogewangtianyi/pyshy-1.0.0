<!DOCTYPE html>
<html lang="zh-CN" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <style>
        .carousel-inner img {
            width:100%;
        }
    </style>
    <meta charset="UTF-8">
    <title>首页</title>
    <#include "../include/head.ftl">
</head>
<body>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1200px;height:800px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['${(picture)!}','${(user)!}','${(test)!}']
        },
        series: [
            {
                name:'总数统计',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:${(pictureCount)!}, name:'${(picture)!}'},
                    {value:${(userCount)!}, name:'${(user)!}'},
                    {value:${(testCount)!}, name:'${(test)!}'}
                ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表 -》 总览。
    myChart.setOption(option);
</script>

</body>
</html>