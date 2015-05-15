angular.module('app').controller('authorCtrl',
		function($scope, $http, $resource, $modal) {
			var list = $resource('authors/getAllAuthors');
			$scope.authors = list.query();
			$scope.displayedCollection = [].concat($scope.authors);

			$scope.removeItem = function removeItem(author) {
				var index = $scope.authors.indexOf(author);
				if (index !== -1) {
					$scope.authors.splice(index, 1);
				}
				;

				/*
				 * var remove = $resource('authors/deleteAuthor'); remove.id =
				 * author.id; remove.$remove();
				 */

				var deleteReq = {
					method : 'DELETE',
					url : 'authors/deleteAuthor',
					params : {
						id : author.id
					},
					timeout : 5000
				}
				$http(deleteReq).success();
			};

			$scope.addItem = function addItem() {
				var modalInstance = $modal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'views/modals/addAuthor.html',
					controller : 'ModalAuthorAddCtrl',
					resolve : {
						list : function() {
							return $scope.authors
						}
					}
				})
			}

			$scope.open = function(author) {

				var modalInstance = $modal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'views/modals/editAuthor.html',
					controller : 'ModalAuthorEditCtrl',
					resolve : {
						editAuthor : function() {
							return author;
						}
					}
				})
			};

		});
