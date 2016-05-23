'use strict';

var maiorIdCavaleiroExibido = 0;


function CavaleiroIndexView(options) {
    options = options || {};
    this.errorToast = options.errorToast;
    this.successToast = options.successToast;
    this.cavaleirosUi = options.cavaleirosUi;
    this.cavaleiros = new Cavaleiros({
        urlGet: options.urlCavaleiroGet,
        urlGetById: options.urlCavaleiroGetById,
        urlPost: options.urlCavaleiroPost,
        urlDelete: options.urlCavaleiroDelete,
        urlPut: options.urlCavaleiroPut
    });
};

function notificarNovosCavaleiros(numeroNovosCavaleiros) {
    Notification.requestPermission().then(function (result) {
        console.log(result);
        if (result === 'granted') {
            var frase = numeroNovosCavaleiros === 1 ? ' cavaleiro foi adicionado!' : ' cavaleiros foram adicionados!';
            var options = {
                body: numeroNovosCavaleiros + frase,
                icon: 'http://silhouettesfree.com/television/knights-of-the-zodiac/aquarius-camus-silhouette-image.png'
            }
            new Notification('', options);
        }
    });
};

CavaleiroIndexView.prototype.render = function () {
    var self = this;

    // 1 - Carregar lista de cavaleiros na tela
    this.cavaleiros.todos()
        .then(
            function onSuccess(res) {
                res.data.forEach(function (cava) {
                    self.cavaleirosUi.append(
                        self.criarHtmlCavaleiro(cava)
                    );
                    if (cava.Id > maiorIdCavaleiroExibido) {
                        maiorIdCavaleiroExibido = cava.Id;
                    }
                });
            },
            function onError(res) {
                self.errorToast.show(res.status + ' - ' + res.statusText);
            }
        );
};

setInterval(function () {
    $.get('/Cavaleiro/Get')
        .done(function onSuccess(res) {
            var qtdNovos = 0;
            res.data.forEach(function (cava) {
                if (cava.Id > maiorIdCavaleiroExibido) {
                    $('#cavaleiros').append(CavaleiroIndexView.prototype.criarHtmlCavaleiro(cava));
                    maiorIdCavaleiroExibido = cava.Id;
                    qtdNovos++;
                }
            })
            if (qtdNovos != 0) { notificarNovosCavaleiros(qtdNovos); }
        });
}, 5000);

CavaleiroIndexView.prototype.criarHtmlCavaleiro = function (cava) {
    var $img = $('<img>').attr('src', obterThumb(cava));
    return $('<li>')
        .append($img).append('<br>')
        .append(cava.Nome).append('<br>')
        .append(
            $('<button>').addClass('btn btn-default')
                .on('click', { id: cava.Id, self: this }, this.editarCavaleiroNoServidor)
                .text('Editar')
        )
        .append(
            $('<button>').addClass('btn btn-default')
                .on('click', { id: cava.Id, self: this }, this.excluirCavaleiroNoServidor)
                .text('Excluir')
        );
};

function obterThumb(cava) {
   var imagemThumb = cava.Imagens.filter(function (i) {
        return i.IsThumb;
   })[0];
   return imagemThumb.Url;
};

CavaleiroIndexView.prototype.excluirCavaleiroNoServidor = function (e) {
    var self = e.data.self;
    self.cavaleiros.excluir(e.data.id)
        .done(function (res) {
            self.successToast.show('Excluído com sucesso!');
        });
    $(this).parent('li').remove();
};

CavaleiroIndexView.prototype.editarCavaleiroNoServidor = function (e) {
    var cavaleiroId = e.data.id;
    var self = e.data.self;
    self.cavaleiros.buscar(cavaleiroId)
        .done(function (detalhe) {
            cavaleiroHardCoded = detalhe.data;
            simularAtualizacaoHardCoded();
            self.cavaleiros.editar(cavaleiroHardCoded)
                .done(function (res) {
                    self.successToast.show('Cavaleiro atualizado com sucesso!');
                });
        });
};

function simularAtualizacaoHardCoded() {
    cavaleiroHardCoded.Nome = 'Novo nome após update ' + new Date().getTime();
    cavaleiroHardCoded.AlturaCm = 205;
    cavaleiroHardCoded.Signo = 3;
    cavaleiroHardCoded.TipoSanguineo = 2;
    cavaleiroHardCoded.DataNascimento = new Date(Date.UTC(2010, 9, 10)).toISOString();
    if (cavaleiroHardCoded.Golpes.length > 0) {
        cavaleiroHardCoded.Golpes[0] = cavaleiroHardCoded.Golpes[0] || {};
        cavaleiroHardCoded.Golpes[0].Nome = 'Voadora do Sub-Zero Brasileiro'
        cavaleiroHardCoded.Golpes[1] = cavaleiroHardCoded.Golpes[1] || {};
        cavaleiroHardCoded.Golpes[1].Nome = 'Cólera dos 42 dragões';
        cavaleiroHardCoded.Golpes[2] = { Nome: 'Novo golpe aterrador' };
    }
    cavaleiroHardCoded.LocalNascimento.Texto = 'Porto Alegre';
    cavaleiroHardCoded.LocalTreinamento.Texto = 'Alvorada';
    if (cavaleiroHardCoded.Imagens.length > 0) {
        cavaleiroHardCoded.Imagens[0] = cavaleiroHardCoded.Imagens[0] || {};
        cavaleiroHardCoded.Imagens[0].Url = 'https://cloud.githubusercontent.com/assets/526075/15443404/5c97dde6-1ebe-11e6-8ae6-83372051dda7.png';
        cavaleiroHardCoded.Imagens[0].IsThumb = true;
        cavaleiroHardCoded.Imagens[1] = cavaleiroHardCoded.Imagens[1] || {};
        cavaleiroHardCoded.Imagens[1].Url = 'https://cloud.githubusercontent.com/assets/526075/15443410/6e9ba586-1ebe-11e6-8b90-64aca9e18a32.png';
        cavaleiroHardCoded.Imagens[1].IsThumb = false;
    }
};