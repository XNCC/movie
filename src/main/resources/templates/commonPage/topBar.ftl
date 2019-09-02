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
    <link rel="stylesheet" type="text/css" href="css/zxf_page.css" />
    <script type="text/javascript" src="js/zxf_page.js"></script>
    <style>
        body {
            margin: 5%;
        }

        .container {
            margin-top: 5%;
        }
        imgstyle{
            border-radius: 10px;
            width: 40px;
            height:40px;
        }
    </style>
</head>

<body>

<div class="page-header">
    <h1>小电影网 <small>小电影录入系统</small></h1>
</div>
<ul class="nav nav-pills" id="uls">
    <li role="presentation" ><a href="/slideshow">轮播图修改</a></li>
    <li role="presentation" ><a href="/add">电影信息录入</a></li>
    <li role="presentation"><a href="/manage">电影管理</a></li>
    <li role="presentation"><a href="/usermanage">用户管理</a></li>
    <li role="presentation"><a href="/earning">盈利中心</a></li>
    <li role="presentation"><a href="/email">用户反馈查看</a></li>
    <li role="presentation"><a href="/persionPage">${admin!}</a></li>
<#--    <#if img_url??>-->
<#--    <li role="presentation"><img class="imgstyle" src="${img_url}"/></li>-->
<#--    </#if>-->
</ul>
<hr/>
<!-- 头部信息结束 -->
</body>
<!-- 用于导航栏页面切换 -->
<script>
    $(document).ready(function () {
        $("#uls li").click(function () {
            $("#uls > li").removeClass("active");
            $(this).addClass("active");
            console.log(this);
        });
    });
</script>

</html>