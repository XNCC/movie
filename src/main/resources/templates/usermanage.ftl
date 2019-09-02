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
    </style>
</head>

<body>

<#include "./commonPage/topBar.ftl"/>


<div class="col-md-6">
    <h1>
        用户信息管理
    </h1>
</div>

<div class="row">
    <div class="col-md-5">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="搜索用户名称" id="username">
            <span class="input-group-btn">
             <button class="btn btn-default" type="button" id="btn">Go!</button>
                </span>
        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
</div><!-- /.row -->

<!-- 头部信息结束 -->
<br>
<!-- 管理信息 -->
<div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>用户id </th>
            <th>用户名称</th>
            <th>vip</th>
            <th>vip注册时间 </th>
            <th>vip到期时间</th>
            <th>操作</th>
        </tr>

        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>傻逼林</td>
            <td>至尊vip</td>
            <td>2001-10-10</td>
            <td>2001-10-10</td>
            <td>
                <input type="button" value="删除" class="btn btn-danger">
                <input type="button" value="修改" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">
            </td>

        </tr>
        </tbody>

    </table>
</div>

<div class="zxf_pagediv"></div>
<script type="text/javascript">
    //页面加载完成后立刻加载第一页数据
    $(document).ready(function () {
        $("tbody").empty();
    });

    $(".zxf_pagediv").createPage({
        pageNum: ${pageNum!5},
        current: 1,
        backfun: function (e) {
            var name=$("#username").val();
            console.log(e);//回调
            $.get("/Oneuser",{name:name,current:e.current,pageSize:10},function(data){
                var jsonDatas = eval("(" + data + ")");
                $("tbody").empty();
                for(var i=0;i<jsonDatas.rows.length;i++){
                    $("tbody").append(" <tr>\n" +
                        "            <td>"+jsonDatas.rows[i].userid+"</td>\n" +
                        "            <td>"+jsonDatas.rows[i].username+"</td>\n" +
                        "            <td>"+jsonDatas.rows[i].vip+"</td>\n" +
                        "            <td>"+jsonDatas.rows[i].starttime+"</td>\n" +
                        "            <td>"+jsonDatas.rows[i].endtime+"</td>\n" +
                        "            <td>\n" +
                        "                <input type='button' value='删除' class='btn btn-danger' onclick='del("+jsonDatas.rows[i].userid+")'>" +
                        "                <input type='button' value='修改' class='btn btn-primary' onclick='updates("+jsonDatas.rows[i].userid +")' >" +
                        "            </td>\n" +
                        "\n" +
                        "        </tr>");
                }
            },"text");
        }


    });

    //翻页


</script>

<!-- 页脚 -->
<#include "./commonPage/footer.ftl"/>



<!-- 修改模态框 -->
<div class="modal fade" id="myModal2" aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改</h4>
            </div>
            <form action="/updUser" method="post">
            <div class="modal-body">
                <input type="text" name="userid" class="hidden"
                       placeholder="用户名" id="userid">

                <div class="col-md-3 ">
                    <div class="form-group">
                        <label for="exampleInputEmail1">用户名</label>
                        <input type="text" id="usernames" name="username" class="form-control"
                               placeholder="用户名" >
                    </div>
                </div>

                <div class="col-md-3 ">
                    <div class="form-group">
                        <label for="exampleInputEmail1">vip等级</label>
                        <input type="text" name="vip" class="form-control"
                               placeholder="vip等级" id="vip">
                    </div>
                </div>

                <div class="col-md-3 ">
                    <div class="form-group">
                        <label for="exampleInputEmail1">vip起始时间</label>
                        <input type="text" name="start" class="form-control"
                               placeholder="vip起始时间" id="starttime">
                    </div>
                </div>

                <div class="col-md-3 ">
                    <div class="form-group">
                        <label for="exampleInputEmail1">vip截止时间</label>
                        <input type="text" name="end" class="form-control"
                               placeholder="vip截止时间" id="endtime">
                    </div>
                </div>

                <div class="col-md-3 ">
                    <div class="form-group">
                        <label for="exampleInputEmail1">手机号</label>
                        <input type="text" name="phone" class="form-control"
                               placeholder="手机号" id="phone">
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    //删除使用
    function del(userid){
        console.log("1231");
        $.get("/userdel",{userid:userid},function(data){
            if(data!=null){
                window.location.reload()
            }
        },"text");
    };

//    执行点击事件后
    $("#btn").click(function(){
        var name=$("#username").val();
        $.get("/Oneuser",{name:name,current:0,pageSize:10},function(data){
            var jsonDatas = eval("(" + data + ")");
            $("tbody").empty();
            for(var i=0;i<jsonDatas.rows.length;i++){
                $("tbody").append(" <tr>\n" +
                    "            <td>"+jsonDatas.rows[i].userid+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].username+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].vip+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].starttime+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].endtime+"</td>\n" +
                    "            <td>\n" +
                    "                <input type='button' value='删除' class='btn btn-danger' onclick='del("+jsonDatas.rows[i].userid+")'>" +
                    "                <input type='button' value='修改' class='btn btn-primary'  onclick='updates("+jsonDatas.rows[i].userid +")'>" +
                    "            </td>\n" +
                    "\n" +
                    "        </tr>");
            }
        },"text");



    });


    function updates(e){
        console.log(e);
        $.get("/getOneUser",{userid:e},function(data){
            console.log(data);
            $("#userid").val(e);
            $("#usernames").val(data.username);
            $('#vip').val(data.vip);
            $("#starttime").val(data.start);
            $("#endtime").val(data.end);
            $("#phone").val(data.phone);

            $("#myModal2").modal('show');
        },"json");

    }
</script>

</html>