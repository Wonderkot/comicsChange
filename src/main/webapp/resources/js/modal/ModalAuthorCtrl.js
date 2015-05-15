angular.module('app').controller('ModalAuthorEditCtrl',
		function($scope, $modalInstance, $resource, editAuthor,list) {
			$scope.author = editAuthor;
			$scope.ok = function() {
				var add = $resource('authors/updateAuthor');
				var adder = new add();
				adder.name = editAuthor.name;
				adder.surname = editAuthor.surname;
				adder.patronymic = editAuthor.patronymic;
				adder.id = editAuthor.id;
				adder.$save();
				list.push(adder);
				$modalInstance.close();
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		});

angular.module('app').controller('ModalAuthorAddCtrl',
		function($scope, $modalInstance, $resource, list) {
			$scope.ok = function(author) {
				$scope.newAuthor = author;
				var add = $resource('authors/addNewAuthor');
				var adder = new add();
				adder.name = author.name;
				adder.surname = author.surname;
				adder.patronymic = author.patronymic;
				adder.$save();
				var index = list.length;
				list.splice(index, 0, adder);
				$modalInstance.close();
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		});