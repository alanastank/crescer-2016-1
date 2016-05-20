'use strict';

var urlApiSpotifyIronMaiden = 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50';

$(function() {

$.ajax({ url: urlApiSpotifyIronMaiden, type: 'GET' })
.done(function (res) {
  var $capasAlbuns = $('#capasAlbuns');
  res.items.forEach(function (item) {
    $capasAlbuns.append(
      $('<li>').append(
        $('<img>').attr('src', item.images[1].url)
      )
    );
  });
});

var $frmBuscaArtista = $('#frmBuscaArtista');
$frmBuscaArtista.click(function() {
  var $nomeArtista = $('#txtArtista').val();
  buscarAlbunsDoArtistaPorNome($nomeArtista, buscarCapasDosAlbuns);
});

var buscarAlbunsDoArtistaPorNome = function (nomeArtista, fn) {
    $.ajax({
        url: 'https://api.spotify.com/v1/search',
        data: {
            q: nomeArtista,
            type: 'album'
        },
        success: function (result) {
            fn(result.albums);
        }
    });
};

var buscarCapasDosAlbuns = function (albuns) {
    var $resultados = $('#resultados');
    albuns.items.forEach(function (item) {
        $resultados.append(
          $('<li>').append(
            $('<img>').attr('src', item.images[1].url)
          )
        );
    });
};

});
