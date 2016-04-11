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
    
    @Test
    public void calcularDiferencaComArrayListVazio() {
        HobbitContador contador = new HobbitContador();
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        assertEquals(0,contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void seMaiorMultiploDeTresAte10Eh9(){
        HobbitContador contador = new HobbitContador();
        assertEquals(9, contador.obterMaiorMultiploDeTresAte(10));
    }
    
    @Test
    public void seMaiorMultiploDeTresAte7Eh6(){
        HobbitContador contador = new HobbitContador();
        assertEquals(6, contador.obterMaiorMultiploDeTresAte(7));
    }
    
    @Test
    public void seMaiorMultiploDeTresAte0Eh0(){
        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.obterMaiorMultiploDeTresAte(0));
    }
    
    @Test
    public void seMaiorMultiploDeTresAte100Eh99(){
        HobbitContador contador = new HobbitContador();
        assertEquals(99, contador.obterMaiorMultiploDeTresAte(100));
    }
    
    @Test
    public void testarMultiplosDeTresAte10(){
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> esperado = new ArrayList<>();
        esperado.add(0);
        esperado.add(3);
        esperado.add(6);
        esperado.add(9);
        assertEquals(esperado.toString(), contador.obterMultiplosDeTresAte(10).toString());
    }
    
    @Test
    public void testarMultiplosDeTresAte0(){
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> esperado = new ArrayList<>();
        esperado.add(0);
        assertEquals(esperado.toString(), contador.obterMultiplosDeTresAte(0).toString());
    }
    
    @Test
    public void testarMultiplosDeTresAte3(){
        HobbitContador contador = new HobbitContador();
        ArrayList<Integer> esperado = new ArrayList<>();
        esperado.add(0);
        esperado.add(3);
        assertEquals(esperado.toString(), contador.obterMultiplosDeTresAte(3).toString());
    }
}
