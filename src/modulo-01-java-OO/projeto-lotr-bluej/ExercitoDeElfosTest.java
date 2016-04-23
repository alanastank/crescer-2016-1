import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.ArrayList;

public class ExercitoDeElfosTest {

    @Test
    public void seAdiciona1ElfoNoturnoE1VerdeENaoAdicionaElfo(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new ElfoVerde("Pelleas");
        Elfo elfo2 = new ElfoNoturno("Luirlan");
        Elfo elfo3 = new Elfo("Cailu");
        // Act
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        // Assert
        assertTrue(exercito.getExercitoDeElfos().containsKey("Pelleas"));
        assertTrue(exercito.getExercitoDeElfos().containsKey("Luirlan"));
        assertFalse(exercito.getExercitoDeElfos().containsKey("Cailu"));
    }
    
    @Test
    public void seAoNaoAdicionaNenhumElfoEstaVazio(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Assert
        assertTrue(exercito.getExercitoDeElfos().isEmpty());
    }
    
    @Test
    public void seAdiciona3ElfosEstaVazio(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new Elfo("Pelleas");
        Elfo elfo2 = new Elfo("Luirlan");
        Elfo elfo3 = new Elfo("Cailu");
        // Act
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        // Assert
        assertTrue(exercito.getExercitoDeElfos().isEmpty());
    }
    
    @Test
    public void seAdiciona5ElfosNoturnosE5VerdesENaoEstaVazio(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new ElfoVerde("Pelleas");
        Elfo elfo2 = new ElfoVerde("Rennyn");
        Elfo elfo3 = new ElfoVerde("Keya");
        Elfo elfo4 = new ElfoVerde("Eirika");
        Elfo elfo5 = new ElfoVerde("Alasse");
        Elfo elfo6 = new ElfoNoturno("Luirlan");
        Elfo elfo7 = new ElfoNoturno("Cailu");
        Elfo elfo8 = new ElfoNoturno("Luirlan");
        Elfo elfo9 = new ElfoNoturno("Lyari");
        Elfo elfo10 = new ElfoNoturno("Nelaeryn");
        // Act
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
        exercito.alistarElfo(elfo6);
        exercito.alistarElfo(elfo7);
        exercito.alistarElfo(elfo8);
        exercito.alistarElfo(elfo9);
        exercito.alistarElfo(elfo10);
        // Assert
        assertFalse(exercito.getExercitoDeElfos().isEmpty());
    }
    
    @Test
    public void seBuscaPorPelleasEEncontra(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new ElfoVerde("Pelleas");
        // Act
        exercito.alistarElfo(elfo1);
        // Assert
        assertEquals(elfo1, exercito.buscarElfo("Pelleas"));
    }
    
    @Test
    public void seBuscaPorPelleasENaoEncontra(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Assert
        assertEquals(null, exercito.buscarElfo("Pelleas"));
    }
    
    @Test
    public void seBuscaPorNullEEhNull(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Assert
        assertEquals(null, exercito.buscarElfo(null));
    }
    
    @Test
    public void seAdicionaDoisElfosComMesmoNomeESobrescreve(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new ElfoVerde("Alasse", 19);
        Elfo elfo2 = new ElfoVerde("Alasse", 25);
        // Act
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        // Assert
        assertFalse(exercito.getExercitoDeElfos().containsValue(elfo1));
        assertTrue(exercito.getExercitoDeElfos().containsValue(elfo2));
    }
    
    @Test
    public void seAdicionaDoisElfosMortosETresVivosAgrupaCorretamente(){
       // Arrange
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       Elfo elfo1 = criarElfoEDepoisMataLo("Alasse");
       Elfo elfo2 = criarElfoEDepoisMataLo("Pelleas");
       Elfo elfo3 = new ElfoVerde("Keya");
       Elfo elfo4 = new ElfoVerde("Eirika");
       Elfo elfo5 = new ElfoVerde("Cailu");
       // Act
       exercito.alistarElfo(elfo1);
       exercito.alistarElfo(elfo2);
       exercito.alistarElfo(elfo3);
       exercito.alistarElfo(elfo4);
       exercito.alistarElfo(elfo5);
       exercito.agruparPorStatus();
       // Assert
       assertEquals(true, exercito.elfoEstaNaListaDoStatusPassado(Status.MORTO, elfo1));
       assertEquals(true, exercito.elfoEstaNaListaDoStatusPassado(Status.MORTO, elfo2));
       assertEquals(true, exercito.elfoEstaNaListaDoStatusPassado(Status.VIVO, elfo3));
       assertEquals(true, exercito.elfoEstaNaListaDoStatusPassado(Status.VIVO, elfo4));
       assertEquals(true, exercito.elfoEstaNaListaDoStatusPassado(Status.VIVO, elfo5));
    }    
    
     @Test
    public void seBuscaPor4Vivos3MortosERetorna(){
        // Arrange
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       Elfo elfo1 = new ElfoVerde("Pelleas");
       Elfo elfo2 = new ElfoVerde("Keya");
       Elfo elfo3 = new ElfoVerde("Eirika");
       Elfo elfo4 = new ElfoVerde("Alasse");
       Elfo elfo5 = criarElfoEDepoisMataLo("Luirlan");
       Elfo elfo6 = criarElfoEDepoisMataLo("Cailu");
       Elfo elfo7 = criarElfoEDepoisMataLo("Quein");
        // Act
       exercito.alistarElfo(elfo1);
       exercito.alistarElfo(elfo2);
       exercito.alistarElfo(elfo3);
       exercito.alistarElfo(elfo4);
       exercito.alistarElfo(elfo5);
       exercito.alistarElfo(elfo6);
       exercito.alistarElfo(elfo7);
       exercito.agruparPorStatus();
       
       // Assert
       assertTrue(exercito.buscarElfosPorStatus(Status.VIVO).contains(elfo1));
       assertTrue(exercito.buscarElfosPorStatus(Status.VIVO).contains(elfo2));
       assertTrue(exercito.buscarElfosPorStatus(Status.VIVO).contains(elfo3));
       assertTrue(exercito.buscarElfosPorStatus(Status.VIVO).contains(elfo4));
       assertTrue(exercito.buscarElfosPorStatus(Status.MORTO).contains(elfo5));
       assertTrue(exercito.buscarElfosPorStatus(Status.MORTO).contains(elfo6));
       assertTrue(exercito.buscarElfosPorStatus(Status.MORTO).contains(elfo7));
    }
    
    @Test
    public void seAlistaVivoEBuscaPorMortoNaoEncontra(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new ElfoVerde("Pelleas");
        // Act
        exercito.alistarElfo(elfo1);
        exercito.agruparPorStatus();
        // Assert
        assertFalse(exercito.buscarElfosPorStatus(Status.MORTO).contains(elfo1));
    }
    
    public static Elfo criarElfoEDepoisMataLo(String nome) { 
     Elfo elfo = new ElfoNoturno(nome);
         for (int i = 0; i < 90; i++) {
             elfo.atirarFlecha(new Dwarf("Balin"));
         }
     return elfo;
    }
}
