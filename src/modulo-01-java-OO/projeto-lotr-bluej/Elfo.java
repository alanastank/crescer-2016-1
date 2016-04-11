public class Elfo extends Personagem {   
    protected int numFlechas;
    protected Status status = Status.VIVO;
    protected int vida;
    
    public Elfo(String nome) {
        super(nome);
        numFlechas = 42;
        vida = 100;
    }
   
     public int getNumFlechas() {
        return numFlechas;
    }
    
    public Status getStatus(){
        return status;
    }
    
     public int getVida() {
        return vida;
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