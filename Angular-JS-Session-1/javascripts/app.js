var app = angular.module('myApp',['ui.bootstrap']);

app.controller('MainController',function($scope,$http) {
	$http.get("customer.json")
		.success(function(response){
			$scope.customers = response;
			$scope.totalItems = $scope.customers.length;
		});

	$scope.currentPage = 1;
	$scope.itemsPerPage = 8;
	$scope.editedItem = {};
	$scope.view="col-sm-6 col-md-4 col-lg-3";

	$scope.list = function(){
		$scope.view="col-xs-12";
	}

	$scope.card = function(){
		$scope.view="col-sm-6 col-md-4 col-lg-3";
	}

	$scope.editDetails = function($index) {
		$scope.$index = $index;
		angular.copy($scope.customers[$index], $scope.editedItem);
		
	};
	
	$scope.updateDetails = function() {
		angular.copy($scope.editedItem, $scope.customers[$scope.$index]) 
	}
	
	$scope.deleteDetails = function($index){
		$scope.customers.splice($index,1);
	}
});