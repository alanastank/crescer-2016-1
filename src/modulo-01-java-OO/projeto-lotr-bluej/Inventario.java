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
    
    public String getDescricoesItens(){
        String descricao = "";
        for(int i=0; i < listaItens.size(); i++){
           if(listaItens.size() - 1 != i){
               descricao += listaItens.get(i).getDescricao() + ",";
           } else {
               descricao += listaItens.get(i).getDescricao();
           }
        }

        return descricao;
    }
}
