import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

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
    public void seAdicionaDoisElfosComMesmoNomeESobrescreve(){
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo elfo1 = new ElfoVerde("Alasse", 19);
        Elfo elfo2 = new ElfoVerde("Alasse", 25);
        // Act
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        // Assert
        assertEquals(elfo2, exercito.buscarElfo("Alasse"));
    }
    
}
