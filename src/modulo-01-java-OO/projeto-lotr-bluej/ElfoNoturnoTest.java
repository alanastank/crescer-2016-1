import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {
    
    @Test
    public void experienciaAposAtirarEh3EVidaDiminuiu5PorCento(){
       // Arrange
       Elfo elfo = new ElfoNoturno("legolas");
       Dwarf dwarf = new Dwarf("Dwarf");
       // Act
       elfo.atirarFlecha(dwarf);
       // Assert
       assertEquals(3, elfo.getExperiencia()); 
       assertEquals(95, elfo.getVida(), 0.1);  
    }
    
    @Test
    public void elfoNoturnoAtiraAteMorrer() {
       	ElfoNoturno elfoNoturno = new ElfoNoturno("ElfoNoturno");
        Dwarf dwarf = new Dwarf("Dwarf");
            
        while(elfoNoturno.getVida() > 1) {
        	elfoNoturno.atirarFlecha(dwarf);
        }
            
    	assertEquals(0.98, elfoNoturno.getVida(), 0.1);
    }
}
