import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class InventarioTest {
    
    @Test
    public void adicionaItemaAoInventarioCorretamente() {
        Inventario listaItens = new Inventario();
        Item item = new Item(2, "espada");
        listaItens.adicionarItem(item);
        assertTrue(listaItens.getListaItens().contains(item));
    }
    
    @Test
    public void testaRemoverItem() {
        Inventario listaItens = new Inventario();
        Item item = new Item(5, "poção");
        listaItens.adicionarItem(item);
        listaItens.removerItem(item);
        assertFalse(listaItens.getListaItens().contains(item));
    }
    
    @Test
    public void getDescricoesItensVazios() {
        Inventario inventario = new Inventario();
        String obtido = inventario.getDescricoesItens();
        assertEquals("", obtido);
    }
    
    @Test
    public void getDescricoesComUmItem() {
        Inventario inventario = new Inventario();
        Item item = new Item(2, "capacete");
        inventario.adicionarItem(item);
        String obtido = inventario.getDescricoesItens();
        assertEquals("capacete", obtido);
    }
    
    @Test
    public void getDescricoesComDoisItens() {
        Inventario inventario = new Inventario();
        Item item = new Item(2, "capacete");
        Item item2 = new Item(5, "espada");
        inventario.adicionarItem(item);
        inventario.adicionarItem(item2);
        String obtido = inventario.getDescricoesItens();
        assertEquals("capacete,espada", obtido);
    }
}
