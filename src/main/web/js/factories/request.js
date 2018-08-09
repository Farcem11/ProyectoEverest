app.factory('request', function($http, $q, $location) 
{
    var webServiceUrl = $location.protocol() + "://" + $location.host() + ":" + $location.port() + "/";
    var request = {};

    request.post = function(webServiceName, pData)
    {
        var deferred = $q.defer();
        
        $http.post(webServiceUrl + webServiceName, pData)
        .then(function successCallback(response) 
        {
            deferred.resolve(response);
        }, 
        function errorCallback(response) 
        {
            deferred.reject(response);
        });
        
        return deferred.promise;
    };

    request.get = function(webServiceName) 
    {
        var deferred = $q.defer();

        $http.get(webServiceUrl + webServiceName)
        .then(function successCallback(response) 
        {
            deferred.resolve(response);
        }, 
        function errorCallback(response) 
        {
            deferred.reject(response);
        });

        return deferred.promise;
    };

    return request;
});