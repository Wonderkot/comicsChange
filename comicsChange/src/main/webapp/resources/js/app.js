var app = angular.module('app', [ 'Controllers', 'ngRoute' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/authors.html',
		controller : 'authorController'
	}).when('/books/', {
		templateUrl : 'views/books.html',
		controller : 'bookController'
	}).when('/pulishers/', {
		templateUrl : 'views/publishers.html',
		controller : 'bookController'
	}).when('/authors/', {
		templateUrl : 'views/authors.html',
	controller : 'authorController'
})
} ]);