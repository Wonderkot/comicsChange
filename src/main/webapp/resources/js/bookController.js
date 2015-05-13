angular.module('app').controller('bookCtrl', function($scope, $http, $resource) {

var list = $resource('books/getAllBooks');
$scope.books = list.query();
$scope.displayedCollection = [].concat($scope.books);

$scope.removeItem = function removeItem(book) {
		var index = $scope.books.indexOf(book);
		if (index !== -1) {
			$scope.books.splice(index, 1);
		}
		;

		var deleteReq = {
			method : 'DELETE',
			url : 'books/deleteBook',
			params : {
				id : book.id
			},
			timeout : 5000
		}
		$http(deleteReq).success();
	};
	
$scope.addItem = function addItem(book) {		
		var add = $resource('books/addNewBook');
		var adder = new add();
		adder.name = book.name;		
		adder.$save();		
		var index =  $scope.books.length;
		$scope.books.splice(index,0,adder);		
		$scope.book = {};		
	}	

	});
