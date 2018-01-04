<!DOCTYPE html>
<html>

<head>
<title>Crypto Currency Price</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- <base href="/"> -->
</head>
<script src="js/angular.min.js"></script>
<script src="js/angular-animate.min.js"></script>
<script src="js/angular-ui-router.min.js"></script>
<script type="text/javascript" src="js/ngStorage.min.js"></script>
<script src="js/index.js"></script>
<script src="js/config/crypto-ui-config.js" type="text/javascript"></script>


<body>

	<div ng-app="cryptoPrice">
		<nav class="navbar navbar-inverse">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header container-fluid">
				<button type="button" data-target="#navbarCollapse"
					data-toggle="collapse" class="navbar-toggle">
					<span class="sr-only">Crypto Navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a  ui-sref=".home" class="navbar-brand">Crypto
					Currency Price Checker</a>
			</div>
			<!-- Collection of nav links and other content for toggling -->
			<div id="navbarCollapse" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#" ui-sref="articles">Articles</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Sign In</a></li>
					<li><a href="#">Sign Up</a></li>
				</ul>
			</div>
		</nav>
		<div ui-view></div>
	</div>
</body>
</html>
