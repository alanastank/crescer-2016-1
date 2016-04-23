import java.util.ArrayList;

public class Inventario {
   
    private ArrayList<Item> listaItens = new ArrayList<>();
    
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
       
    // Odena um arrayList comparando posições de dois a dois. Caso a quantidade de uma posição n seja maior que a de n+1, os itens trocam de lugar e assim sucessivamente.  
    public void ordenarItens(){ 
        Item auxiliaTroca;
        for(int i=0; i < listaItens.size(); i++){
            for(int j = 0; j < listaItens.size() - 1; j++){
                Item itemAtual = listaItens.get(j);
                Item proximoItem = listaItens.get(j+1);
                if(itemAtual.getQuantidade() > proximoItem.getQuantidade()){
                    auxiliaTroca = itemAtual; // associa o primeiro item a variavel auxiliar
                    listaItens.set(j, proximoItem); // associa o segundo item a primeira posição
                    listaItens.set(j + 1, auxiliaTroca); // associa o primeiro item (auxiliaTroca) a segunda posição
                } 
            }        
        }
    }
}