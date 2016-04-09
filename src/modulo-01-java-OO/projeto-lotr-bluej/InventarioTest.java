import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class InventarioTest {
    
    @Test
    public void adicionaItemaAoInventarioCorretamente() {
        // Arrange
        Inventario listaItens = new Inventario();
        Item item = new Item(2, "espada");
        // Act
        listaItens.adicionarItem(item);
        // Assert
        assertTrue(listaItens.getListaItens().contains(item));
    }
    
    @Test
    public void testaRemoverItem() {
        // Arrange
        Inventario inventario = new Inventario();
        Item item = new Item(5, "poção");
        // Act
        inventario.adicionarItem(item);
        inventario.removerItem(item);
        // Assert
        assertFalse(inventario.getListaItens().contains(item));
    }
    
    @Test
    public void getDescricoesItensVazios() {
        // Arrange
        Inventario inventario = new Inventario();
        // Assert
        assertEquals("", inventario.getDescricoesItens());
    }
    
    @Test
    public void getDescricoesComUmItem() {
        // Arrange
        Inventario inventario = new Inventario();
        Item item = new Item(2, "cantil");
        // Act
        inventario.adicionarItem(item);
        // Assert
        assertEquals("cantil", inventario.getDescricoesItens());
    }
    
    @Test
    public void getDescricoesComDoisItens() {
        // Arrange
        Inventario inventario = new Inventario();
        Item item = new Item(2, "cantil");
        Item item2 = new Item(5, "mapa");
        // Act
        inventario.adicionarItem(item);
        inventario.adicionarItem(item2);
        // Assert
        assertEquals("cantil,mapa", inventario.getDescricoesItens());
    }
    
    @Test
    public void getItemComMaiorQuantidadeDeUmaListaVazia(){
        // Arrange
        Inventario inventario = new Inventario();
        // Assert
        assertEquals(0, inventario.getItemComMaiorQuantidade().getQuantidade());
    }
    
    @Test
    public void getItemComMaiorQuantidadeDeUmaListaCom1Item(){
        // Arrange
        Inventario inventario = new Inventario();
        Item item = new Item(2, "cantil");
        // Act
        inventario.adicionarItem(item);
        inventario.getItemComMaiorQuantidade();
        // Assert
        assertEquals(2, inventario.getItemComMaiorQuantidade().getQuantidade());
    }
    
    @Test
    public void getItemComMaiorQuantidadeDeUmaListaCom4Itens(){
        // Arrange
        Inventario inventario = new Inventario();
        Item item = new Item(2, "cantil");
        Item item2 = new Item(5, "moedas de ouro");
        Item item3 = new Item(8, "martelo");
        Item item4 = new Item(1, "poção");
        // Act
        inventario.adicionarItem(item);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        inventario.adicionarItem(item4);
        inventario.getItemComMaiorQuantidade();
        // Assert
        assertEquals(8, inventario.getItemComMaiorQuantidade().getQuantidade());
    }
}
