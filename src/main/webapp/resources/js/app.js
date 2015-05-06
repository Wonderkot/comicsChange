var app = angular.module('app', [ 'ngRoute','ngResource' ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/publishers.html',
		controller : 'publisherCtrl'
	}).when('/books/', {
		templateUrl : 'views/books.html',
		controller : 'authorCtrl'
	}).when('/publishers/', {
		templateUrl : 'views/publishers.html',
		controller : 'publisherCtrl'
	}).when('/authors/', {
		templateUrl : 'views/authors.html',
		controller : 'authorCtrl'
	})
} ]);