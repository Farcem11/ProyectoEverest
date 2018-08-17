app.service('common', function() 
{
	var common = {};
	
	common.actionType = Object.freeze(
	{
		"SAVE":1, 
		"DELETE":2, 
		"UPDATE":3,
		"DOWNLOAD":4,
		"CALCULATE":5
	});

	common.dialogs = {};

	common.dialogs[common.actionType.SAVE] =
	{
		"title" : "Would you like to save this file?",
		"content" : "This will save the file in the system"
	};

	common.dialogs[common.actionType.DELETE] =
	{
		"title" : "Would you like to delete this file?",
		"content" : "This will delete this file from the system, this can't be undone"
	};

	common.dialogs[common.actionType.UPDATE] =
	{
		"title" : "Would you like to update this file?",
		"content" : "This will update this file in the system, the numbers and name file be overwritten"
	};

	common.dialogs[common.actionType.DOWNLOAD] =
	{
		"title" : "Would you like to download this file?",
		"content" : "This will download this file in your computer"
	};

	common.dialogs[common.actionType.CALCULATE] =
	{
		"title" : "Would you like to calculate the statistical values of this file?",
		"content" : "This will download the statistical values of this file in your computer"
	};

	common.castToJsonList = function(numbersArray) 
	{
		var list = [];
		angular.forEach(numbersArray, function(number)
		{
			list.push({"number" : number})
		});
		return list;
	};

	common.castToList = function(numberJsons) 
	{
		var list = [];
		angular.forEach(numberJsons, function(json)
		{
			list.push(json.number);
		});
		return list;
	};

	common.areNumberArraysEqual = function(array1, array2)
	{
		return (JSON.stringify(array1.sort()) === JSON.stringify(array2.sort()));
	};

	common.downloadFile = function(fileName, fileContent) 
	{
		var element = document.createElement('a');
		element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(fileContent));
		element.setAttribute('download', fileName);

		element.style.display = 'none';
		document.body.appendChild(element);

		element.click();

		document.body.removeChild(element);
	};

	common.castToCsv = function(json)
	{
		var csv = "";
		Object.keys(json).forEach(function(key)
		{
    		csv += key + "," + json[key].join(" - ") + "\n";
		});
		return csv;
	};

	common.isCsvFile = function(fileName)
	{
		var splitFileName = fileName.split(".", -1);
		var extension = splitFileName[splitFileName.length-1];
		if(extension === "csv")
		{
			return true;
		}
		return false;
	}

	return common;
});