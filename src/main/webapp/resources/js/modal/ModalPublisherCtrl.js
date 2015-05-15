angular.module('app').controller('ModalPublisherEditCtrl',
		function($scope, $modalInstance, $resource, editPublisher,list) {
			$scope.publisher = editPublisher;
			$scope.ok = function() {
				var add = $resource('publishers/updatePublisher');
				var adder = new add();
				adder.name = editPublisher.name;
				adder.id = editPublisher.id;
				adder.$save();
				list.push(adder);
				$modalInstance.close();
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		});

angular.module('app').controller('ModalPublisherAddCtrl',
		function($scope, $modalInstance, $resource, list) {
			$scope.ok = function(publisher) {
				$scope.newPublisher = publisher;
				var add = $resource('publishers/addNewPublisher');
				var adder = new add();
				adder.name = publisher.name;
				adder.$save();
				var index = list.length;
				list.splice(index, 0, adder);
				$modalInstance.close();
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		});