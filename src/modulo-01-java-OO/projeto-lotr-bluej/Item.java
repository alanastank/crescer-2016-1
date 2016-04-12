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
        return this.descricao;
    }
    
    public boolean equals(Object obj){
        Item outro = (Item)obj;
        return this.quantidade == outro.getQuantidade()
            && this.descricao != null
            && outro != null
            && this.descricao.equals(outro.getDescricao());
    }
    
    public void aumentar1000Unidades() {
        this.quantidade += 1000;
    }
    
    public void aumentarProporcionalQuantidade() {
        int resultado = this.quantidade * (this.quantidade + 1) / 2;
        this.quantidade += (resultado * 1000);
    }
}
