var Controllers = angular.module('Controllers', [ 'ngResource' ]);

Controllers.controller('authorController', function($scope, $http, $resource) {
	var list = $resource('rest/getAllAuthors');
	$scope.authors = list.query();

	$scope.removeItem = function removeItem(author) {
		var index = $scope.authors.indexOf(author);
		if (index !== -1) {
			$scope.authors.splice(index, 1);
		}
		;

		var deleteReq = {
			method : 'DELETE',
			url : 'rest/deleteAuthor',
			params : {
				id : author.id
			},
			timeout : 5000
		}
		$http(deleteReq).success();
	};

	
	$scope.addItem = function addItem(author) {		
		var add = $resource('rest/addNewAuthor');
		var adder = new add();
		adder.name = author.name;
		adder.surname = author.surname;
		adder.patronymic = author.patronymic;
		adder.$save();		
		var index =  $scope.authors.length;
		$scope.authors.splice(index,0,adder);		
		author.name = '';
		author.surname = '';
		author.patronymic = '';
	}

});
