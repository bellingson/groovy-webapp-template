<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title></title>
    <link rel="stylesheet" href="/style/reset.css" type="text/css" charset="utf-8"/>
    <link rel="stylesheet" href="/style/style.css" type="text/css" charset="utf-8"/>

</head>
<body ng-app='userApp'>

<div id="container">

    <header class="section">
        <a class="home" href="/#/">ACME Corp</a>

        <div class="top-links">
            <a href="/#/signin">Login</a>
        </div>


    </header>

    <div id="content" ng-view>



    </div>


</div>
<footer>
    &copy; ACME
</footer>

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-route.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-resource.min.js"></script>

<script src="/script/admin/user/user-app.js" type="text/javascript" charset="utf-8"></script>
<script src="/script/admin/user/user-controller.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
