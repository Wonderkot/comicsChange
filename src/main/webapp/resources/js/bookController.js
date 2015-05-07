angular.module('app').controller('bookCtrl', function($scope, $http, $resource) {

var list = $resource('rest/getAllBooks');
$scope.books = list.query();

$scope.removeItem = function removeItem(book) {
		var index = $scope.books.indexOf(book);
		if (index !== -1) {
			$scope.books.splice(index, 1);
		}
		;

		var deleteReq = {
			method : 'DELETE',
			url : 'rest/deleteBook',
			params : {
				id : book.id
			},
			timeout : 5000
		}
		$http(deleteReq).success();
	};
	
$scope.addItem = function addItem(book) {		
		var add = $resource('rest/addNewBook');
		var adder = new add();
		adder.name = book.name;		
		adder.$save();		
		var index =  $scope.books.length;
		$scope.books.splice(index,0,adder);		
		$scope.book = {};		
	}	

	});
