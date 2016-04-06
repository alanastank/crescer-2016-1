public class Anao
{
    public int vida;
    public String nomeAnao;
    
    public int getVida() {
return vida;
}

public void setVida(int vida) {
this.vida = vida;
}
    
    public Anao(String nomeAnao)
    {
        this.nomeAnao = nomeAnao;
        vida = 110;
    }
    
      public void levarDano() {
        this.vida = vida;
        vida = vida - 10;
  }
  
}
