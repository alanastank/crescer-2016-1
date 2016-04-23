import java.util.ArrayList;
import java.util.*;

/*Crie mais um exército de Elfos que utiliza outra estratégia de ataque:
  Somente elfos vivos atacarão. Primeiro sempre atacam os Elfos Verdes. Elfos Noturnos atacam por último.
  Cada Elfo vai atacar todos os Dwarves da Horda. */
  
public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque {
    ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
     public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
    
     private void ordenarAtaque(ArrayList<Elfo> elfos) {
        Collections.sort(elfos, new Comparator<Elfo>() {
            public int compare(Elfo elfoAtual, Elfo proximoElfo) {
                if (elfoAtual.getClass() == proximoElfo.getClass()) {
                    return 0;
                }
                return elfoAtual instanceof ElfoVerde && proximoElfo instanceof ElfoNoturno ? -1 : 1;
            }
        });
    }
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
       ordenarAtaque(elfos);
       for(Elfo elfo : elfos){
           if (elfo.getStatus() == Status.VIVO) {
               for(Dwarf dwarf : dwarves){
                   elfo.atirarFlecha(dwarf);
               } 
           }
           ordemDoUltimoAtaque.add(elfo);
       }
    }  
}
