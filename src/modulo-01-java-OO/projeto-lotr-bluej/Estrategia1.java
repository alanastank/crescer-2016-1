import java.util.ArrayList;
import java.util.*;

/* Reúna todos os Elfos do exército e crie a possibilidade deste exército atacar uma horda de Dwarves.
Somente elfos vivos atacarão. Cada Elfo vai atacar todos os Dwarves da Horda. Elfos Noturnos podem ser usados, no máximo, em 30% das intenções de ataques.

Considere como "intenções de ataque" o número de ataques que todos Elfos farão a todos Dwarves SEM considerar o percentual de 30% dos Elfos Noturnos. 
Ex: 4 Elfos (3 Noturnos + 1 Verde) * 2 Anões = 8 intenções
8 intenções * 0.3 = 2.4 elfos noturnos podem atacar.
Só 2 noturnos (parte inteira de 2.4) podem atacar
Não crie várias listas para cada tipo de Elfos, faça bom uso do polimorfismo! */

public class Estrategia1 implements EstrategiaDeAtaque {
    ArrayList<Elfo> ordemDoUltimoAtaque;
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
        //ordemDoUltimoAtaque.clear();
        ordemDoUltimoAtaque = new ArrayList<Elfo>();
        int contadorElfosNoturnos = 0;
        int numIntencoes = elfos.size() * dwarves.size();
        int quantElfosNoturnosAtiram = (int)(numIntencoes * 0.3);
        
        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoNoturno){ 
                contadorElfosNoturnos++;
            }
            if (contadorElfosNoturnos <= quantElfosNoturnosAtiram && elfo.getStatus().equals(Status.VIVO) || elfo instanceof ElfoVerde){
                for(Dwarf dwarf : dwarves){
                    elfo.atirarFlecha(dwarf);
                }
                ordemDoUltimoAtaque.add(elfo);
            }           
        }
    }
        
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
}
