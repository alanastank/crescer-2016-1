﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CameloNinja.Dominio
{
    public class Pedido
    {

        public int Id { get; private set; }
        public DateTime DataPedido { get; private set; }
        public DateTime DataEntregaDesejada { get; private set; }
        public string NomeProduto { get; private set; }
        public decimal Valor { get; private set; }
        public TipoPagamento TipoPagamento { get; private set; }
        public string NomeCliente { get; private set; }
        public string Cidade { get; private set; }
        public string Estado { get; private set; }
        public bool PedidoUrgente { get; private set; }

        /// Construtor utilizado para montar pedidos novos
        public Pedido(DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado)
        {
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = DateTime.Today;
            var diasRestantesParaConcluirEntrega = (dataEntregaDesejada - DataPedido).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);
        }

        /// Construtor utilizado para montar pedidos recuperados do repositório
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

        private void ValidaPossibilidadeEntrega(double diasRestantesParaConcluirEntrega)
        {
            if (diasRestantesParaConcluirEntrega < 1)
                throw new ArgumentException("A data de entrega desejada deve ser no mínimo 1 dia maior do que a data atual.");
        }

        private void DefineUrgenciaDoPedido(double diasRestantesParaConcluirEntrega)
        {
            PedidoUrgente = diasRestantesParaConcluirEntrega < 7;
        }
    }
}