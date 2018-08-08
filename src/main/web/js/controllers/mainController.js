app.controller("mainController",function($scope, $rootScope, $http)
{
	$scope.statisticalDataList = [];
	
	$http.get("http://localhost:8080/StatisticalData/get").then(
	function(response)
    {
    	$scope.statisticalDataList = response.data;
    },
    function(error)
    {
	    console.log(error);
    });
});