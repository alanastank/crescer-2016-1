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
