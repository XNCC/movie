<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
    </script>

    <style>
        body {
            margin: 5%;
        }

        .container {
            margin-top: 5%;
        }

        .col-md-3 {
            height: 30%;
            padding: 20px;
            background-color: azure;
        }
    </style>
</head>

<body>
<#include "./commonPage/topBar.ftl"/>
<div>
    <h1>
        小电影收益
    </h1>
</div>
</div>
<div class="row">
    <div class="col-md-3">
        <div class="row">
            <div class="col-md-6">
                收益：￥${earning!}
            </div>
            <div class="col-md-6">
                <i class="layui-icon layui-icon-cellphone">￥</i>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-md-offset-1">
        <div class="row">
            <div class="col-md-6">
                用户总数：${count!}
            </div>
            <div class="col-md-6">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-md-offset-1">
        <div class="row">
            <div class="col-md-6">
                总电影数：${looked!}
            </div>
            <div class="col-md-6">
                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
            </div>
        </div>
    </div>
</div>
<hr>

<div id="main" style="height:400px"></div>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<script type="text/javascript">
    // 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    // 使用
    require(
        [
            'echarts',
            'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
        ],

        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('main'));

            option = {
                title: {
                    text: '小电影收益情况',
                    subtext: '啦啦啦'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['收益']
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {
                            show: true
                        },
                        dataView: {
                            show: true,
                            readOnly: false
                        },
                        magicType: {
                            show: true,
                            type: ['line', 'bar', 'stack', 'tiled']
                        },
                        restore: {
                            show: true
                        },
                        saveAsImage: {
                            show: true
                        }
                    }
                },
                calculable: true,
                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    data: ['一月', '二月', '三月', '四月', '五月', '六月', '七月','八月']
                }],
                yAxis: [{
                    type: 'value'
                }],
                series: [
                    {
                        name: '收益',
                        type: 'line',
                        smooth: true,
                        itemStyle: {
                            normal: {
                                areaStyle: {
                                    type: 'default'
                                }
                            }
                        },
                        data: [${y1!}, ${y2!}, ${y3!}, ${y4!},
                            ${y5!},${y6!}, ${y7!},${y8!}]
                    },

                ]
            };



            // 为echarts对象加载数据
            myChart.setOption(option);
        }
    );
</script>

<!-- 页脚 -->
<#include "./commonPage/footer.ftl"/>
<script>

</script>
</body>

</html>