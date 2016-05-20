$(function() {
'use strict';

var base = 'https://api.spotify.com/v1/';
var $campoBusca = $('#txtArtista');
var $btnPesquisar = $('#frmBuscaArtista button');
var $capasAlbuns = $('#capasAlbuns');

if($capasAlbuns.length){
  $.ajax({ url: base + 'artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50', type: 'GET' })
   .done(function (res) {
     exibirCapasDosAlbuns($capasAlbuns, res.items);
  });
};

$btnPesquisar.click(buscarArtista);

function buscarArtista() {
  buscarAlbunsDoArtistaPorNome($campoBusca.val(), exibirCapasDosAlbuns);
};

function douchebag(nomeArtista){
  if(nomeArtista.toLowerCase() === 'justin bieber'){
    var chance = Math.floor((Math.random() * 10)+1);
    console.log(chance);

    return chance > 2;
  }
}

function buscarAlbunsDoArtistaPorNome(nomeArtista, callback) {
    $.ajax({
        url: base + 'search',
        data: {
            q: nomeArtista,
            type: 'artist'
        },
        success: function (result) {
          var id = douchebag(nomeArtista) ? 'douchebag' : result.artists.items[0].id;
          buscarAlbunsDoArtistaPorID(id, callback);
        }
    });
};

function buscarAlbunsDoArtistaPorID(id, callback) {
    $.ajax({
        url: base + 'artists/' + id + '/albums',
        success: function (result) {
            callback($('#resultados'), result.items);
        },
        error: function(result){
          var code = result.status;
          if (code === 400) {
            $('#resultados').html('');
            alert('Caro usuário, devido a um erro ' + code + ', não foi possível pesquisar por ' + $campoBusca.val());
          }
        }
    });
};

function exibirCapasDosAlbuns(div, albuns) {
    div.html('');
    albuns.forEach(function (item) {
        div.append(
          $('<li>').append(
            $('<img>').attr('src', item.images[1].url)
          )
        );
    });
};

});
