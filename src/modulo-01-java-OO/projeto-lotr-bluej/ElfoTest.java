import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    
   @Test
   public void testaSeElfoNasceCom42FlechasEVida100() {
       // Arrange
       Elfo elfo = new Elfo("legolas");
       // Assert
       assertEquals(42, elfo.getNumFlechas());
       assertEquals(100, elfo.getVida());  
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
