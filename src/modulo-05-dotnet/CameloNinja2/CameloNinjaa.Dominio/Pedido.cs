using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace CameloNinja.Dominio
{
    public class Pedido
    {
        /// <summary>
        /// Construtor utilizado para montar pedidos novos
        /// </summary>
        public Pedido(DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado)
        {
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = DateTime.Now;

            var diasRestantesParaConcluirEntrega = (dataEntregaDesejada - DateTime.Today).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);
        }

        /// <summary>
        /// Construtor utilizado para montar pedidos recuperados do repositório
        /// </summary>
        public Pedido(int id, DateTime dataPedido, DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, bool pedidoUrgente)
        {
            Id = id;
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = dataPedido;
            PedidoUrgente = pedidoUrgente;
        }

        public int Id { get; private set; }

        [Display(Name = "Data do pedido")]
        public DateTime DataPedido { get; private set; }

        [Display(Name = "Data de entrega desejada")]
        public DateTime DataEntregaDesejada { get; private set; }

        [Display(Name = "Nome do Produto")]
        public string NomeProduto { get; private set; }
   
        public decimal Valor { get; private set; }

        [Display(Name = "Tipo de Pagamento")]
        public TipoPagamento TipoPagamento { get; private set; }

        [Display(Name = "Nome do cliente")]
        public string NomeCliente { get; private set; }

        public string Cidade { get; private set; }
        public string Estado { get; private set; }

        [Display(Name = "Pedido Urgente")]
        public bool PedidoUrgente { get; private set; }

        private void ValidaPossibilidadeEntrega(double diasRestantesParaConcluirEntrega)
        {
            if (diasRestantesParaConcluirEntrega < 1)
                throw new ArgumentException("A data de entrega desejada deve ser no mínimo 1 dia maior do que a data atual.");
        }

        private void DefineUrgenciaDoPedido(double diasRestantesParaConcluirEntrega)
        {
            PedidoUrgente = diasRestantesParaConcluirEntrega < 7;
        }

        public void AtualizarId(int id)
        {
            if (Id != 0)
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");

            Id = id;
        }
    }
}