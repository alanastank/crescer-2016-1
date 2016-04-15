import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class Estrategia1Test {
    
    @Test 
    public void seAoAlistar3ElfosNoturnosE1VerdePraAtacarSo2NoturnosAtacam(){
        // Arrange
        EstrategiaDeAtaque estrategia = new Estrategia1();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfoNoturno1 = new ElfoNoturno("Pelleas");
        Elfo elfoNoturno2 = new ElfoNoturno("Rennyn");
        Elfo elfoNoturno3 = new ElfoNoturno("Keya");
        Elfo elfoVerde1 = new ElfoVerde("Alasse");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf dwarf1 = new Dwarf("Luirlan");
        Dwarf dwarf2 = new Dwarf("Cailu");
        // Act
        exercito.alistarElfo(elfoNoturno1);
        exercito.alistarElfo(elfoNoturno2);
        exercito.alistarElfo(elfoNoturno3);
        exercito.alistarElfo(elfoVerde1);
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        estrategia.atacar(exercito, dwarves);
        // Assert
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno1));
        assertEquals(false, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno2));
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno3));
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoVerde1));
    }
}
