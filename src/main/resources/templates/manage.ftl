<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

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
        电影信息管理
    </h1>
</div>

<div class="row">
    <div class="col-md-5">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="搜索电影名称" id="nametext">
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
            <th>电影id </th>
            <th>电影名称</th>
            <th>演员名称</th>
            <th>导演 </th>
            <th>上映时间</th>
            <th>详情</th>
            <th>操作</th>
        </tr>

        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>不能说的秘密</td>
            <td>周杰伦</td>
            <td>周杰伦</td>
            <td>2001-10-10</td>
            <td>
                <input type="button" value="详情" class="btn btn-success" data-toggle="modal" data-target="#myModal1">
            </td>
            <td>
                <input type="button" value="删除" class="btn btn-danger">
                <input type="button" value="修改" class="btn btn-primary" data-toggle="modal" data-target="#myModal2">
            </td>

        </tr>
        </tbody>

    </table>
</div>

<#--模态框-->
<!-- Modal -->
<div class="modal fade" id="myModal" aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">修改</h4>
            </div>
            <form action="/updateVideo" method="post">
            <div class="modal-body">

                <!-- 第一行 -->

                <input id="video_id" type="text" name="video_id" class="hidden">
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="exampleInputEmail1">电影名称</label>
                            <input id="video_name" type="text" name="video_name" class="form-control"
                                   >
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="exampleInputEmail1">电影评分</label>
                            <input type="text" name="video_score" class="form-control"
                                   placeholder="电影评分" id="video_score">
                        </div>
                    </div>

                    <div class="col-md-3 ">
                        <div class="form-group">
                            <label for="exampleInputEmail1">电影播放量</label>
                            <input type="text" name="video_count" class="form-control"
                                   placeholder="电影播放量" id="video_count">
                        </div>
                    </div>

                    <div class="col-md-3 ">
                        <div class="form-group">
                            <label for="exampleInputEmail1">演员名称</label>
                            <input type="text" name="actor_name" class="form-control"
                                   placeholder="演员名称" id="actor_name">
                        </div>
                    </div>


                <!-- 第二行 -->
                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="exampleInputEmail1">导演</label>
                            <input type="text" name="directors" class="form-control"
                                   placeholder="导演" id="directors">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-group">
                            <label for="exampleInputEmail1">上映时间</label>
                            <input type="datetime" name="video_time" class="form-control"
                                   placeholder="上映时间" id="time">
                        </div>
                    </div>
                </div>
                    <div class="col-md-3 ">
                        <div class="form-group">
                            <label for="exampleInputEmail1">电影类型</label>
                            <input type="text" name="type_type" class="form-control"
                                   placeholder="电影类型" id="type_type">

                        </div>
                    </div>

                    <div class="col-md-3 ">
                        <div class="form-group">
                            <label for="exampleInputEmail1">地区</label>
                            <input type="text" name="area_name" class="form-control"
                                   placeholder="地区" id="area_name">
                        </div>
                    </div>


                <!-- 第三行 -->
                <div class="row">
                    <div class="col-md-3 col-md-offset-1">
                    <div class="form-group">
                        <label for="exampleInputEmail1">电影详情</label>
                        <textarea class="form-control" name="video_details" id="video_details" rows="3"   placeholder="电影详情" style="width:500px;"></textarea>
                    </div>
                    </div>
                </div>


            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" id="cli" class="btn btn-primary" >保存</button>
            </div>
            </form>
        </div>
    </div>
