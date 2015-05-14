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

			$scope.addItem = function addItem(author) {
				var add = $resource('authors/addNewAuthor');
				var adder = new add();
				adder.name = author.name;
				adder.surname = author.surname;
				adder.patronymic = author.patronymic;
				adder.$save();
				var index = $scope.authors.length;
				$scope.authors.splice(index, 0, adder);
				$scope.author = {};
			}

			$scope.open = function(author) {

				var modalInstance = $modal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'myModalContent.html',
					controller : 'ModalAuthorCtrl',
					resolve : {
						editAuthor : function() {
							return author;
						},
						list : function() {
							return $scope.authors;
						}
					}
				})
			};

		});
