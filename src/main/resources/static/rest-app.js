/**
 * Created by erkan on 14.08.2016.
 */
var app = angular.module('restApp',['ngRoute']);

// configure our routes
app.config(function($routeProvider) {

    $routeProvider

    // route for the home page
        .when('/', {
            templateUrl : 'pages/home.html',
            controller  : 'mainController'
        })

        // route for the about page
        .when('/add', {
            templateUrl : 'pages/add.html',
            controller  : 'addController'
        })

        // route for the contact page
        .when('/list', {
            templateUrl : 'pages/list.html',
            controller  : 'listController'
        });
});


app.controller('mainController', function($scope) {
    $scope.message = 'Home!';
});

app.controller('addController', function($scope,$http,$location) {
    $scope.save = function(task) {
        debugger;
        $http.post('/task/',task).
            success(function(data) {
                $location.path('/list');
            });
    };
});

app.controller('listController', function($scope,$http,$location) {

    $scope.delete = function(taskIndex) {
        debugger;
        task = $scope.tasks[taskIndex];
        $http.delete('/task/'+task.id).
        success(function(data) {
            $scope.tasks.splice(taskIndex, 1);
            $location.path('/list');
        });
    };

    $http.get('/task/').
        success(function(data) {
            $scope.tasks = data;
        });
});