"use strict";

var app = angular.module("app",['ngMaterial','ngMessages']);

app.run(function($rootScope)
{
	$rootScope.setSuccessMessage = function(message)
	{
		$rootScope.messageType = "success";
		$rootScope.message = message;
	};

	$rootScope.setWarningMessage = function(message)
	{
		$rootScope.messageType = "warning";
		$rootScope.message = message;
	};

	$rootScope.setErrorMessage = function(message)
	{
		$rootScope.messageType = "error";
		$rootScope.message = message;
	};

	$rootScope.setInformationMessage = function(message)
	{
		$rootScope.messageType = "information";
		$rootScope.message = message;
	};
	
	$rootScope.setInformationMessage("This is the status bar.");
})