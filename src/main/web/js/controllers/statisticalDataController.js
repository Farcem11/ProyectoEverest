app.controller("statisticalDataController", function($scope, $rootScope, request, $mdDialog, common)
{
	$scope.statisticalDataList = [];
	$scope.fileName = null;
	$scope.fileContent = null;
	$scope.actionType = common.actionType;

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
            	document.getElementById("fileForUpload").value = null;
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
    		if(isNaN(number) || number === "")
    		{
    			$rootScope.setWarningMessage("Invalid input : Adding only numbers.");
    			return null;
    		};

	        $scope.statisticalDataList[index].numberJsons.push({"number" : parseInt(number)});
    	});
        return null;
    };

	$scope.getStatisticalData = function(successMessage) 
	{
		request.get('StatisticalData/get')
		.then(function(response)
		{
	    	angular.forEach(response.data, function(statisticalData, index)
	    	{
	    		response.data[index].numberJsons = common.castToJsonList(statisticalData.numbersArray);
		    	response.data[index].originalName = statisticalData.name;
	    	});
	    	$scope.statisticalDataList = response.data;
	
	    	if(successMessage != null)
		    {
		    	$rootScope.toogleLoading();
		    	$rootScope.setSuccessMessage(successMessage);
		    }
		})
	    .catch(function(response)
	    {
		    $rootScope.setErrorMessage(response.data.error + ": " + response.data.message);
	    });
	};

	$scope.saveStatisticalData = function() 
	{
		if($scope.fileName == null || $scope.fileContent == null)
		{
			$rootScope.setWarningMessage("Please select a file first");
			return;
		};

		var data =
		{
			"fileName" : $scope.fileName,
			"fileContent" : $scope.fileContent
		};

		$rootScope.toogleLoading();
		request.post("StatisticalData/save", data)
		.then(function(response)
	    {
	    	$scope.getStatisticalData("File saved successfully");
	    	$scope.fileName = null;
	    	$scope.fileContent = null;
	    })
	    .catch(function(response)
	    {
	    	$rootScope.toogleLoading();
	    	$scope.fileName = null;
	    	$scope.fileContent = null;
		    $rootScope.setErrorMessage(response.data.error + ": " + response.data.message);
		    document.getElementById("fileForUpload").value = null;
	    });
	};

	$scope.updateStatisticalData = function(index) 
	{
		var numbersArrayFromInput = common.castToList($scope.statisticalDataList[index].numberJsons);
		var sameArrays = common.areNumberArraysEqual(numbersArrayFromInput, $scope.statisticalDataList[index].numbersArray);
		var sameName = $scope.statisticalDataList[index].name == $scope.statisticalDataList[index].originalName;
		if(sameArrays && sameName)
		{
			$rootScope.setErrorMessage("The numbers and name are the same, change them to update");
			return;
		};

		var data =
		{
			"id" : $scope.statisticalDataList[index].id,
			"newName" : $scope.statisticalDataList[index].name,
			"newNumbers" : numbersArrayFromInput.toString()
		};

		$rootScope.toogleLoading();
		request.post("StatisticalData/update", data)
		.then(function(response)
	    {
	    	$scope.getStatisticalData("File updated successfully");
	    })
	    .catch(function(response)
	    {
	    	$rootScope.toogleLoading();
		    $rootScope.setErrorMessage(response.data.error + ": " + response.data.message);
	    });
	};

	$scope.deleteStatisticalData = function(index) 
	{
		var data =
		{
			"id" : $scope.statisticalDataList[index].id,
		};

		$rootScope.toogleLoading();
		request.post("StatisticalData/delete", data)
		.then(function(response)
	    {
	    	$scope.getStatisticalData("File deleted successfully");
	    })
	    .catch(function(response)
	    {
	    	$rootScope.toogleLoading();
		    $rootScope.setErrorMessage(response.data.error + ": " + response.data.message);
	    });
	};

	$scope.calculateStatisticalData = function(index)
	{
		var data =
		{
			"id" : $scope.statisticalDataList[index].id,
		};

		$rootScope.toogleLoading();
		request.post("StatisticalData/calculate", data)
		.then(function(response)
	    {
	    	var fileContent = common.castToCsv(response.data);
	    	var fileName = "Statistical Calculation - " + $scope.statisticalDataList[index].originalName;
	    	common.downloadFile(fileName, fileContent);
	    	$rootScope.toogleLoading();
	    	$rootScope.setSuccessMessage("Statistical calculation successful");	
	    })
	    .catch(function(response)
	    {
		    $rootScope.setErrorMessage(response.data.error + ": " + response.data.message);
	    });
	};

	$scope.showConfirm = function(event, index, actionType) 
	{
		var confirm = $mdDialog.confirm()
		.title(common.dialogs[actionType].title)
		.textContent(common.dialogs[actionType].content)
		.targetEvent(event)
		.ok('Confirm')
		.cancel('Cancel');

		$mdDialog.show(confirm).then(
		function() 
		{
			switch(actionType)
			{
			    case $scope.actionType.DELETE:
			    	$scope.deleteStatisticalData(index);
			        break;
			     case $scope.actionType.SAVE:
			    	$scope.saveStatisticalData();
			        break;
			     case $scope.actionType.UPDATE:
			    	$scope.updateStatisticalData(index);
			        break;
			     case $scope.actionType.DOWNLOAD:
			     	var fileName = $scope.statisticalDataList[index].originalName;
			     	var fileContent = $scope.statisticalDataList[index].numbersArray.toString();
			    	common.downloadFile(fileName, fileContent);
			        break;
			     case $scope.actionType.CALCULATE:
			    	$scope.calculateStatisticalData(index);
			        break;				         
			    default:
			        $rootScope.setErrorMessage("Something went wrong with the dialog");
			};
		},
		function(){});
	};

	$scope.getStatisticalData(null);
});