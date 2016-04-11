import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.*;

public class HobbitContadorTest {
        
    @Test
    public void calcularDiferencaCom3Pares() {
        HobbitContador contador = new HobbitContador();
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));
        assertEquals(840,contador.calcularDiferenca(arrayDePares));
    }
        
    @Test
    public void calcularDiferencaCom2ParesEUmParDeZeros() {
        HobbitContador contador = new HobbitContador();
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        assertEquals(0,contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void calcularDiferencaCom1ParDeNumerosIguais() {
        HobbitContador contador = new HobbitContador();
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 15)));
        assertEquals(210,contador.calcularDiferenca(arrayDePares));
    }
    
}
