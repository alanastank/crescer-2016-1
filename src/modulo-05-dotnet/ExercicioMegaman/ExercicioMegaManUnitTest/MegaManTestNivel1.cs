using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMegaman;

namespace MegaManUnitTest
{
    [TestClass]
    public class MegaManTestNivel1
    {
        [TestMethod]
        public void seMegamanTemAtaqueInicialIgualA6()
        {
            // Arrange
            var megaman = new Megaman();
            var bot = new Bot();
            // Act
            megaman.Atacar(bot);
            // Assert
            Assert.AreEqual(94, bot.Vida);
        }

        [TestMethod]
        public void seProtomanTemDefesaIgualA2()
        {
            // Arrange
            var protoman = new Protoman();
            var megaman = new Megaman();
            // Act
            megaman.Atacar(protoman);
            // Assert
            Assert.AreEqual(96, protoman.Vida);
        }

        [TestMethod]
        public void seAoChamarOMetodoToStringRetornaCorretamente()
        {
            // Arrange
            var bot = new Bot();
            var esperado = "Nome: Bot, Vida: 100, Ataque: 5, Defesa: 0";
            // Assert
            Assert.AreEqual(esperado, bot.ToString());
        }

        [TestMethod]
        public void seProtomanFicaCom20DeVidaECom7DeAtaqueAoMorrerPelaPrimeiraVez()
        {
            // Arrange
            var protoman = new Protoman();
            var esperado = "Nome: Protoman, Vida: 20, Ataque: 7, Defesa: 2";
            // Act
            protoman.ReceberDano(102);
            // Assert
            Assert.AreEqual(esperado, protoman.ToString());
        }

        [TestMethod]
        public void seProtomanFicaCom0DeVidaAoMorrerPelaSegundaVez()
        {
            // Arrange
            var protoman = new Protoman();
            // Act
            protoman.ReceberDano(102);
            // Matar protoman pela segunda vez.
            protoman.ReceberDano(22);
            // Assert
            Assert.AreEqual(0, protoman.Vida);
        }

        [TestMethod]
        public void seOAtaqueDoMegamanEh9QuandoSuaVidaEhMenorQue30()
        {
            // Arrange
            var megaman = new Megaman();
            var bot = new Bot();
            // Act

            megaman.ReceberDano(71);
            megaman.Atacar(bot);
            // Assert
            Assert.AreEqual(91, bot.Vida);
        }
    }
}