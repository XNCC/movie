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
        img {
            width: 40px;
            height: 40px;
        }
        .p_style{
            line-height: 25px;
            color: #2B2B2B;
        }
        .a_style{
            line-height: 14px;
        }
    </style>
</head>

<body>

<#include "./commonPage/topBar.ftl"/>

<div class="col-md-6">
    <h1>
        电影的所有评论
    </h1>
</div>

<br>
<br>
<hr>
<!-- 管理信息 -->
<#-- 用div做模块-->
<#if lists??>
<#list lists as item>
<div>
    <div class="row">
        <div class="col-md-1 ">
            <img src=' ${item.userimg_url!'http://img.daimg.com/uploads/allimg/190827/3-1ZRG412010-L.jpg'} '                 alt="">
        </div>
        <div class="col-md-9 ">
            <a class="a_style">${item.username!'秋风落叶'}:</a><p>${item.date?string('yyyy-MM-dd')}</p>
            <p class="p_style">
                ${item.username!}
                ${item.comment!}
            </p>
        </div>
        <div class="col-md-2" >
            <button class="btn btn-danger" onclick="del(${item.user_id!})">删除</button>
        </div>
    </div>
    <hr>
</div>
</#list>
</#if>
<#--模块二-->
<!-- 分页栏 -->
<!--翻页-->
<div class="zxf_pagediv"></div>
<script type="text/javascript">
    function del(e){
        $.get("/delcomments",{user_id:e},function(data){

                    },"text");
    }

    //翻页
    // $(".zxf_pagediv").createPage({
    //     pageNum: 10,
    //     current: 1,
    //     backfun: function (e) {
    //         console.log(e);//回调
    //         $.get("/pagelist",{current:e.current,pageSize:"10"},function(data){
    //             var jsonDatas = eval("(" + data + ")");
    //             $("tbody").empty();
    //             for(var i=0;i<jsonDatas.rows.length;i++){
    //                 $("tbody").append(" <tr>\n" +
    //                     "            <td>"+jsonDatas.rows[i].video_id+"</td>\n" +
    //                     "            <td>"+jsonDatas.rows[i].video_name+"</td>\n" +
    //                     "            <td>"+jsonDatas.rows[i].actor_name+"</td>\n" +
    //                     "            <td>"+jsonDatas.rows[i].director+"</td>\n" +
    //                     "            <td>"+jsonDatas.rows[i].video_time+"</td>\n" +
    //                     "            <td>\n" +
    //                     "                <input type='button' value='详情' class='btn btn-success' data-toggle='modal' data-target='#myModal1'>" +
    //                     "            </td>\n" +
    //                     "            <td>\n" +
    //                     "                <input type='button' value='删除' class='btn btn-danger' onclick='delete("+jsonDatas.rows[i].video_id+"')>" +
    //                     "                <input type='button' value='修改' class='btn btn-primary' data-toggle='modal' data-target='#myModal2' >" +
    //                     "            </td>\n" +
    //                     "\n" +
    //                     "        </tr>");
    //             }
    //         },"text");
    //     }
    //
    //
    // });

</script>

<!-- 页脚 -->
<#include "./commonPage/footer.ftl"/>

</body>
</html>