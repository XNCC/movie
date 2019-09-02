<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Sign Up</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <link rel="stylesheet" href="css/demo.css" />
    <link rel="stylesheet" href="css/templatemo-style.css">
    <script type="text/javascript" src="js/modernizr.custom.86080.js"></script>

</head>

<body>

<div id="particles-js"></div>

<ul class="cb-slideshow">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>

<div class="container-fluid">
    <div class="row cb-slideshow-text-container ">
        <div class= "tm-content col-xl-6 col-sm-8 col-xs-8 ml-auto section">
            <header class="mb-5"><h1>小电影网</h1></header>
            <P class="mb-5">Small movie web login page, you can log in below. Thank you for visiting our site!</P>

            <form action="/signIn" method="get" class="subscribe-form">
                <div class="row form-section">

                    <div class="col-md-7 col-sm-7 col-xs-7">
                        <input name="username" type="text" class="form-control" id="username" placeholder="用户名" required/>
                    </div>
                    <div class="col-md-7 col-sm-7 col-xs-7">
                        <input name="password" type="password" class="form-control" id="password" placeholder="密码" required/>
                    </div>
                    <div class="col-md-7 col-sm-7 col-xs-7">
                        <button type="submit" class="tm-btn-subscribe">提交${error!}</button>
                    </div>

                </div>
            </form>


        </div>
    </div>
    <div class="footer-link">
        <p>小林子电影公司

            - Design: <a rel="nofollow" href="#" target="_parent">copy</a></p>
        <p>Login Page <a href="#" target="_blank" >小电影网</a> - make from <a href="#" >冲冲冲</a></p>
    </div>
</div>
</body>

<script type="text/javascript" src="./js/particles.js"></script>
<script type="text/javascript" src="./js/app.js"></script>
</html>