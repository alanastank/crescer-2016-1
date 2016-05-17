using CameloNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RepositorioVendas
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["CameloNinja"].ConnectionString;

            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM Usuarios WHERE email=@p_email and senha=@p_senha";
                Usuario usuario = new Usuario();

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                while (leitor.Read())
                {
                    usuario.Email = leitor["email"].ToString();
                    usuario.Senha = leitor["senha"].ToString();
                    usuario.Nome = leitor["nome"].ToString();
                }
                return usuario;
            }
        }
    }
}
