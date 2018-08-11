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
		"title" : "Would you like to update an existing file?",
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

	return common;
});