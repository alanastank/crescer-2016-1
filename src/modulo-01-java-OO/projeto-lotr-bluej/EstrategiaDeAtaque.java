import java.util.ArrayList;

public interface EstrategiaDeAtaque {
  
    public ArrayList<Elfo> getOrdemDoUltimoAtaque();
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves);
    
}
