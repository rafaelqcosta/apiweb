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

	$scope.salvar = function(){
			var a = $scope.aluno;
			if (a.id == null){
				$scope.add();
			}
			else{
				$scope.editar();
			}
	};
	
	$scope.preencher(){
		//preencher
	}
	
	$scope.carregar = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/alunos'
		}).then(function sucesso(response) {
			$scope.alunos = response.data;
			console.log(response.data);
			console.log(response.status);
		}, function erro(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.add = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/alunos',
			data : $scope.aluno
		}).then(function sucesso(response) {
			$scope.carregar();
			// $scope.alunos.push(response.data);
			console.log(response.data);
			console.log(response.status);
		}, function erro(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.excluir = function(a) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/alunos/' + a.id
		}).then(function sucesso(response) {
			// var pos = $scope.alunos.indexOf(a);
			// $scope.alunos.splice(pos, 1);
			$scope.carregar();
			console.log(response.data);
			console.log(response.status);
		}, function erro(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.editar = function(a) {
		$http({
			method : 'PUT',
			url : 'http://localhost:8080/alunos',
			data : $scope.aluno
		}).then(function sucesso(response) {
			$scope.carregar();
			console.log(response.data);
			console.log(response.status);
		}, function erro(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

});
