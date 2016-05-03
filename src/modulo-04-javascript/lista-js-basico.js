'use strict';

/* 1 - Faça uma função chamada daisyGame que receba por argumento o número de pétalas da margarida e retorne
'Love me' ou 'Love me not' (Lembre do jogo "Bem me quer, mal me quer"). Exemplo:
daisyGame(4); => 'Love me not' */

function daisyGame(numPetalas){
  return numPetalas % 2 === 0 ? 'Love me not' : 'Love me';
}

/* 2 - Faça uma função chamada maiorTexto que receba um array de strings e retorne o texto com maior número de caracteres.*/

function maiorTexto (valores){
  var maiorString = '';

  for (var i=0; i<valores.length; i++){
    if(valores[i].length > maiorString.length){
      maiorString = valores[i];
    }
  }
  return maiorString;
}

/* 3 - Faça uma função chamada imprime que receba dois parâmetros: Um array de strings (['bernardo', 'nunes', 'fabrício', 'ben-hur', 'carlos'])
e uma função. Dentro da função imprime chame a função do segundo parâmetro para cada elemento do array.
Retorno: 'olá querido instrutor:' + instrutor */

function verificaFuncao(fn) {
  return typeof fn === 'function';
}

function concatenaFraseInstrutor (nomeInstrutor){
  console.log('olá querido instrutor:' + nomeInstrutor);
}

function imprime(listaInstrutores, concatenaFraseInstrutor) {
  for(var i=0; i<listaInstrutores.length; i++){
    if(verificaFuncao(concatenaFraseInstrutor)){
      concatenaFraseInstrutor(listaInstrutores[i]);
    }
  }
}

/* 4 - Escreva uma função somar que permite somar dois números através de duas chamadas diferentes (não necessariamente pra mesma função).*/

function somar(valor1){
  return function somar2(valor2){
    return valor1 + valor2;
  };
}

/* 5 - Faça uma função fiboSum que calcule a soma da sequência de Fibonacci para n números informados. Exemplo de chamada:
fiboSum(7); => 33 (soma dos 7 primeiros números da sequência: 1+1+2+3+5+8+13) */

function fiboSum(valor){
  var sequencia = [0, 1];
  var proximoValor;
  var soma = 1;

  for (var i=2; i<=valor; i++){
    proximoValor = sequencia[i-1] + sequencia[i-2];
    sequencia.push(proximoValor);
    soma += proximoValor;
  }
  console.log('Sequência: ' + sequencia,'\nSoma: ' + soma);
}

/* 6 - Escreva uma função queroCafe que recebe dois parâmetros: mascada (Valor numérico) e precos (Lista de preços de café)
A sua implementação deve retornar uma string com todos os preços que estão abaixo ou igual ao valor mascada ordenados de
forma ascendente e separados por ,. Ex: queroCafe(3.14, [ 5.16, 2.12, 1.15, 3.11, 17.5 ]); // '1.15,2.12,3.11'*/

function queroCafe (mascada, precos){
  var precoAbaixoOuIgualMascada = [];
  for (var i = 0; i < precos.length; i++) {
    if(precos[i] <= mascada){
      precoAbaixoOuIgualMascada.push(precos[i]);
    }
  }
  return precoAbaixoOuIgualMascada.sort().join(', ');
}

/* 7 - Implemente uma função contarPorTipo que recebe dois argumentos:
um objeto que pode ter várias propriedades, de vários tipos diferentes e uma string com os seguintes possíveis valores:
'string', 'number', 'boolean', 'object', 'undefined', 'null', 'function', 'array'
A função deve contar quantas propriedades dentro do objeto informado no primeiro parâmetro são do tipo do segundo parâmetro.*/

function contarPorTipo (obj, stringTipo){
  var soma = 0;
  for (var i in obj) {
    if (Array.isArray(obj[i]) && stringTipo === 'array'){
      soma++;
    }
    else if (obj[i] === null && stringTipo === 'null'){
      soma++;
    }
    else if (typeof obj[i] === stringTipo) {
      soma++;
    }
  }
  return soma;
}

/* 8 - Analise o código abaixo e coloque um comentário no seu arquivo JS explicando o resultado. */

var gohan = 'gohan', goku = 'Goku'; // declara variáveis no escopo global

function revelarSaiyaman() {
  // var gohan; => Hoisting: em tempo de execução, todas as variáveis e declarações de funções são movidas para o início de cada função
  console.log(gohan); // imprime undefined
  goku = 'Son Goku'; // sobrescreve goku, declarado no escopo global como 'Son Goku'
  var gohan = 'Son ' + gohan; // declara uma variável gohan, de escopo local, que sobrescreve a variável gohan declarada no escopo global
  return gohan; // retorna 'Son undefined', uma vez que '+ gohan' na expressão aponta pra uma variável não atribuida anteriormente e que possui, portanto, valor 'undefined'
}

console.log(revelarSaiyaman()); // imprime 'Son undefined', que é o retorno da função revelarSaiyaman()
console.log(goku); // imprime 'Son Goku', que é o valor atribuido à variável no escopo local
