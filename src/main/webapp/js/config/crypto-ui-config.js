app.config([ '$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {
			$urlRouterProvider.otherwise("home");
			$stateProvider.state('home', {
				url : "/home",
				controller:"priceCtrl",
				templateUrl : "view/home.html"
			}).state('articles', {
				url : "/articles",
				controller:"articlesCtrl",
				templateUrl : "view/articles.html"
			}).state('signIn', {
				url : "/signIn",
				controller:"signInCtrl",
				templateUrl : "view/signIn.html"
			}).state('signUp', {
				url : "/signUp",
				controller:"signUpCtrl",
				templateUrl : "view/signUp.html"
			})

		} ]);