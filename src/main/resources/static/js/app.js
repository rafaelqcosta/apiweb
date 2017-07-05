//Criação do módulo principal da aplicação
var app = angular.module("app", []);

// Criação de controllers
// exemplos
app.controller("cadastroController", function() {
});

app.controller("contatoController", function() {
});

app.controller("indexController", function($scope, $http) {

	$scope.alunos = [];
	$scope.aluno = {};
	$scope.carregarAluno = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/alunos'
		}).then(function sucesso(response) {
			$scope.alunos = response.data;
		}, function erro(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.addAluno = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/alunos',
			data : aluno
		}).then(function sucesso(response) {
			// $scope.alunos = response.data;
		}, function erro(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

});
