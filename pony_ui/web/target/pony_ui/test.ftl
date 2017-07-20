
<script type="text/javascript"  src="static/js/angular.js"></script>
<div ng-app="stateApp" ng-controller="stateController">
    <button ng-click = "change(1)">按钮</button>
</div>
<script>
    var app = angular.module("stateApp", [])

    app.controller("stateController", function($scope){
        $scope.change = function(num){
            console.log(1111);
        }
    })
</script>