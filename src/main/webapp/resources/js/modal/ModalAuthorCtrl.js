angular.module('app').controller('ModalAuthorCtrl',
		function($scope, $modalInstance, $resource, editAuthor, list) {
			$scope.author = editAuthor;
			$scope.ok = function() {
				var add = $resource('authors/updateAuthor');
				var adder = new add();
				adder.name = editAuthor.name;
				adder.surname = editAuthor.surname;
				adder.patronymic = editAuthor.patronymic;
				adder.id = editAuthor.id;
				adder.$save();
				$modalInstance.close();
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		});