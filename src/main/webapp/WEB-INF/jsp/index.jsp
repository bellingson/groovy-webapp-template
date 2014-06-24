<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>Welcome</title>	
    <meta name="viewport" content="width=device-width, initial-scale=1.0">	

	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="style/style.css" type="text/css" charset="utf-8"/>


</head>
<body ng-app='myapp'>
	
	<div class="container">

		<%@ include file="components/nav.jsp" %>

	
		<div id="content" ng-view>
			
			
			
		</div>
	
	      <div class="footer">
	        <p>&copy; ACME 2013</p>
	      </div>	
	</div>

    <script src="/lib/js/jquery.min.js"></script>
	<script src="/bootstrap/js/bootstrap.js"></script>

	<script src="/lib/js/angular.min.js"></script>
	<script src="/lib/js/angular-route.min.js"></script>
	<script src="/lib/js/angular-resource.min.js"></script>
	<script src="/script/widget/widget-app.js" type="text/javascript" charset="utf-8"></script>
    <script src="/script/widget/widget-controller.js" type="text/javascript" charset="utf-8"></script>
    <script src="/script/widget/speaker-controller.js" type="text/javascript" charset="utf-8"></script>
    <script src="/script/current-user.js" type="text/javascript" charset="utf-8"></script>
    <!--
	<script src="script/controller/user.js" type="text/javascript" charset="utf-8"></script>
	-->


</body>	
</html>
