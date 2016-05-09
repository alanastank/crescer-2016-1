using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Protoman : Robo
    {
        public Protoman() : base()
        {
            Defesa = 2;
        }

        public override string Nome
        {
            get
            {
                return "Protoman";
            }
        }

        Boolean JaMorreuUmaVez { get; set; }

        protected override int Ataque
        {
            get
            {
                if (JaMorreuUmaVez) return 7;
                return base.Ataque;
            }

        }

        public override void ReceberDano(int Ataque)
        {
            base.ReceberDano(Ataque);
            if (Vida <= 0 && JaMorreuUmaVez == false)
            {
                JaMorreuUmaVez = true;
                Vida = 20;
            }
        }

    }
}
