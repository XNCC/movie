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
        .top {
            margin: 5%;
        }
        .preview{
            text-align: center;
            margin: 2%;
        }
    </style>
</head>

<body>
<div class="top">
    <#include "./commonPage/topBar.ftl"/>
    <hr/>
    <div>
        <h1>
            查看用户反馈
        </h1>
    </div>
    <hr>
    <#if list??>
    <h4>邮件总数${total!}</h4>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>用户： </th>
            <th>发送简介</th>
            <th>邮件大小</th>
            <th>发送时间</th>
            <th>详情查看</th>
        </tr>

        </thead>
        <tbody>

        <#list list as item>
        <tr>
            <td>${item.from!}</td>
            <td>${item.title!}</td>
            <td>${item.size!}</td>
            <td>${item.sendtime?string('yyyy-MM-dd')}</td>
            <td>
                <a href="/email/${item.id!}" class="btn btn-success" >详情</a>
            </td>
            </#list>
        </tr>
        </tbody>
    </table>
    </#if>
    <#if bean??>
        <h1>邮件内容为</h1>
        <hr/>
       <#list bean as item>
           ${item.content!}
       </#list>

    </#if>
    <!-- 分页栏 -->
    <!--翻页-->
    <div class="zxf_pagediv"></div>
    <script type="text/javascript">
        //翻页
        <#--$(".zxf_pagediv").createPage({-->
        <#--    pageNum: ${pageNum!},-->
        <#--    current: 1,-->
        <#--    backfun: function (e) {-->
        <#--        $.get("/emailList",{current:e.current,pageSize:"10"},function(data){-->
        <#--            var jsonDatas = eval("(" + data + ")");-->
        <#--            $("tbody").empty();-->
        <#--            for(var i=0;i<jsonDatas.rows.length;i++){-->
        <#--                $("tbody").append(" <tr>\n" +-->
        <#--                    "            <td>"+jsonDatas.rows[i].from+"</td>\n" +-->
        <#--                    "            <td>"+jsonDatas.rows[i].title+"</td>\n" +-->
        <#--                    "            <td>"+jsonDatas.rows[i].size+"</td>\n" +-->
        <#--                    "            <td>"+jsonDatas.rows[i].sendtime+"</td>\n" +-->
        <#--                    "            <td>\n" +-->
        <#--                    "                <a href='/User_comments/"+jsonDatas.rows[i].video_id+"' value='详情' class='btn btn-success'>评论详情</a>" +-->
        <#--                    "            </td>\n" +-->
        <#--                    "\n" +-->
        <#--                    "        </tr>");-->
        <#--            }-->
        <#--        },"text");-->

        <#--    }-->
        <#--});-->
        <#--$(document).ready(function () {-->

        <#--    $.get("/emailList",{current:1,pageSize:"10"},function(data){-->
        <#--        var jsonDatas = eval("(" + data + ")");-->
        <#--        $("tbody").empty();-->
        <#--        for(var i=0;i<jsonDatas.rows.length;i++){-->
        <#--            $("tbody").append(" <tr>\n" +-->
        <#--                "            <td>"+jsonDatas.rows[i].from+"</td>\n" +-->
        <#--                "            <td>"+jsonDatas.rows[i].title+"</td>\n" +-->
        <#--                "            <td>"+jsonDatas.rows[i].size+"</td>\n" +-->
        <#--                "            <td>"+jsonDatas.rows[i].sendtime+"</td>\n" +-->
        <#--                "            <td>\n" +-->
        <#--                "                <a href='/User_comments/"+jsonDatas.rows[i].video_id+"' value='详情' class='btn btn-success'>评论详情</a>" +-->
        <#--                "            </td>\n" +-->
        <#--                "\n" +-->
        <#--                "        </tr>");-->
        <#--        }-->
        <#--    },"text");-->

        <#--})-->


    </script>




</div>







</body>

</html>