using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {        
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult Sobre()
        {
            var alana = new List<SobreMimModel>()
                {
                    new SobreMimModel()
                    {
                        Nome = "Alana",
                        Idade = 18,
                        Origem = "São Leopoldo, RS - Brasil",
                        Escolaridade = "Técnico em Informática Integrado ao Ensino Médio (IFSUL)",
                        Contato = "alanastankiewicz@gmail.com"
                    }
                };
            return View();
        }
    }
}