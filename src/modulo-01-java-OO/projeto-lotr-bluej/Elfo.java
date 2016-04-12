public class Elfo extends Personagem {   
    protected int numFlechas;
    protected Status status = Status.VIVO;
    protected double vida;
    protected static int contador;
    
    public Elfo(String nome) {
        super(nome);
        numFlechas = 42;
        vida = 100;
        this.contador++;
    }
   
     public int getNumFlechas() {
        return numFlechas;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public double getVida() {
        return vida;
    }
    
    public String toString() {  
        return nome + " possui " + numFlechas + " flechas e " + experiencia + " níveis de experiência";  
    }  
    
    public void atirarFlecha(Dwarf dwarf) {
        experiencia++;
        numFlechas--;
        dwarf.levarDano();
    }
}