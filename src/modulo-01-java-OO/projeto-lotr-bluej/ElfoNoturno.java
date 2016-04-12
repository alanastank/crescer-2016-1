public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        experiencia += 3; 
        numFlechas--;
        vida -= vida * 0.05;
        dwarf.levarDano();
    } 
    
    // Exercício 7.2: Da forma que está o exercício 7.1, o ElfoNoturno nunca irá morrer, uma vez que ele subtrai 5% da vida atual e não da vida total, 
    // o que fará que a vida nunca chegue em 0.
}
