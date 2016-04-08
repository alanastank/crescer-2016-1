import java.util.ArrayList;

public class Dwarf {
    private int vida;
    private String nome;
    private Status status = Status.VIVO;
    private DataTerceiraEra dataNascimento;
    private Inventario inventarioDwarf;
       
    public Dwarf(String nome) {
        this.vida = 110;
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1); // valor padrão de data para um dwarf que não recebe data como parâmetro
        this.inventarioDwarf = new Inventario(); 
    }
    
    // Sobrecarga de construtor
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento) { 
        this.vida = 110;
        this.nome = nome;
        this.dataNascimento = dataNascimento; 
    }
 
    // Getters and setters
    
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
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    
    public Inventario getInventario(){
        return inventarioDwarf;
    }
    
    // Métodos
    
    public void levarDano() {
        if(this.vida > 0) {
            this.vida -= 10;
       }
       if(this.vida <= 0){
           this.status = Status.MORTO;
           this.vida = 0; // se a vida for negativa, modifica pra 0
       }
    }
    
     public void adicionarItem(Item item){
        this.inventarioDwarf.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.inventarioDwarf.removerItem(item);
    }
    
       public double getNumeroSorte(){
        double numeroSorte = 101.0;
        if (this.dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <=90 ) {
            numeroSorte *= -33;
        }
        if (!this.dataNascimento.ehBissexto() && this.nome.equals("Seixas") || this.nome.equals("Meireles")) {
            numeroSorte *= 33;
            numeroSorte %= 100;
        }
        return numeroSorte;
    }
     
}