import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest {
    
    @Test
    public void testarCriarDwarfComNome(){
        // Arrange
        Dwarf dwarf = new Dwarf("Atchim");
        int vidaEsperada = 110;
        // Act
        int vida = dwarf.getVida();
        // Assert
        assertEquals(vidaEsperada, vida);  
    } 
    
    @Test
    public void testarCriarDwarfComNomeEData(){
        // Arrange
        DataTerceiraEra data = new DataTerceiraEra(22,02,1998);
        Dwarf dwarf = new Dwarf("Atchim", data);
        DataTerceiraEra dataEsperada = data;
        // Assert
        assertEquals(dataEsperada, dwarf.getDataNascimento());  
    } 
    
    @Test
    public void testarCriarDwarfComDataPadrao(){
        // Arrange
        Dwarf dwarf = new Dwarf("Atchim");
        DataTerceiraEra dataPadrao = new DataTerceiraEra(1,1,1);
        // Assert
        assertTrue(dataPadrao.equals(dwarf.getDataNascimento()));  
    } 
    
    @Test
    public void testarLevarDano(){
        // Arrange
        Dwarf dwarf = new Dwarf("Atchim");
        int vidaEsperadaAposDano = 100;
        // Act
        dwarf.levarDano();
        int vidaAposLevarDano = dwarf.getVida();
        // Assert
        assertEquals(vidaEsperadaAposDano, vidaAposLevarDano);  
    }     
    
    @Test
    public void testarSeDwarfNasceVivo() {
        // Arrange
        Dwarf dwarf = new Dwarf("Balin");
        Status esperado = Status.VIVO;
        // Act
        Status atual = dwarf.getStatus();
        // Assert
        assertEquals(esperado, atual);
    }
    
    @Test
    public void testarMatarDwarf() {
        // Arrange
        Dwarf dwarf = new Dwarf("Balin");
        Status esperado = Status.MORTO;
        // Act
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        // Assert
        assertEquals(esperado, dwarf.getStatus());
    }
    
    @Test 
    public void testarSeAVidaFicaNegativaDepoisDe11Danos(){
        // Arrange
        Dwarf dwarf = new Dwarf("Balin");
        int vidaEsperada = 0;
        // Act
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        // Assert
        assertEquals(vidaEsperada, dwarf.getVida());
    }
    
    @Test 
    public void adicionaItemNoInventarioEInventarioNaoEstaVazio(){
        // Arrange 
        Dwarf dwarf = new Dwarf("Balin");
        Item item = new Item(6, "pão");
        // Act
        dwarf.adicionarItem(item);
        // Assert
        assertTrue(dwarf.getInventario().getListaItens().contains(item));
    }
    
    @Test
    public void DwarfNasceComNumeroDaSorte101(){
         Dwarf dwarf = new Dwarf("Balin");
         double numeroEsperado = 101.0;
         // Assert
         // Quando usa-se double no assertEquals, é necessário mais um parametro para definir uma "margem de diferença", já que dois doubles poderão não ser iguais
         assertEquals(numeroEsperado, dwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void NumeroDaSorteDeDwarfQueNasceuEmAnoBissextoENaoTemVidaEntre80E90(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2012);
        Dwarf dwarf = new Dwarf("Atchim", data);
        double numeroEsperado = 101.0;
         // Assert
         assertEquals(numeroEsperado, dwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void NumeroDaSorteDeDwarfQueNasceuEmAnoBissextoETemVidaEntre80E90(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2012);
        Dwarf dwarf = new Dwarf("Atchim", data);
        double numeroEsperado = (101.0*-33);
        // Act
        dwarf.levarDano();
        dwarf.levarDano();
        dwarf.levarDano();
        // Assert
        assertEquals(numeroEsperado, dwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void NumeroDaSorteDeDwarfQueNaoNasceuEmAnoBissextoENaoTemNomeIgualSeixasOuMeireles(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2011);
        Dwarf dwarf = new Dwarf("Atchim", data);
        double numeroEsperado = 101.0;       
        // Assert
        assertEquals(numeroEsperado, dwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void NumeroDaSorteDeDwarfQueNaoNasceuEmAnoBissextoETemNomeIgualSeixas(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2011);
        Dwarf dwarf = new Dwarf("Seixas", data);
        double numeroEsperado = ((101*33) % 100);       
        // Assert
        assertEquals(numeroEsperado, dwarf.getNumeroSorte(), 0.1); 
    }
    
      @Test
    public void NumeroDaSorteDeDwarfQueNaoNasceuEmAnoBissextoETemNomeIgualMeireles(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2011);
        Dwarf dwarf = new Dwarf("Meireles", data);
        double numeroEsperado = ((101*33) % 100);       
        // Assert
        assertEquals(numeroEsperado, dwarf.getNumeroSorte(), 0.1); 
    }
}

