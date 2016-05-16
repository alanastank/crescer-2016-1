using CameloNinja.Dominio;
using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CameloNinja.Repositorio
{
    public class RepositorioVendas
    {
        private const string PATH_ARQUIVO = @"C:\Users\Anny\Documents\CrescerCWI\MeuRepositorio\src\modulo-05-dotnet\CameloNinja\CameloNinja\Content\vendas.txt";
        private static readonly object objetoLock = new object();

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();

            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            lock (objetoLock)
            {
                var utlimoId = this.ObterPedidos().Max(x => x.Id);
                var idGerado = utlimoId + 1;
                var novaLinha = ConvertePedidoEmLinhaCSV(pedido, idGerado);
        
                File.AppendAllText(PATH_ARQUIVO, novaLinha);
                pedido.AtualizarId(idGerado);
            }
        }

        private string ConvertePedidoEmLinhaCSV(Pedido pedido, int proximoId)
        {
            return string.Format(Environment.NewLine + "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}",
                                proximoId,
                                pedido.DataPedido.ToString("dd/MM/yyyy HH:mm"),
                                pedido.DataEntregaDesejada.ToString("dd/MM/yyyy HH:mm"),
                                pedido.NomeProduto,
                                pedido.Valor,
                                pedido.TipoPagamento,
                                pedido.NomeCliente,
                                pedido.Cidade,
                                pedido.Estado,
                                pedido.PedidoUrgente);
        }

        public void AtualizarPedido(int id)
        {
           //var linhaEditar = File.ReadAllLines(PATH_ARQUIVO).Where(linha => linha.Split(';').First() == id.ToString());
           //linhaEditar = IncluirPedido();
           //File.WriteAllLines(PATH_ARQUIVO, arrLine);
        }

        /*stackoverflow.com/questions/668907/how-to-delete-a-line-from-a-text-file-in-c*/
        public void ExcluirPedido(int id)
        {
            var linesToKeep = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).Where(linha => linha.Split(';').First() != id.ToString());
            File.WriteAllLines(PATH_ARQUIVO, linesToKeep);
        }

        public List<Pedido> FiltrarPedidosPorClienteEProduto(string cliente, string produto)
        {
            var pedidos = this.ObterPedidos();

            if (!String.IsNullOrWhiteSpace(cliente))
                pedidos = pedidos.Where(pedido => pedido.NomeCliente.ToLower().Contains(cliente.ToLower())).ToList();
            if (!String.IsNullOrWhiteSpace(produto))
                pedidos = pedidos.Where(pedido => pedido.NomeProduto.ToLower().Equals(produto.ToLower())).ToList();
            if (String.IsNullOrWhiteSpace(cliente) && String.IsNullOrWhiteSpace(produto))
                return pedidos;

            return pedidos;
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }

            return listaPedidos;
        }
    }
}
