using CameloNinja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace CameloNinja.MVC.Models
{
    public class PedidoModel
    {
        public int? Id { get; set; }

        [Display(Name = "Data de entrega: ")]
        [Required(ErrorMessage = "Data desejada de entrega deve ser informada")]
        public DateTime DataEntrega { get; set; }

        [Required(ErrorMessage = "Nome do Produto deve ser informado")]
        [DisplayName("Nome do Produto")]
        public string NomeProduto { get; set; }

        [Required(ErrorMessage = "Valor de venda deve ser informado")]
        [DisplayName("Valor de Venda")]
        [DisplayFormat(DataFormatString = "{0:c}", ApplyFormatInEditMode = true)]
        public decimal Valor { get; set; }

        [Required]
        [DisplayName("Tipo de Pagamento")]
        public TipoPagamento TipoPagamento { get; set; }

        [Required(ErrorMessage = "Nome do Cliente deve ser informado")]
        [DisplayName("Nome do Cliente")]
        public string NomeCliente { get; set; }

        [Required(ErrorMessage = "Cidade deve ser informada")]
        public string Cidade { get; set; }

        [Required(ErrorMessage = "Estado deve ser informado")]
        public string Estado { get; set; }
    }
}