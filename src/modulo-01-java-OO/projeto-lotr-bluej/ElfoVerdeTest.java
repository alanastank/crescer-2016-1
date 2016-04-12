import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest {
  @Test
  public void testaCriarElfoVerde() {
      Elfo elfoVerde = new ElfoVerde("legolas");
      assertEquals(42, elfoVerde.getNumFlechas());  
      assertEquals(0, elfoVerde.getExperiencia());  
  }
    
  @Test
  public void testaAtirarFlechas() {
      Elfo elfoVerde = new ElfoVerde("legolas");
      Dwarf dwarf = new Dwarf("Dwarf");
      int experienciaEsperadaAposAtirar = elfoVerde.getExperiencia() + 2;
      int numFlechasEsperadaAposAtirar = elfoVerde.getNumFlechas() - 1;
      elfoVerde.atirarFlecha(dwarf);
      assertEquals(experienciaEsperadaAposAtirar, elfoVerde.getExperiencia()); 
      assertEquals(numFlechasEsperadaAposAtirar, elfoVerde.getNumFlechas());  
  }    
  
  @Test 
  public void adicionaItemNasEspecificacoesNoInventarioEInventarioNaoEstaVazio(){
     // Arrange 
     Elfo elfoVerde = new ElfoVerde("Balin");
     Item item = new Item(6, "Espada de aço valiriano");
     // Act
     elfoVerde.adicionarItem(item);
     // Assert
     assertTrue(elfoVerde.getInventario().getListaItens().contains(item));
    }
    
  @Test 
  public void adicionaItemForaDasEspecificacoesNoInventarioEInventarioEstaVazio(){
     // Arrange 
     Elfo elfoVerde = new ElfoVerde("Balin");
     Item item = new Item(6, "pão");
     // Act
     elfoVerde.adicionarItem(item);
     // Assert
     assertFalse(elfoVerde.getInventario().getListaItens().contains(item));
    }
}
