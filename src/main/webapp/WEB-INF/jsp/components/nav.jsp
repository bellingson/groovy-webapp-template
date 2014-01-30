
    <div class="top-links pull-right">
        <a ng-show="currentUser == null" href="/#/signin">Sign In</a>
        <a ng-show="currentUser != null" href="/user/signout">Sign Out</a>
        <a ng-show="isUserInRole('admin')" href="/admin/user/">Admin</a>
    </div>



		<div class="masthead">
        <h3 class="muted"><a class="home" href="/#/">Groovy Web App</a></h3>
        <div class="navbar">
          <div class="navbar-inner">
            <div class="container">
              <ul class="nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Projects</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Downloads</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
              </ul>
            </div>
          </div>
        </div><!-- /.navbar -->
      </div>
		
