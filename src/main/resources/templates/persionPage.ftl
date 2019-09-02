<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="/static/layer/layer.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .personmageger_all {
            margin-top: 3%;
            margin-left: 6%;
            margin-right: 6%;

            margin-bottom: 3%;
        }

        body {
            background-color: #ECF5FF;
        }

        .titleTmg {
            border: rgb(16, 17, 17) solid 1;
            margin: 1px;
        }

        .img_center {
            text-align: center;
        }

        .aFloat {
            float: right;
        }
        .displaynono{
            display: none;
        }

    </style>
</head>

<body>


<#include "./commonPage/topBar.ftl"/>
<div class="personmageger_all">
    <div class="container">
        <div class="row">
            <!--第一行分为上下两列  -->
            <div class="col-md-8">
                <div class="row">
                    <div class="col-md-12">
                        <h1>管理员个人资料</h1>
                    </div>
                </div>
                <hr/>
                <!--再分为左右两个界面
                            左：头像
                            右：个人信息-->
                <div class="row">
                    <div class="col-md-12">

                        <div class="row">
                            <div class="col-md-3 img_center">
                                <img class="titleTmg img-thumbnail img-circle " src="${img_url!}"/>
                            </div>

                            <div class="col-md-8 setRightBorder">
                                <div class="row">
                                    <div class="col-md-12">
                                        ID:${admin!}
                                        <a href="#" class="aFloat">主页面</a>
                                    </div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-md-12">
                                        <p> 昵称：${admin!}</p>
                                        <p> 用户id：${userid!''}</p>
                                        <p> vip：${vip!}</p>
                                        <#if starttime??>
                                        <p> 起始时间：${starttime?string('yyyy-MM-dd')}</p>
                                        </#if>
                                        <#if endtime??>
                                        <p> 截止时间：${endtime?string('yyyy-MM-dd')}</p>
                                        </#if>
                                        <p> 电话：${phone!}</p>
                                        <p> 简介：小电影后台管理员，服务每一位小电影用户</p>
                                        <p><a href="#">编辑个人信息</a></p>
                                    </div>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>


            </div>

        </div>
    </div>
</div>

<#include "./commonPage/footer.ftl"/>
</body>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous">
</script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</html>