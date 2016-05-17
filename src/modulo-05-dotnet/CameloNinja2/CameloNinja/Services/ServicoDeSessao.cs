using CameloNinja.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace CameloNinja.MVC.Services
{
    public static class ServicoDeSessao
    {
        private const string COOKIE_AUTENTICACAO = "COOKIE_AUTENTICACAO";
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        private static Dictionary<string, string> _usuariosLogados = new Dictionary<string, string>();

        public static UsuarioLogadoModel UsuarioLogado
        {
            get
            {
                return (UsuarioLogadoModel)HttpContext.Current.Session[USUARIO_LOGADO];
            }
        }

        // Esta propriedade nos informa se o usuário está logado ou não.
        // Para isso, ele verifica se existe o cookie de autenticação e se o mesmo ainda existe na lista acima.
        // Repare também que ele verifica se a sessão do usuário também está ativa.
        // IMPORTANTE: você deve estar se perguntando porque verificamos o cookie, se somente a sessão deve bastar...
        // Bem, você pode ter sessão sem o usuário estar autenticado. Lembra que eu posso ter um carrinho de compras
        // em uma loja virtual sem estar logado...       
        public static bool EstaLogado
        {
            get
            {
                if (UsuarioLogado != null)
                {
                    HttpCookie cookieDeAutenticacao = HttpContext.Current.Request.Cookies.Get(COOKIE_AUTENTICACAO);

                    bool cookieEstaOk = _usuariosLogados.Any(
                            u => u.Key.Equals(cookieDeAutenticacao.Value)
                            && u.Value.Equals(UsuarioLogado.Email)
                        );

                    return cookieEstaOk;
                }

                return false;
            }
        }

        // Aqui encapsulamos a lógica para criar a sessão para o usuário.
        public static void CriarSessao(UsuarioLogadoModel usuario)
        {
            // Um Guid gera um hash aleatório.
            string numeroToken = Guid.NewGuid().ToString();
            _usuariosLogados.Add(numeroToken, usuario.Email);

            HttpContext.Current.Session[USUARIO_LOGADO] = usuario;
            var cookieDeAutenticacao = new HttpCookie(COOKIE_AUTENTICACAO, numeroToken);

            HttpContext.Current.Response.Cookies.Set(cookieDeAutenticacao);
        }
    }
}