import java.util.ArrayList;

public class Inventario {
   
    private ArrayList<Item> listaItens = new ArrayList<>();

    public Inventario() {
    }
    
    public ArrayList getListaItens(){
        return listaItens;
    }
    
    public void adicionarItem(Item item){
        listaItens.add(item);
    }
    
    public void removerItem(Item item){
        listaItens.remove(item);
    }
}
