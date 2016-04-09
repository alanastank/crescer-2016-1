import java.util.ArrayList;

public class Inventario {
   
    private ArrayList<Item> listaItens = new ArrayList<>();

    public Inventario() {
    }
    
    public ArrayList<Item> getListaItens(){
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
    
    public Item getItemComMaiorQuantidade(){
        int maiorQuantidade = 0;
        Item itemMaiorQuantidade = new Item(0,"");
        for(int i=0; i < listaItens.size(); i++){
            if(listaItens.get(i).getQuantidade() > maiorQuantidade){
                maiorQuantidade = listaItens.get(i).getQuantidade();
                itemMaiorQuantidade = listaItens.get(i);
            }
        }
        return itemMaiorQuantidade;
    }
    
    public void ordenarItens(){
    
    }
}