public class Dwarf {
    private int vida;
    private String nome;
    private Status status = Status.VIVO;
 
    public void setNome(String novoNome){ // usar somente quando for necessário alterar algo
    nome = novoNome;
    }
    
    public String getNome(){
    return nome;
    }
    
    public int getVida(){
    return vida;
    }
    
     public Status getStatus(){
    return status;
    }
        
    public Dwarf(String nome) {
        this.vida = 110;
        this.nome = nome;
    }
    
    public void levarDano() {
        if(this.vida > 0) {
        this.vida -= 10;
       }
       if(this.vida <= 0){
        this.status = Status.MORTO;
        this.vida = 0; // se a vida for negativa, modifica pra 0
       }
    }
  
}