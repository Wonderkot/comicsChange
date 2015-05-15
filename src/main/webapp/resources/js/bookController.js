angular.module('app').controller('bookCtrl',
		function($scope, $http, $resource, $modal) {

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

			$scope.addItem = function addItem() {
				var modalInstance = $modal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'views/modals/addBook.html',
					controller : 'ModalBookAddCtrl',
					resolve : {
						list : function() {
							return $scope.books;
						}
					}
				});
			};
			$scope.open = function(book) {

				var modalInstance = $modal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'views/modals/editBook.html',
					controller : 'ModalBookEditCtrl',
					resolve : {
						editBook : function() {
							return book;
						},
						list : function() {
							return $scope.books;
						}
					}
				});
			};

		});
