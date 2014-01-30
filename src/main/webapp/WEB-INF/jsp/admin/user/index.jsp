<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>Welcome</title>  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  

    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/style/style.css" type="text/css" charset="utf-8"/>


</head>
<body ng-app='userApp'>

<div class="container">

    <%@ include file="../../components/nav.jsp" %>

    <div id="content" ng-view>



    </div>

<footer>
    &copy; ACME
</footer>
</div>


<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-route.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-resource.min.js"></script>

<script src="/script/admin/user/user-app.js" type="text/javascript" charset="utf-8"></script>
<script src="/script/admin/user/user-controller.js" type="text/javascript" charset="utf-8"></script>
<script src="/script/current-user.js" type="text/javascript" charset="utf-8"></script>

</body>
</html>
