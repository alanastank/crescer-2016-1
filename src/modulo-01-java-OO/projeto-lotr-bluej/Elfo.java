public class Elfo extends Personagem {   
    protected int numFlechas;
    
    public Elfo(String nome) {
        super(nome);
        numFlechas = 42;
    }
   
     public int getNumFlechas() {
        return numFlechas;
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
    
    public void atirarFlechaRefactory() {   
        numFlechas--;
        experiencia++;
    }
}