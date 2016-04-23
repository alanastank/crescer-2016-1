import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNormalTest {
        
    @Test 
    public void seAoAlistar3ElfosNoturnosE1VerdePraAtacarSo2NoturnosEOElfoVerdeAtacam(){
        // Arrange
        EstrategiaDeAtaque estrategia = new EstrategiaNormal();
        ArrayList<Elfo> exercitoElfos = new ArrayList<>();
        Elfo elfoNoturno1 = new ElfoNoturno("Pelleas");
        Elfo elfoNoturno2 = new ElfoNoturno("Rennyn");
        Elfo elfoNoturno3 = new ElfoNoturno("Keya");
        Elfo elfoVerde1 = new ElfoVerde("Alasse");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf dwarf1 = new Dwarf("Luirlan");
        Dwarf dwarf2 = new Dwarf("Cailu");
        // Act
        exercitoElfos.add(elfoNoturno1);
        exercitoElfos.add(elfoNoturno2);
        exercitoElfos.add(elfoNoturno3);
        exercitoElfos.add(elfoVerde1);
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        estrategia.atacar(exercitoElfos, dwarves);
        // Assert
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno1));
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno2));
        assertEquals(false, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno3));
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoVerde1));
    }
    
    @Test 
    public void seAoAlistar3ElfosNoturnosSendo2MortosEAlistar2VerdesPraAtacarSo1NoturnoEOElfosVerdesAtacammm(){
        // Arrange
        EstrategiaDeAtaque estrategia = new EstrategiaNormal();
        ArrayList<Elfo> exercitoElfos = new ArrayList<>();
        Elfo elfoNoturno1 = new ElfoNoturno("Pelleas");
        Elfo elfoNoturno2 = ExercitoDeElfosTest.criarElfoEDepoisMataLo("Rennyn");
        Elfo elfoNoturno3 = ExercitoDeElfosTest.criarElfoEDepoisMataLo("Keya");
        Elfo elfoVerde1 = new ElfoVerde("Alasse");
        Elfo elfoVerde2 = new ElfoVerde("Nelaeryn");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf dwarf1 = new Dwarf("Luirlan");
        Dwarf dwarf2 = new Dwarf("Cailu");
        // Act
        exercitoElfos.add(elfoNoturno1);
        exercitoElfos.add(elfoNoturno2);
        exercitoElfos.add(elfoNoturno3);
        exercitoElfos.add(elfoVerde1);
        exercitoElfos.add(elfoVerde2);
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        estrategia.atacar(exercitoElfos, dwarves);
        // Assert
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno1));
        assertEquals(false, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno2));
        assertEquals(false, estrategia.getOrdemDoUltimoAtaque().contains(elfoNoturno3));
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoVerde1));
        assertEquals(true, estrategia.getOrdemDoUltimoAtaque().contains(elfoVerde2));
    } 
}
