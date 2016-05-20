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
$campoBusca.keypress(buscarArtista);

function buscarArtista() {
  buscarAlbunsDoArtistaPorNome($campoBusca.val(), exibirCapasDosAlbuns);
};

function buscarAlbunsDoArtistaPorNome(nomeArtista, callback) {
    $.ajax({
        url: base + 'search',
        data: {
            q: nomeArtista,
            type: 'artist'
        },
        success: function (result) {
            buscarAlbunsDoArtistaPorID(result.artists.items[0].id, callback);
        }
    });
};

function buscarAlbunsDoArtistaPorID(id, callback) {
    $.ajax({
        url: base + 'artists/' + id + '/albums',
        success: function (result) {
            callback($('#resultados'), result.items);
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
