'use strict';

describe('Ex 1. Doadores de sangue', function() {
  it('retorna elfos de id 5, 9 e 12', function() {
    expect(obterDoadores()).toEqual([goldSaints[4], goldSaints[8], goldSaints[11]]);
  });
});

describe('Ex 2. Canivete suíço', function() {
  it('retorna elfos de id 6', function() {
    expect(obterCavaleiroComMaisGolpes()).toEqual(goldSaints[5]);
  });
});

describe('Ex 4. Altura média', function() {
  it('retorna 1.85', function() {
    expect(obterAlturaMedia()).toEqual(1.85);
  });
});

describe('Ex 5. Altura mediana', function() {
  it('retorna 1.85', function() {
    expect(obterAlturaMediana()).toEqual(1.85);
  });
});

describe('Ex 6A. Peso médio', function() {
  it('retorna 84.27', function() {
    expect(obterPesoMedio()).toEqual(84.27);
  });
});

describe('Ex 6B. Peso médio dos doadores', function() {
  it('retorna 80.67', function() {
    expect(obterPesoMedioDoadores()).toEqual(80.67);
  });
});

describe('Ex 7. IMC', function() {
  it('retorna [22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45, 21.5]', function() {
    expect(obterIMC()).toEqual([22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45, 21.5]);
  });
});

// está errado, tem que arrumar
describe('Ex 8. Sobrepeso', function() {
  it('retorna cavaleiro de id 2', function() {
    expect(obterSobrepeso()).toEqual(goldSaints[1]);
  });
});
