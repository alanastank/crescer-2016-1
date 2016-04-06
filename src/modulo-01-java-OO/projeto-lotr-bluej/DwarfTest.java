import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    @Test
    public void testaCriarDwarf(){
        Dwarf dwarf = new Dwarf("Atchim");
        int vidaEsperada = 110;
        int vida = dwarf.getVida();
        assertEquals(vidaEsperada, vida);  
    } 
    
    @Test
    public void testaLevarDano(){
        Dwarf dwarf = new Dwarf("Atchim");
        int vidaEsperadaAposDano = 100;
        dwarf.levarDano();
        int vidaAposLevarDano = dwarf.getVida();
        assertEquals(vidaEsperadaAposDano, vidaAposLevarDano);  
    }     
}

