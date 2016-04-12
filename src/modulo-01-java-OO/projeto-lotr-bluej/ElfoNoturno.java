public class ElfoNoturno extends Elfo {
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    /* Exercicio 7.1:
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia+=2;
        this.vida -= this.vida * 0.05;
    } 
    
    Exercício 7.2:  Como a vida do Elfo é ponto flutuante (double) as divisões não são exatas, e embora elas tendam a 0 elas nunca chegarão a zero, ficando cada vez mais próximo, 
    mas sempre com restos de divisão. Por isto, para matar o elfo precisamos considerar apenas a parte inteira do número (convertendo para int) OU quando o número for MENOR que 1. */
    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia+=2;
        this.vida -= this.vida * 0.05;
        if(this.vida < 1) {
            status = Status.MORTO;
            vida = 0; // se a vida for negativa, modifica pra 0
        }
    }
}
