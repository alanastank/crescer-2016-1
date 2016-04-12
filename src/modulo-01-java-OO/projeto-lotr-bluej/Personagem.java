public abstract class Personagem {
    protected String nome;
    protected int experiencia;
    protected Inventario inventario;

    public Personagem(String nome) {
        this.nome = nome;
        this.inventario = new Inventario(); 
        this.experiencia = 0;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
     public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.inventario.removerItem(item);
    }
}
