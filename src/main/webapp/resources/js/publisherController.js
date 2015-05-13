angular.module('app').controller('publisherCtrl', function($scope, $http, $resource) {

var list = $resource('publishers/getAllPublishers');
$scope.publishers = list.query();

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
	
$scope.addItem = function addItem(publisher) {		
		var add = $resource('publishers/addNewPublisher');
		var adder = new add();
		adder.name = publisher.name;		
		adder.$save();		
		var index =  $scope.publishers.length;
		$scope.publishers.splice(index,0,adder);		
		$scope.publisher = {};		
	}	

	});
