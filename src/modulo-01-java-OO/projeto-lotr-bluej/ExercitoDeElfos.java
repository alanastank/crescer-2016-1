import java.util.*;

public class ExercitoDeElfos {
    
    private Elfo elfo;
    private HashMap<String, Elfo> exercitoDeElfos = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoDeElfosAgrupado = new HashMap<>();
    private ArrayList<Elfo> elfosMortos, elfosVivos;
   
    public void alistarElfo(Elfo elfo) {
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            exercitoDeElfos.put(elfo.getNome(), elfo);
        }
    }    
    
    public HashMap getExercitoDeElfos(){
       return this.exercitoDeElfos; 
    }
    
    public HashMap getExercitoDeElfosAgrupado(){
       return this.exercitoDeElfosAgrupado; 
    }
    
    public Elfo buscarElfo(String nome){
            return exercitoDeElfos.get(nome);
    }
    
    public void agruparPorStatus(){
        elfosMortos = new ArrayList();
        elfosVivos = new ArrayList();
        for (Map.Entry<String, Elfo> chaveValor : exercitoDeElfos.entrySet()){ //percorre cada par
          if(chaveValor.getValue().getStatus() == Status.VIVO) {
              elfosVivos.add(chaveValor.getValue());
          } else {
              elfosMortos.add(chaveValor.getValue());
          }
        }
        exercitoDeElfosAgrupado.put(Status.VIVO, elfosVivos);
        exercitoDeElfosAgrupado.put(Status.MORTO, elfosMortos);
    } 
    
    public boolean elfoEstaNaListaDoStatusPassado(Status status, Elfo elfo){
        return exercitoDeElfosAgrupado.get(status).contains(elfo);
    }
    
    ArrayList<Elfo> buscarElfosPorStatus(Status status){
        return exercitoDeElfosAgrupado.get(status);
    }
}
