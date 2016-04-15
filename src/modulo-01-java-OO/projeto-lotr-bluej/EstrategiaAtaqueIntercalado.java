import java.util.ArrayList;
import java.util.*;

/*Crie mais um exército de Elfos que utiliza outra estratégia de ataque:
Somente elfos vivos atacarão e, para facilitar a vida do general, a composição do pelotão de ataque deve ter obrigatoriamente 50% de Elfos Verdes e 50% de Elfos Noturnos.
Os ataques ocorrem de forma intercalada e contínua entre os tipos de elfos. Se um Elfo Verde começa atacando, o próximo ataque deve ser feito por um Elfo Noturno.
Se um Elfo Noturno começa atacando, o próximo ataque deve ser feito por um Elfo Verde. Cada Elfo vai atacar todos os Dwarves da Horda.*/

public class EstrategiaAtaqueIntercalado implements EstrategiaDeAtaque {
    ArrayList<Elfo> ordemDoUltimoAtaque;
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque = new ArrayList<Elfo>();
        ArrayList<Elfo> elfosVerdes = new ArrayList<>();
        ArrayList<Elfo> elfosNoturnos = new ArrayList<>();
        
        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoNoturno && elfo.getStatus().equals(Status.VIVO)){ 
                elfosNoturnos.add(elfo);
            } 
            if(elfo instanceof ElfoVerde && elfo.getStatus().equals(Status.VIVO)){ 
                elfosVerdes.add(elfo);
            }
        }   
            
        if(elfosVerdes.size() == elfosNoturnos.size()){           
            for(int i=0; i < elfosVerdes.size(); i++){
                for(Dwarf dwarf : dwarves){
                    elfosVerdes.get(i).atirarFlecha(dwarf);
                    elfosNoturnos.get(i).atirarFlecha(dwarf);  
                }
                ordemDoUltimoAtaque.add(elfosVerdes.get(i));
                ordemDoUltimoAtaque.add(elfosNoturnos.get(i));                    
            }           
        } else{
            ordemDoUltimoAtaque = null;
        }
    }
        
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
}
