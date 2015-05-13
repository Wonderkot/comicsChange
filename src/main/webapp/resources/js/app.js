var app = angular.module('app', [ 'ngRoute', 'ngResource', 'smart-table' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/publishers.html',
		controller : 'publisherCtrl'
	}).when('/books/', {
		templateUrl : 'views/books.html',
		controller : 'bookCtrl'
	}).when('/publishers/', {
		templateUrl : 'views/publishers.html',
		controller : 'publisherCtrl'
	}).when('/authors/', {
		templateUrl : 'views/authors.html',
		controller : 'authorCtrl'
	})
} ]);