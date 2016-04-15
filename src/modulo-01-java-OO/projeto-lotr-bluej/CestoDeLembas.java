public class CestoDeLembas {
    private int numLembas;

    public CestoDeLembas(int numLembas) {
        this.numLembas = numLembas;
    }
    
    public boolean podeDividirEmPares() {
       // boolean podeDividir = numLembas > 2 && numLembas <= 100 && numLembas % 2 == 0;
       // return podeDividir ? true : false; // Ternário > avalia se a variavel é verdadeira, se for, retorna true, se não for, retorna false.
       // OU, mais simples:
       
       return numLembas > 2 && numLembas <= 100 && numLembas % 2 == 0;
    }
}