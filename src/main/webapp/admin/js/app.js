angular.module('exampleApp', ['ngRoute', 'ngCookies', 'exampleApp.services'])
	.config(
		[ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
			
			$routeProvider.when('/createCategory', {
            				templateUrl: 'partials/create_categ.html',
            				controller: CreateCategController
            			});
            $routeProvider.when('/editCategory/:id', {
                templateUrl: 'partials/edit_categ.html',
                controller: EditCategController
            });
			$routeProvider.when('/createPost', {
				templateUrl: 'partials/create.html',
				controller: CreateController
			});
			
			$routeProvider.when('/edit/:id', {
				templateUrl: 'partials/edit.html',
				controller: EditController
			});

			$routeProvider.when('/login', {
				templateUrl: 'partials/login.html',
				controller: LoginController
			});
			
			$routeProvider.when('/index', {
				templateUrl: 'partials/index.html',
				controller: IndexController
			});
			$routeProvider.when('/categories', {
            				templateUrl: 'partials/index_categ.html',
            				controller: IndexCategController
            			});
			
			$locationProvider.hashPrefix('!');
			
			/* Register error provider that shows message on failed requests or redirects to login page on
			 * unauthenticated requests */
		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
			        return {
			        	'responseError': function(rejection) {
			        		var status = rejection.status;
			        		var config = rejection.config;
			        		var method = config.method;
			        		var url = config.url;
			      
			        		if (status == 401) {
			        			$location.path( "/login" );
			        		} else {
			        			$rootScope.error = method + " on " + url + " failed with status " + status;
			        		}
			              
			        		return $q.reject(rejection);
			        	}
			        };
			    }
		    );
		    
		    /* Registers auth token interceptor, auth token is either passed by header or by query parameter
		     * as soon as there is an authenticated user */
		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
		        return {
		        	'request': function(config) {
		        		var isRestCall = config.url.indexOf('/rest') == 0;
		        		if (isRestCall && angular.isDefined($rootScope.accessToken)) {
		        			var accessToken = $rootScope.accessToken;
		        			if (exampleAppConfig.useAccessTokenHeader) {
		        				config.headers['X-Access-Token'] = accessToken;
		        			} else {
		        				config.url = config.url + "?token=" + accessToken;
		        			}
		        		}
		        		return config || $q.when(config);
		        	}
		        };
		    }
	    );
		   
		} ]
		
	).run(function($rootScope, $location, $cookieStore, UserService) {
		
		/* Reset error when a new view is loaded */
		$rootScope.$on('$viewContentLoaded', function() {
			delete $rootScope.error;
		});
		
		$rootScope.hasRole = function(role) {
			
			if ($rootScope.user === undefined) {
				return false;
			}
			
			if ($rootScope.user.roles[role] === undefined) {
				return false;
			}
			
			return $rootScope.user.roles[role];
		};
		
		$rootScope.logout = function() {
			delete $rootScope.user;
			delete $rootScope.accessToken;
			$cookieStore.remove('accessToken');
			$location.path("/login");
		};
		
		 /* Try getting valid user from cookie or go to login page */
		var originalPath = $location.path();
		$location.path("/login");
		var accessToken = $cookieStore.get('accessToken');
		if (accessToken !== undefined) {
			$rootScope.accessToken = accessToken;
			UserService.get(function(user) {
				$rootScope.user = user;
				$location.path(originalPath);
			});
		}
		
		$rootScope.initialized = true;
	});


function IndexController($scope, BlogPostService, CategoryService) {

	$scope.blogPosts = BlogPostService.query();
    $scope.category = CategoryService.query();
	$scope.deletePost = function (blogPost) {
		blogPost.$remove(function () {
			$scope.blogPosts = BlogPostService.query();
		});
	};
}
function IndexCategController($scope, CategoryService) {
    $scope.category = CategoryService.query();
	$scope.deleteCateg = function (categ) {
		categ.$remove(function () {
			$scope.category = CategoryService.query();
		});
	};
}


function EditController($scope, $routeParams, $location, BlogPostService) {

	$scope.blogPost = BlogPostService.get({id: $routeParams.id});
	
	$scope.save = function() {
		$scope.blogPost.$save(function () {
			$location.path('/index');
		});
	};
}
function EditCategController($scope, $routeParams, $location, CategoryService) {

	$scope.categ = CategoryService.get({id: $routeParams.id});

	$scope.save = function() {
		$scope.categ.$save(function () {
			$location.path('/categories');
		});
	};
}


function CreateController($scope, $location, BlogPostService, CategoryService,$http) {

	$scope.blogPost = new BlogPostService();
	$scope.category = CategoryService.query();
	$scope.save = function() {
		$scope.blogPost.$save(function () {
			$location.path('/index');
		});
	};

};
function CreateCategController($scope, $location, CategoryService,$http) {
    $scope.categ = new CategoryService();
	$scope.save = function() {
		$scope.categ.$save(function () {
			$location.path('/categories');
		});
	};

};


function LoginController($scope, $rootScope, $location, $cookieStore, UserService) {
	
	$scope.rememberMe = false;
	
	$scope.login = function() {
		UserService.authenticate($.param({username: $scope.username, password: $scope.password}), function(authenticationResult) {
			var accessToken = authenticationResult.token;
			$rootScope.accessToken = accessToken;
			if ($scope.rememberMe) {
				$cookieStore.put('accessToken', accessToken);
			}
			UserService.get(function(user) {
				$rootScope.user = user;
				$location.path("/index");
			});
		});
	};
};


var services = angular.module('exampleApp.services', ['ngResource']);

services.factory('UserService', function($resource) {
	
	return $resource('/rest/user/:action', {},
			{
				authenticate: {
					method: 'POST',
					params: {'action' : 'authenticate'},
					headers : {'Content-Type': 'application/x-www-form-urlencoded'}
				}
			}
		);
});

services.factory('BlogPostService', function ($resource) {

	return $resource('/rest/blogposts/:id', {id: '@id'});
});

services.factory('CategoryService', function ($resource) {

	return $resource('/rest/category/:id', {id: '@id'});
});

