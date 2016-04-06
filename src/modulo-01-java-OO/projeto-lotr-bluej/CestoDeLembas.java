public class CestoDeLembas
{
    private int numLembas;

    public CestoDeLembas(int numLembas)
    {
        this.numLembas = numLembas;
    }

    
    public boolean podeDividirEmPares()
    {

        if (numLembas >= 1 && numLembas <= 100){
            if (numLembas % 2 == 0 && numLembas != 2)  {
                return true;
           } 
           else {
            return false;
           }
        } else {
            System.out.println("Valor inválido.");
            return false;}
    }
}