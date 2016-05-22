'use strict';

$(function () {

    // Adicionar campos para imagens e golpes

    $('#btnAdicionarImg').click(function () {
        $('#novasImagens').append(gerarElementoLiComInputs());
    });

    $('#btnAdicionarGolpe').click(function () {
        $('#novosGolpes').append(gerarElementoLiComInputTexto());
    });

    function gerarElementoLiComInputs() {
        var $novoTxt = $('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: bit.ly/shiryu.png').addClass('form-control');
        var $novoCheckbox =
          $('<label>').append(
            $('<input>')
            .attr('type', 'checkbox')
            .attr('name', 'isThumb')
            .attr('checked', 'checked')
          ).append('É thumbnail?');
        return $('<li>').append($novoTxt).append($novoCheckbox);
    };

    function gerarElementoLiComInputTexto() {
        var $novoTxt = $('<input>').attr('name', 'golpe').attr('type', 'text').attr('placeholder', 'Ex: Pó de diamante').addClass('form-control');
        return $('<li>').append($novoTxt);
    };

    // Adicionar datepicker

    $('#txtDtNascimento').datepicker({
        dateFormat: 'dd/mm/yy',
        changeYear: true,
        yearRange: "1900:2016"
    });

});