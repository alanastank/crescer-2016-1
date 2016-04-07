import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    @Test
    public void testarCriarDwarf(){
        // Arrange
        Dwarf dwarf = new Dwarf("Atchim");
        int vidaEsperada = 110;
        // Act
        int vida = dwarf.getVida();
        // Assert
        assertEquals(vidaEsperada, vida);  
    } 
    
    @Test
    public void testarLevarDano(){
        // Arrange
        Dwarf dwarf = new Dwarf("Atchim");
        int vidaEsperadaAposDano = 100;
        // Act
        dwarf.levarDano();
        int vidaAposLevarDano = dwarf.getVida();
        // Assert
        assertEquals(vidaEsperadaAposDano, vidaAposLevarDano);  
    }     
    
    @Test
    public void testarSeDwarfNasceVivo() {
        // Arrange
        Dwarf dwarf = new Dwarf("Balin");
        Status esperado = Status.VIVO;
        // Act
        Status atual = dwarf.getStatus();
        // Assert
        assertEquals(esperado, atual);
    }
    
    @Test
    public void testarMatarDwarf() {
        // Arrange
        Dwarf dwarf = new Dwarf("Balin");
        Status esperado = Status.MORTO;
        // Act
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        // Assert
        assertEquals(esperado, dwarf.getStatus());
    }
    
    @Test 
    public void testarSeAVidaFicaNegativaDepoisDe11Danos(){
        Dwarf dwarf = new Dwarf("Balin");
        int vidaEsperada = 0;
        // Act
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        // Assert
        assertEquals(vidaEsperada, dwarf.getVida());
    }
}

