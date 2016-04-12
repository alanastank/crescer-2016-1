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
    public void experienciaAposAtirar3VezesEh9EVidaDiminui14(){
       // Arrange
       Elfo elfo = new ElfoNoturno("legolas");
       Dwarf dwarf = new Dwarf("Dwarf");
       // Act
       for(int i=1; i<=3; i++){
           elfo.atirarFlecha(dwarf);
       }
       // Assert
       assertEquals(9, elfo.getExperiencia()); 
       assertEquals(85.7375, elfo.getVida(), 0.1);  
    }
    
    @Test
    public void elfoNotunoMorreDepoisDeAtirar90Vezes(){
       // Arrange
       Elfo elfo = new ElfoNoturno("legolas");
       Dwarf dwarf = new Dwarf("Dwarf");
       // Act
       for(int i=1; i<=90; i++){
           elfo.atirarFlecha(dwarf);
       }
       // Assert
       assertEquals(Status.MORTO, elfo.getStatus());  
    }
}
