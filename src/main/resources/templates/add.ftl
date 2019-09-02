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
    </style>

</head>

<body>

<#include "./commonPage/topBar.ftl"/>
<h1>
    <stronger>录入电影信息</stronger>
</h1>
<div class="container">
    <form action="uploadVideos" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="col-md-5 col-md-offset-1">
                <div class="form-group">
                    <label for="exampleInputFile">视频文件录入</label>
                    <input type="file" name="vidoe_url" id="exampleInputFile" >
                    <p class="help-block">Example block-level help text here.</p>
                </div>
            </div>
            <div class="col-md-5 col-md-offset-1">
                <div class="form-group">
                    <label for="exampleInputFile">图片录入</label>
                    <input type="file" name="img_url" id="exampleInputFile">
                    <p class="help-block">Example block-level help text here.</p>
                </div>
            </div>

        </div>
        <br>
        <!-- 第一行 -->
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label for="exampleInputEmail1">电影名称</label>
                    <input type="text" name="video_name" class="form-control "
                           placeholder="电影名称" required>
                </div>
            </div>

            <div class="col-md-3">
                <div class="form-group">
                    <label for="exampleInputEmail1">电影评分</label>
                    <input typeBean="text" name="video_score" class="form-control" required
                           placeholder="电影评分">
                </div>
            </div>

            <div class="col-md-3 ">
                <div class="form-group">
                    <label for="exampleInputEmail1">电影播放量</label>
                    <input type="text" name="video_count" class="form-control" required
                           placeholder="电影播放量">
                </div>
            </div>

            <div class="col-md-3 ">
                <div class="form-group">
                    <label for="exampleInputEmail1">演员名称</label>
                    <input type="text" name="actor_name" class="form-control" required
                           placeholder="演员名称">
                </div>
            </div>

        </div>
        <br>
        <!-- 第二行 -->
        <div class="row">
            <div class="col-md-3">
                <div class="form-group">
                    <label for="exampleInputEmail1">导演</label>
                    <input type="text" name="director" class="form-control" required
                           placeholder="导演">
                </div>
            </div>

            <div class="col-md-3">
                <div class="form-group">
                    <label for="exampleInputEmail1">上映时间</label>
                    <input type="datetime" name="video_time" class="form-control" required
                           placeholder="上映时间">
                </div>
            </div>

            <div class="col-md-3 ">
                <div class="form-group">
                    <label for="exampleInputEmail1">电影类型</label>
                    <input type="text" name="type_type" class="form-control" required
                           placeholder="电影类型">

                </div>
            </div>

            <div class="col-md-3 ">
                <div class="form-group">
                    <label for="exampleInputEmail1">地区</label>
                    <input type="text" name="area_name" class="form-control" required
                           placeholder="地区">
                </div>
            </div>

            <div class="col-md-3 ">
                <div class="form-group">
                    <label for="exampleInputEmail1">是否设为vip才能观看</label>
                    <input type="text" name="vipcansee" class="form-control"
                           placeholder="不设置就是谁都能观看">
                </div>
            </div>

        </div>
        <br>
        <!-- 第三行 -->
        <div class="row">
            <div class="form-group">
                <label for="exampleInputEmail1">电影详情</label>
                <textarea class="form-control" name="details" rows="3" placeholder="电影详情"></textarea>
            </div>
        </div>
        <input type="submit" value="提交" class="btn btn-default">
    </form>
</div>


<#include "./commonPage/footer.ftl"/>
</body>



</html>