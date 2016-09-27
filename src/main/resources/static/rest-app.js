/**
 * Created by erkan on 14.08.2016.
 */
var app = angular.module('restApp',[]);
app.controller('restController',function($scope,$http){
    $http.get('http://localhost:9000/task/').
        success(function(data) {
            $scope.tasks = data;
    });
});