import java.util.ArrayList;
import java.util.*;

/*Crie mais um exército de Elfos que utiliza outra estratégia de ataque:
  Somente elfos vivos atacarão. Primeiro sempre atacam os Elfos Verdes. Elfos Noturnos atacam por último.
  Cada Elfo vai atacar todos os Dwarves da Horda. */
  
public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque {
    ArrayList<Elfo> ordemDoUltimoAtaque;
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
        //ordemDoUltimoAtaque.clear();
        ordemDoUltimoAtaque = new ArrayList<Elfo>();
        ArrayList<Elfo> elfosNoturnos = new ArrayList<Elfo>();
        int contadorElfosNoturnos = 0;
        
        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoVerde){ 
                for(Dwarf dwarf : dwarves){
                    elfo.atirarFlecha(dwarf);
                } 
                ordemDoUltimoAtaque.add(elfo); 
            } else {
                elfosNoturnos.add(elfo);
            }    
        }
        
        for(Elfo elfo : elfosNoturnos){
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
            } 
            ordemDoUltimoAtaque.add(elfo); 
        } 
    }
        
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
   
}
