angular.module('app').controller('publisherCtrl',
		function($scope, $http, $resource, $modal) {

			var list = $resource('publishers/getAllPublishers');
			$scope.publishers = list.query();
			$scope.displayedCollection = [].concat($scope.publishers);

			$scope.removeItem = function removeItem(publisher) {
				var index = $scope.publishers.indexOf(publisher);
				if (index !== -1) {
					$scope.publishers.splice(index, 1);
				}
				;

				var deleteReq = {
					method : 'DELETE',
					url : 'publishers/deletePublisher',
					params : {
						id : publisher.id
					},
					timeout : 5000
				}
				$http(deleteReq).success();
			};

			$scope.addItem = function addItem() {
				var modalInstance = $modal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'views/modals/addPublisher.html',
					controller : 'ModalPublisherAddCtrl',
					resolve : {
						list : function() {
							return $scope.publishers
						}
					}
				})
			}
			
			$scope.open = function(publisher) {

				var modalInstance = $modal.open({
					animation : $scope.animationsEnabled,
					templateUrl : 'views/modals/editPublisher.html',
					controller : 'ModalPublisherEditCtrl',
					resolve : {
						editPublisher : function() {
							return publisher;
						}
					}
				})
			};

		});
