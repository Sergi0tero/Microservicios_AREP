
var app = angular.module("TweetsManagement", []);

//Controller Part
app.controller("TweetsManagementController", function ($scope, $http) {

//Initialize page with default data which is blank in this example
$scope.tweets = [];

$scope.form = {
  id: "",
  content: ""
};

//Now load the data from server
_refreshPageData();

//HTTP POST methods for add tweet
$scope.add = function () {
  var data = { "id": $scope.form.id, "content": $scope.form.content };

  $http({
    method: "POST",
    url: 'http://ec2-54-204-233-224.compute-1.amazonaws.com:8080/stream',
    data: angular.toJson(data),
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(_success, _error);
};

/* Private Methods */
//HTTP GET- get all tweets collection
function _refreshPageData() {
  $http({
    method: 'GET',
    url: 'http://ec2-54-204-233-224.compute-1.amazonaws.com:8080/stream'
  }).then(function successCallback(response) {
    $scope.tweets = response.data;
  }, function errorCallback(response) {
    console.log(response.statusText);
  });
}

function _success(response) {
  _refreshPageData();
  _clearForm();
}

function _error(response) {
  alert(response.data.message || response.statusText);
}

//Clear the form
function _clearForm() {
  $scope.form.id = "";
  $scope.form.content = "";
}
});