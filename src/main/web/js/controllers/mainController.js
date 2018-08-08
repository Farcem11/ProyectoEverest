app.controller("mainController",function($scope, $rootScope, $http)
{
	$scope.title = "name";

	$http.get("wrongfilename.htm")
    .then(function(response) 
    {
        $scope.content = response.data;
    }, 
    function(error) 
    {
        $scope.content = "Something went wrong";
    });
});