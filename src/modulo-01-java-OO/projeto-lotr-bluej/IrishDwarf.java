import java.util.ArrayList;

public class IrishDwarf {
    private int vida;
    private String nome;
    private Status status = Status.VIVO;
    private DataTerceiraEra dataNascimento;
    private Inventario inventarioIrishDwarf;
    private int experiencia;
       
    public IrishDwarf(String nome) {
        this.vida = 110;
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1); // valor padrão de data para um dwarf que não recebe data como parâmetro
        this.inventarioIrishDwarf = new Inventario(); 
        this.experiencia = 0;
    }
    
    // Sobrecarga de construtor
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) { 
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
        return inventarioIrishDwarf;
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
    
    // Quando eles tentarem a sorte e tiverem sucesso, ganharão 1000 * Soma de valores até a quantidade atual.
    public void tentarSorte(){
        int novaQuantidade = 0;
        int soma = 0;
        if(getNumeroSorte() == -3333.0){
            for(int i=0; i < inventarioIrishDwarf.getListaItens().size(); i++){
                for(int j=1; j <= inventarioIrishDwarf.getListaItens().get(i).getQuantidade(); j++){
                    soma += j;
                }
                novaQuantidade = (soma * 1000) + inventarioIrishDwarf.getListaItens().get(i).getQuantidade();
                inventarioIrishDwarf.getListaItens().get(i).setQuantidade(novaQuantidade);
            }
        }
    }
        
         
     public void adicionarItem(Item item){
        this.inventarioIrishDwarf.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        this.inventarioIrishDwarf.removerItem(item);
    }
        
}