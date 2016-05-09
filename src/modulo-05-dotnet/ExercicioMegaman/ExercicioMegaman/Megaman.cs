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

        public override void Atacar(Robo robo)
        {
            if (Vida < 30) Ataque += 3;
            robo.ReceberDano(Ataque);
        }
    }
}