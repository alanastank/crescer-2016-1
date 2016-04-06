public class Dwarf {
    private int vida;
    private String nome;
 
    public void setNome(String novoNome){ // usar somente quando for necessário alterar algo
    nome = novoNome;
    }
    
    public String getNome(){
    return nome;
    }
    
    public int getVida(){
    return vida;
    }
        
    public Dwarf(String nome) {
        this.vida = 110;
        this.nome = nome;
    }
    
    public void levarDano() {
        this.vida -= 10;
    }
  
}