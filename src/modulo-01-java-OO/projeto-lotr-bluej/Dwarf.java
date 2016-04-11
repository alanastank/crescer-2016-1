import java.util.ArrayList;

public class Dwarf extends Personagem {
    private int vida;
    private Status status = Status.VIVO;
    private DataTerceiraEra dataNascimento;
       
    public Dwarf(String nome) {
        super(nome);
        this.vida = 110;
        this.dataNascimento = new DataTerceiraEra(1,1,1); // valor padrão de data para um dwarf que não recebe data como parâmetro
    }
    
    // Sobrecarga de construtor
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento) { 
        this(nome);
        this.dataNascimento = dataNascimento; 
    }
 
    // Getters and setters
   
    public int getVida(){
        return vida;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
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
            for(int i=0; i < inventario.getListaItens().size(); i++){
                novaQuantidade = inventario.getListaItens().get(i).getQuantidade();
                novaQuantidade += 1000;
                inventario.getListaItens().get(i).setQuantidade(novaQuantidade);

            }
        }
    }        
}