</div>
<!-- 分页栏 -->
<!--翻页-->
<div class="zxf_pagediv"></div>
<script type="text/javascript">
    $("#btn").click(function(){
       // console.log($("#nametext").val());
        var video_name=$("#nametext").val();
        $.get("/select",{video_name:video_name},function(data){
            var jsonDatas = eval("(" + data + ")");
            $("tbody").empty();
            for(var i=0;i<jsonDatas.rows.length;i++){
                $("tbody").append(" <tr>\n" +
                    "            <td >"+jsonDatas.rows[i].video_id+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].video_name+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].actor_name+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].directors+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].video_time+"</td>\n" +
                    "            <td>\n" +
                    "                <a href='/User_comments/"+jsonDatas.rows[i].video_id+"' value='详情' class='btn btn-success'>评论详情</a>" +
                    "            </td>\n" +
                    "            <td>\n" +
                    "                <input type='button' value='删除' class='btn btn-danger' onclick='del("+jsonDatas.rows[i].video_id+")'>" +
                    "                <input type='button' value='修改' class='btn btn-primary'   data-orderId='"+jsonDatas.rows[i].video_id+"' onclick='updates("+jsonDatas.rows[i].video_id +")' >" +
                    "            </td>\n" +
                    "\n" +
                    "        </tr>");
            }
        //    data-toggle='modal' data-target='#myModal'
        },"text");

    });
    //页面加载完成后立刻加载第一页数据
    $(document).ready(function () {

        $.get("/pagelist",{current:"1",pageSize:"10"},function(data){
            var jsonDatas = eval("(" + data + ")");
            $("tbody").empty();
            for(var i=0;i<jsonDatas.rows.length;i++){
                $("tbody").append(" <tr>\n" +
                    "            <td >"+jsonDatas.rows[i].video_id+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].video_name+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].actor_name+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].directors+"</td>\n" +
                    "            <td>"+jsonDatas.rows[i].video_time+"</td>\n" +
                    "            <td>\n" +
                    "                <a href='/User_comments/"+jsonDatas.rows[i].video_id+"' value='详情' class='btn btn-success'>评论详情</a>" +
                    "            </td>\n" +
                    "            <td>\n" +
                    "                <input type='button' value='删除' class='btn btn-danger' onclick='del("+jsonDatas.rows[i].video_id+")'>" +
                    "                <input type='button' value='修改' class='btn btn-primary' data-orderId='"+jsonDatas.rows[i].video_id+"' onclick='updates("+jsonDatas.rows[i].video_id +")'>" +
                    "            </td>\n" +
                    "\n" +
                    "        </tr>");
            }
        },"text");

    });



    //翻页
    $(".zxf_pagediv").createPage({
        pageNum: ${pageSize!1},
        current: 1,
        backfun: function (e) {
            console.log(e);//回调
            $.get("/pagelist",{current:e.current,pageSize:"10"},function(data){
                var jsonDatas = eval("(" + data + ")");
                $("tbody").empty();
                for(var i=0;i<jsonDatas.rows.length;i++){
                    $("tbody").append(" <tr>\n" +
                        "            <td>"+jsonDatas.rows[i].video_id+"</td>\n" +
                        "            <td>"+jsonDatas.rows[i].video_name+"</td>\n" +
                        "            <td>"+jsonDatas.rows[i].actor_name+"</td>\n" +
                        "            <td>"+jsonDatas.rows[i].directors+"</td>\n" +
                        "            <td>"+jsonDatas.rows[i].video_time+"</td>\n" +
                        "            <td>\n" +
                        "                <a href='/User_comments/"+jsonDatas.rows[i].video_id+"' value='详情' class='btn btn-success'>评论详情</a>" +
                        "            </td>\n" +
                        "            <td>\n" +
                        "                <input type='button' value='删除' class='btn btn-danger' onclick='del("+jsonDatas.rows[i].video_id+")'>" +
                        "                <input type='button' value='修改' class='btn btn-primary' data-orderId='"+jsonDatas.rows[i].video_id+"' onclick='updates("+jsonDatas.rows[i].video_id +")'>" +
                        "            </td>\n" +
                        "\n" +
                        "        </tr>");
                }
            },"text");
        }


    });

    //   模态框事件触发
        function updates(e){
            console.log(e);
                $.get("/getOneVideo",{video_id:e},function(data){
                    console.log(data);
                    $("#video_id").val(e)
                    $('#video_name').val(data.video_name);
                    $("#video_score").val(data.video_score);
                    $("#video_count").val(data.video_count);
                    $("#actor_name").val(data.actor_name);
                    $("#directors").val(data.directors);
                    $("#time").val(data.time);
                    $("#type_type").val(data.type_type);
                    $("#area_name").val(data.area_name);
                    $("#video_details").val(data.video_details);
                    $("#myModal").modal('show');
                },"json");

        }
</script>

<!-- 页脚 -->
<#include "./commonPage/footer.ftl"/>

<script>
    //删除使用
   function del(video_id){
       console.log("1231");
    $.get("/del",{video_id:video_id},function(data){
        console.log("1231ff");
        if(data!=null){
            window.location.reload()
        }

    },"text");
   }

</script>
</body>
</html>