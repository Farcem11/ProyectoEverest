"use strict";

var app = angular.module("appTemplate",["ui.router"]);

app.run(function($rootScope,$state)
{
	$state.go("main")
});

app.config(function($stateProvider)
{
	$stateProvider.state("main",
	{
		url:"/",
		templateUrl:"views/main.html",
		controller:"mainController"})
	.state("hello",
	{
		url:"/hello",
		template:"<h3>hello world!</h3>"
	})
});