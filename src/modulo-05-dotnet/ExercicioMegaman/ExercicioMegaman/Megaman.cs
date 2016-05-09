using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Megaman : Robo
    {
        public Megaman() : base()
        {
            Ataque = 6;
        }

        public override string Nome
        {
            get
            {
                return "Megaman";
            }
        }

        protected override int Ataque
        {
            get
            {
                if (Vida < 30) return Ataque += 3;
                return base.Ataque;
            }

        }

        public override void Atacar(Robo robo)
        {
            robo.ReceberDano(Ataque);
        }
       
    }
}
