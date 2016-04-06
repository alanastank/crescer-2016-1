import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    
   @Test
   public void testaCriarElfo() {
       Elfo elfo = new Elfo("legolas");
       int numFlechasEsperada = 42;
       int numFlechas = elfo.getNumFlechas();
       assertEquals(numFlechasEsperada, numFlechas);  
    }
    
   @Test
   public void testaAtirarFlechas() {
       Elfo elfo = new Elfo("legolas");
       int experienciaEsperadaAposAtirar = elfo.getExperiencia() + 1;
       elfo.atirarFlecha();
       int experienciaAposAtirar = elfo.getExperiencia();
       int numFlechasEsperadaAposAtirar = elfo.getNumFlechas() - 1;
       elfo.atirarFlecha();
       int numFlechasAposAtirar = elfo.getNumFlechas();
       assertEquals(experienciaEsperadaAposAtirar, experienciaAposAtirar); 
       assertEquals(numFlechasEsperadaAposAtirar, numFlechasAposAtirar);  
    }
    
}
