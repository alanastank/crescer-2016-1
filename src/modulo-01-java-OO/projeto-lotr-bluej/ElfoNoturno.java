public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    /* Exercicio 7.1:
    public void atirarFlecha(Dwarf dwarf) {
        experiencia += 3; 
        numFlechas--;
        vida -= vida * 0.05;
        dwarf.levarDano();
    } 
    
    Exercício 7.2: Da forma que está o exercício 7.1, o ElfoNoturno nunca irá morrer, uma vez que ele subtrai 5% da vida atual e não da vida total, 
    o que fará que a vida nunca chegue em 0. */
    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        experiencia+=2;
        vida -= 5;
        if(vida <= 0) {
            status = Status.MORTO;
            vida = 0; // se a vida for negativa, modifica pra 0
        }
    }
}
