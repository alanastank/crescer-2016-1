using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public abstract class Robo
    {
        public abstract string Nome { get; }
        public int Vida { get; protected set; }
        protected virtual int Ataque { get; set; }
        protected int Defesa { get; set; }

        public Robo()
        {
            Vida = 100;
            Ataque = 5;
            Defesa = 0;
        }

        public virtual void Atacar(Robo robo) {
            robo.ReceberDano(Ataque);
        }

        public virtual void ReceberDano(int Ataque)
        {
            int dano = Ataque - Defesa;
            if (dano > 0)
            {
                Vida -= dano;
            }
        } 

        public override string ToString()
        {
            return "Nome: " + Nome + ", Vida: " + Vida + ", Ataque: " + Ataque + ", Defesa: " + Defesa;
        }
    }
}
