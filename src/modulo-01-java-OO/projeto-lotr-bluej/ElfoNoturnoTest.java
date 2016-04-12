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
       assertEquals(95, elfo.getVida());  
    }
    
    @Test
    public void experienciaAposAtirar3VezesEh9EVidaDiminuiu15(){
       // Arrange
       Elfo elfo = new ElfoNoturno("legolas");
       Dwarf dwarf = new Dwarf("Dwarf");
       // Act
       for(int i=1; i<=3; i++){
           elfo.atirarFlecha(dwarf);
       }
       // Assert
       assertEquals(9, elfo.getExperiencia()); 
       assertEquals(85, elfo.getVida());  
    }
    
    @Test
    public void elfoNotunoMorreDepoisDeAtirar20Vezes(){
       // Arrange
       Elfo elfo = new ElfoNoturno("legolas");
       Dwarf dwarf = new Dwarf("Dwarf");
       // Act
       for(int i=1; i<=20; i++){
           elfo.atirarFlecha(dwarf);
       }
       // Assert
       assertEquals(Status.MORTO, elfo.getStatus());  
    }
}
