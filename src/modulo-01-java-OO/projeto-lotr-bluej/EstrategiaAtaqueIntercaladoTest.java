import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueIntercaladoTest {
    @Test
   public void seOPelotaoEhCompostoPor50PorCentoDeCadaTipoDeElfoAtacaIntercaladamente(){
       //Arrang
        EstrategiaDeAtaque estrategia = new EstrategiaAtaqueIntercalado();
        ArrayList<Elfo> exercitoElfos = new ArrayList<>();
        Elfo elfoNoturno1 = new ElfoNoturno("Pelleas");
        Elfo elfoNoturno2 = new ElfoNoturno("Rennyn");
        Elfo elfoNoturno3 = new ElfoNoturno("Keya");
        Elfo elfoVerde1 = new ElfoVerde("Alasse");
        Elfo elfoVerde2 = new ElfoVerde("Nelaeryn");
        Elfo elfoVerde3 = new ElfoVerde("Cailu");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf dwarf1 = new Dwarf("Luirlan");
        Dwarf dwarf2 = new Dwarf("Cailu");
       // Act
        exercitoElfos.add(elfoNoturno1);
        exercitoElfos.add(elfoNoturno2);
        exercitoElfos.add(elfoNoturno3);
        exercitoElfos.add(elfoVerde1);
        exercitoElfos.add(elfoVerde2);
        exercitoElfos.add(elfoVerde3);
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        estrategia.atacar(exercitoElfos, dwarves);
        estrategia.getOrdemDoUltimoAtaque();
       // Assert
        assertEquals(elfoVerde1, estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(elfoNoturno1, estrategia.getOrdemDoUltimoAtaque().get(1));
        assertEquals(elfoVerde2, estrategia.getOrdemDoUltimoAtaque().get(2));
        assertEquals(elfoNoturno2, estrategia.getOrdemDoUltimoAtaque().get(3));
        assertEquals(elfoVerde3, estrategia.getOrdemDoUltimoAtaque().get(4));
        assertEquals(elfoNoturno3, estrategia.getOrdemDoUltimoAtaque().get(5));
   }
   
   @Test
   public void seOPelotaoNaoEhCompostoPor50PorCentoDeCadaTipoDeElfoNaoAtaca(){
       //Arrang
        EstrategiaDeAtaque estrategia = new EstrategiaAtaqueIntercalado();
        ArrayList<Elfo> exercitoElfos = new ArrayList<>();
        Elfo elfoNoturno1 = new ElfoNoturno("Pelleas");
        Elfo elfoNoturno2 = new ElfoNoturno("Rennyn");
        Elfo elfoNoturno3 = new ElfoNoturno("Keya");
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
        estrategia.getOrdemDoUltimoAtaque();
       // Assert
        assertEquals(null, estrategia.getOrdemDoUltimoAtaque());
   }
   
   @Test
   public void seOPelotaoEhCompostoPor50PorCentoDeCadaTipoDeElfoMas1EhMortoNaoAtaca(){
       //Arrang
        EstrategiaDeAtaque estrategia = new EstrategiaAtaqueIntercalado();
        ArrayList<Elfo> exercitoElfos = new ArrayList<>();
        Elfo elfoNoturno1 = new ElfoNoturno("Pelleas");
        Elfo elfoNoturno2 = new ElfoNoturno("Rennyn");
        Elfo elfoNoturno3 = ExercitoDeElfosTest.criarElfoEDepoisMataLo("Keya");
        Elfo elfoVerde1 = new ElfoVerde("Alasse");
        Elfo elfoVerde2 = new ElfoVerde("Nelaeryn");
        Elfo elfoVerde3 = new ElfoVerde("Cailu");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf dwarf1 = new Dwarf("Luirlan");
        Dwarf dwarf2 = new Dwarf("Cailu");
       // Act
        exercitoElfos.add(elfoNoturno1);
        exercitoElfos.add(elfoNoturno2);
        exercitoElfos.add(elfoNoturno3);
        exercitoElfos.add(elfoVerde1);
        exercitoElfos.add(elfoVerde2);
        exercitoElfos.add(elfoVerde3);
        dwarves.add(dwarf1);
        dwarves.add(dwarf2);
        estrategia.atacar(exercitoElfos, dwarves);
        estrategia.getOrdemDoUltimoAtaque();
       // Assert
        assertEquals(null, estrategia.getOrdemDoUltimoAtaque());
   }   
}
