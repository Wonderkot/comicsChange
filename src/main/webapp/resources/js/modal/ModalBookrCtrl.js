angular.module('app').controller('ModalBookEditCtrl',
		function($scope, $modalInstance, $resource, editBook,list) {
			var publisherList = $resource('publishers/getAllPublishers');
			$scope.publishers = publisherList.query();
			var authorList = $resource('authors/getAllAuthors');
			$scope.authors = authorList.query();

			$scope.book = editBook;
			$scope.publisher = editBook.publisher;
			$scope.author = editBook.author;
			var index = list.indexOf(editBook);
			$scope.ok = function(book, author, publisher) {
				var add = $resource('books/updateBook');
				var adder = new add();
				adder.title = editBook.title;
				adder.publisher = publisher;				
				adder.author = author;
				adder.id = book.id;
				adder.$save();
				list[index] = adder;
				$modalInstance.close(list);
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		});

angular.module('app').controller('ModalBookAddCtrl',
		function($scope, $modalInstance, $resource,list) {
			var publisherList = $resource('publishers/getAllPublishers');
			$scope.publishers = publisherList.query();
			var authorList = $resource('authors/getAllAuthors');
			$scope.authors = authorList.query();

			$scope.ok = function(book, author, publisher) {				
				var add = $resource('books/addNewBook');
				var adder = new add();
				adder.title = book.title;
				adder.publisher= publisher;
				adder.author = author;
				adder.coverMain = book.coverMain;
				adder.$save();
				list.push(adder);
				$modalInstance.close();
			};

			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		});