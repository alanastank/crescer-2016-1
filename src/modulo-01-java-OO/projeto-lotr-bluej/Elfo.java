public class Elfo {   
    // Variáveis de instância
    private String nome;
    private int experiencia;
    private int numFlechas;
        
    // Construtor para objetos da classe Elfo
    public Elfo(String nome) {
        // Inicializa variáveis de instância
        this.nome = nome;
        experiencia = 0;
        numFlechas = 42;
    }

    // Aumentar experiência e diminuir número de flechas a cada chamada de atirarFlecha().
    public void atirarFlecha() {
        experiencia++; 
        numFlechas--;
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
