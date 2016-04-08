public class Item {
    private int quantidade;
    private String descricao;

    public Item(int quantidade, String descricao) {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int novaQuantidade){
        this.quantidade = novaQuantidade;
    }
    
    public String getDescricao(){
        return descricao;
    }
}
