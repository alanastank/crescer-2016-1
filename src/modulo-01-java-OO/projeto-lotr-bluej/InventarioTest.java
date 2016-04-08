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
}
