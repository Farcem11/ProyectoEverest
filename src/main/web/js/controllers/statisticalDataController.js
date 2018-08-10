app.controller("statisticalDataController", function($scope, $rootScope, request)
{
	$scope.statisticalDataList = [];
	$scope.fileName = "";
	$scope.fileContent = "";

	$scope.castToJsonList = function(numbersArray) 
	{
		var list = [];
		angular.forEach(numbersArray, function(number)
		{
			list.push({"number" : number})
		});
		return list;
	};

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
                $rootScope.setSuccessMessage("File " + file.name +" was uploaded successfully");
                $scope.$apply();
            }
            reader.onerror = function(event) 
            {
            	$rootScope.setErrorMessage("There was an error while uploading the file, please try again");
                $scope.$apply();
            }
        }
    };

    $scope.addNumber = function(chip, index) 
    {
    	var numbers = chip.split(",", -1);
    	angular.forEach(numbers, function(number, iterator)
    	{
    		if(isNaN(number))
    		{
    			$rootScope.setWarningMessage("Invalid input : Adding only numbers.");
    			return null;
    		};

	        $scope.statisticalDataList[index].numbersArray.push({"number" : number});
    	});
        return null;
    };

	$scope.getStatisticalData = function() 
	{
		request.get('StatisticalData/get')
		.then(function(response)
		{
	    	angular.forEach(response.data, function(statisticalData, index)
	    	{
	    		response.data[index].numbersArray = $scope.castToJsonList(statisticalData.numbersArray);
	    	});
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
	    	$rootScope.setSuccessMessage("File saved successfully");
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