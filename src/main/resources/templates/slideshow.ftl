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
    <link rel="stylesheet" href="./layui/css/layui.css">
    <script src="./layui/layui.all.js"></script>

    <style>
        .top {
            margin: 5%;
        }
        .preview{
            text-align: center;
           width:1290px;
            height:400;

        }
        body{
            margin:0;
            padding:0;
        }
        /*#test1{*/
        /*    float: left;*/
        /*    right:50px;*/
        /*}*/
    </style>
</head>

<body>

<div class="top">
    <#include "./commonPage/topBar.ftl"/>
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
<hr/>
    <div>
        <h1>
            轮播图管理
        </h1>
    </div>
    </div>
        <form action="uploadImgs" method="POST" enctype="multipart/form-data">
    <div class="row rowcenter">

            <div class="col-md-5 col-md-offset-1">
                <div class="thumbnail">
                    <img src='${img1!}' class="img1" alt="...">
                    <div class="caption">
                        <h3>轮播图1</h3>
                        <p>切换轮播图片</p>
                        <p><input name="file1" class="btn btn-primary" type="file" id="btn1" value="更换图片"></input>
                    </div>
                </div>
            </div>

            <div class="col-md-5">
                <div class="thumbnail">
                    <img src='${img2!}' class="img2" alt="...">
                    <div class="caption">
                        <h3>轮播图2</h3>
                        <p>切换轮播图片</p>
                        <p><input name="file2" class="btn btn-primary" type="file" id="btn2" value="更换图片">
                    </div>
                </div>
            </div>
    </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-1">
                    <input class="btn btn-primary" type="submit"  value="全部上传图片">
                </div>
            </div>
        </form>
</div>

<!-- 轮播图预览 -->
<div class="preview">
    <hr/>
    <h1>预览</h1>

    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
<#--            <li data-target="#carousel-example-generic" data-slide-to="2"></li>-->
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src='${img1!}' class="img1" alt="...">
                <div class="carousel-caption">
                </div>
            </div>
            <div class="item">
                <img src='${img2!}' class="img1" alt="...">
                <div class="carousel-caption">

                </div>
            </div>

        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>





</div>
<script>
    // 切换图片
    $(document).ready(function () {
        $("#btn1").change(function () {
            $(".img1").attr("src", URL.createObjectURL($(this)[0].files[0]));

        });
        $("#btn2").change(function () {
            $(".img2").attr("src", URL.createObjectURL($(this)[0].files[0]));
        });

    });
</script>
<script>
    layui.use('carousel', function () {
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1',
            width: '1290px' //设置容器宽度
            ,
            arrow: 'always', //始终显示箭头
            //,anim: 'updown' //切换动画方式
            height: '400px',
            indicator:'inside'
            //full:true
        });
    });
</script>


<#include "./commonPage/footer.ftl"/>
</body>

</html>