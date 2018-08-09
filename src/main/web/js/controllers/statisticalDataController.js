app.controller("statisticalDataController", function($scope, $rootScope, request)
{
	$scope.statisticalDataList = [];
	$scope.fileName = "";
	$scope.fileContent = "";

    $scope.uploadFile = function()
    {
        var file = document.getElementById("fileForUpload").files[0];
        if(file) 
        {
            $scope.fileName = file.name;
            var reader = new FileReader();
            reader.readAsText(file, "UTF-8");
            reader.onload = function(event)
            {
                $scope.fileContent = event.target.result;
            }
            reader.onerror = function(event) 
            {
                $scope.fileContent = "error reading file";
            }
        }
    };

	$scope.getStatisticalData = function() 
	{
		request.get('StatisticalData/get')
		.then(function(response)
		{
	    	$scope.statisticalDataList = response.data;
		})
	    .catch(function(response)
	    {
		    $rootScope.setErrorMessage(response.data.error + ":" + response.data.message);
	    });
	};

	$scope.saveStatisticalData = function() 
	{
		var data =
		{
			"fileName" : $scope.fileName,
			"fileContent" : $scope.fileContent
		};

		request.post("StatisticalData/save", data)
		.then(function(response)
	    {
	    	$scope.getStatisticalData();
	    	$rootScope.setSuccessMessage("File added successfully");
	    })
	    .catch(function(response)
	    {
		    $rootScope.setErrorMessage(response.data.error + ":" + response.data.message);
	    });
	};

	$scope.deleteStatisticalData = function(index) 
	{
		var data =
		{
			"id" : $scope.statisticalDataList[index].id,
		};

		request.post("StatisticalData/delete", data)
		.then(function(response)
	    {
	    	$scope.getStatisticalData();
	    	$rootScope.setSuccessMessage("File deleted successfully");
	    })
	    .catch(function(response)
	    {
		    $rootScope.setErrorMessage(response.data.error + ":" + response.data.message);
	    });
	};

	$scope.getStatisticalData();
});