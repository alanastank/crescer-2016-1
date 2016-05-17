using CameloNinja.Dominio;
using CameloNinja.MVC.Filters;
using CameloNinja.MVC.Models;
using CameloNinja.MVC.Services;
using RepositorioVendas;
using System.Web.Mvc;

namespace CameloNinja.MVC.Controllers
{
    public class LoginController : Controller
    {
        private UsuarioServico _usuarioServico;

        public LoginController()
        {
            _usuarioServico = new UsuarioServico(
                    new UsuarioRepositorioADO()
                );
        }

        [HttpGet]
        public ActionResult Index()
        {
            if (!ServicoDeSessao.EstaLogado)
            {
                return View();
            }

            return RedirectToAction("AreaSecreta");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginViewModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("AreaSecreta");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", loginViewModel);
        }

        [HttpGet]
        [CameloNinjaToken]
        public ActionResult AreaSecreta()
        {
            UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            return View();
        }

        [HttpGet]
        [CameloNinjaToken(Roles = "GOLD")]
        public ActionResult AreaSuuuperSecreta()
        {
            return View();
        }
    }
}