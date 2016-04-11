public class Elfo {   
    // Variáveis de instância
    private String nome;
    private int experiencia;
    private int numFlechas;
    protected Inventario inventarioElfo;
    
    // Construtor para objetos da classe Elfo
    public Elfo(String nome) {
        // Inicializa variáveis de instância
        this.nome = nome;
        experiencia = 0;
        numFlechas = 42;
    }
    
    public int getExperiencia() {
        return experiencia;
    }
   
     public int getNumFlechas() {
        return numFlechas;
    }

    public Inventario getInventario(){
        return inventarioElfo;
    }
    
    // Aumentar experiência e diminuir número de flechas a cada chamada de atirarFlecha().
    public void atirarFlecha() {
        experiencia++; 
        numFlechas--;
    }
    
    public String toString() {  
        return nome + " possui " + numFlechas + " flechas e " + experiencia + " níveis de experiência";  
    }  
    
    // Diminuir 10 da vida do Dwarf a cada flecha.
    public void atirarFlechaDwarf(Dwarf dwarf) {
        experiencia++;
        numFlechas--;
        dwarf.levarDano();
    }
    
    public void adicionarItemInventario(Item item){
        this.inventarioElfo.adicionarItem(item);
    }
    
    public void perderItemInventario(Item item){
        this.inventarioElfo.removerItem(item);
    }
    
    public void atirarFlechaRefactory() {   
        numFlechas--;
        experiencia++;
    }
}