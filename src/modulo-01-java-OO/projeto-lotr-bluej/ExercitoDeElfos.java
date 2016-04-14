import java.util.*;

public class ExercitoDeElfos {
    
    private Elfo elfo;
    private HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();
   
    public void alistarElfo(Elfo elfo) {
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercitoDeElfos.put(elfo.getNome(), elfo);
        }
    }    
    
    public HashMap getExercitoDeElfos(){
       return exercitoDeElfos; 
    }
    
    public Elfo buscarElfo(String nome){
        if(exercitoDeElfos.containsKey(nome)){
            elfo = exercitoDeElfos.get(nome);
        }
        return elfo;
    }
    
}