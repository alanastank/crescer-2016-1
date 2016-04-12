import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
   /* @Before
   public void zeraContador(){
       Elfo.contador = 0;
   } */
   
   @Test
   public void contadorAposCriar2ElfosEhContadorMais2(){
       int contadorNovo = Elfo.contador + 2;
       Elfo elfo = new Elfo("legolas");
       Elfo elfo2 = new Elfo("legolinhas");
       assertEquals(contadorNovo, Elfo.contador);
   }
   
   @Test
   public void contadorAposCriar10ElfosEhContadorMais10(){
       int contadorNovo = Elfo.contador + 10;
           for(int i=1; i<=10; i++){
               Elfo elfo = new Elfo("legolas");
           }
       assertEquals(contadorNovo, Elfo.contador);
   }
   
   @Test
   public void testaSeElfoNasceCom42FlechasEVida100() {
       // Arrange
       Elfo elfo = new Elfo("legolas");
       // Assert
       assertEquals(42, elfo.getNumFlechas());
       assertEquals(100, elfo.getVida(), 0.1);  
    }
    
   @Test
   public void testaAtirarFlechas() {
       // Arrange
       Elfo elfo = new Elfo("legolas");
       Dwarf dwarf = new Dwarf("Dwarf");
       int experienciaEsperadaAposAtirar = elfo.getExperiencia() + 1;
       int numFlechasEsperadaAposAtirar = elfo.getNumFlechas() - 1;
       // Act
       elfo.atirarFlecha(dwarf);
       // Assert
       assertEquals(experienciaEsperadaAposAtirar, elfo.getExperiencia()); 
       assertEquals(numFlechasEsperadaAposAtirar, elfo.getNumFlechas());  
    }
    
   @Test
    public void testarSeElfoNasceVivo() {
        // Arrange
        Elfo elfo = new Elfo("Balin");
        Elfo elfoVerde = new ElfoVerde("legolas");
        // Assert
        assertEquals(Status.VIVO, elfo.getStatus());
        assertEquals(Status.VIVO, elfoVerde.getStatus());
    } 
}
