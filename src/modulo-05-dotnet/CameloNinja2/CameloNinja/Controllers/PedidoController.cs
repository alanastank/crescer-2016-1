using CameloNinja.Dominio;
using CameloNinja.MVC.Models;
using CameloNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CameloNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(PedidoModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var pedido = new Pedido(
                        model.DataEntrega,
                        model.NomeProduto,
                        model.Valor,
                        model.TipoPagamento,
                        model.NomeCliente,
                        model.Cidade,
                        model.Estado
                    );

                    repositorio.IncluirPedido(pedido);

                    ViewBag.MensagemSucesso = "Pedido salvo com sucesso!";
                    return View("Detalhes", pedido);
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
            }

            return View("Cadastro", model);
        }

        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }

        public ActionResult Listagem(string cliente, string produto)
        {

            var pedidos = repositorio.FiltrarPedidosPorClienteEProduto(cliente, produto);

            return View(pedidos);
        }

        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);

            ViewBag.Mensagem = "Pedido excluído com sucesso!";

            return View("Mensagem");
        }

        public ActionResult EditarPedido(int id)
        {
            repositorio.AtualizarPedido(id);
            return View("Cadastro");
        }
    }
}