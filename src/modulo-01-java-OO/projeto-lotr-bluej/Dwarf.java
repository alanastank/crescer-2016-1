import java.util.ArrayList;

public class Dwarf {
    private int vida;
    private String nome;
    private Status status = Status.VIVO;
    private DataTerceiraEra dataNascimento;
    protected Inventario inventarioDwarf;
    private int experiencia;
       
    public Dwarf(String nome) {
        this.vida = 110;
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1); // valor padrão de data para um dwarf que não recebe data como parâmetro
        this.inventarioDwarf = new Inventario(); 
        this.experiencia = 0;
    }
    
    // Sobrecarga de construtor
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento) { 
        this(nome);
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
    
    public int getExperiencia(){
        return experiencia;
    }
    
    // Métodos
    
    public double getNumeroSorte(){
        double numeroSorte = 101.0; 
        if (this.dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <=90 ) {
            numeroSorte *= -33; // numero < 0
        }
        if (!this.dataNascimento.ehBissexto() && this.nome.equals("Seixas") || this.nome.equals("Meireles")) {
            numeroSorte *= 33;
            numeroSorte %= 100; // numero entre 0 e 100
        }
        return numeroSorte;
    }
    
    public void levarDano() {
       if(getNumeroSorte() < 0) {
           this.experiencia += 2;
       }
       else if(getNumeroSorte() > 100) {
            if(this.vida > 0) {
                this.vida -= 10;
            }
            if(this.vida <= 0) {
               this.status = Status.MORTO;
               this.vida = 0; // se a vida for negativa, modifica pra 0
            }
       }
    }
    
    public void tentarSorte(){
        int novaQuantidade;
        if(getNumeroSorte() == -3333.0){
            for(int i=0; i < inventarioDwarf.getListaItens().size(); i++){
                novaQuantidade = inventarioDwarf.getListaItens().get(i).getQuantidade();
                novaQuantidade += 1000;
                inventarioDwarf.getListaItens().get(i).setQuantidade(novaQuantidade);

            }
        }
    }
       
     public void adicionarItem(Item item){
        this.inventarioDwarf.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.inventarioDwarf.removerItem(item);
    }
        
}