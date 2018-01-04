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
			})

		} ]);