import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest {
    
    @Test
    public void testarCriarIrishDwarfComNome(){
        // Arrange
        IrishDwarf irishDwarf = new IrishDwarf("Atchim");
        int vidaEsperada = 110;
        // Act
        int vida = irishDwarf.getVida();
        // Assert
        assertEquals(vidaEsperada, vida);  
    } 
    
    @Test
    public void testarCriarIrishDwarfComNomeEData(){
        // Arrange
        DataTerceiraEra data = new DataTerceiraEra(22,02,1998);
        IrishDwarf irishDwarf = new IrishDwarf("Atchim", data);
        DataTerceiraEra dataEsperada = data;
        // Assert
        assertEquals(dataEsperada, irishDwarf.getDataNascimento());  
    } 
    
    @Test
    public void testarCriarIrishDwarfComDataPadrao(){
        // Arrange
        IrishDwarf irishDwarf = new IrishDwarf("Atchim");
        DataTerceiraEra dataPadrao = new DataTerceiraEra(1,1,1);
        // Assert
        assertTrue(dataPadrao.equals(irishDwarf.getDataNascimento()));  
    } 
    
    @Test
    public void testarLevarDano(){
        // Arrange
        IrishDwarf irishDwarf = new IrishDwarf("Atchim");
        int vidaEsperadaAposDano = 100;
        // Act
        irishDwarf.levarDano();
        int vidaAposLevarDano = irishDwarf.getVida();
        // Assert
        assertEquals(vidaEsperadaAposDano, vidaAposLevarDano);  
    }     
    
    @Test
    public void testarSeIrishDwarfNasceVivo() {
        // Arrange
        IrishDwarf irishDwarf = new IrishDwarf("Balin");
        Status esperado = Status.VIVO;
        // Act
        Status atual = irishDwarf.getStatus();
        // Assert
        assertEquals(esperado, atual);
    }
    
    @Test
    public void testarMatarIrishDwarf() {
        // Arrange
        IrishDwarf irishDwarf = new IrishDwarf("Balin");
        Status esperado = Status.MORTO;
        // Act
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        // Assert
        assertEquals(esperado, irishDwarf.getStatus());
    }
    
    @Test 
    public void testarSeAVidaFicaNegativaDepoisDe11Danos(){
        // Arrange
        IrishDwarf irishDwarf = new IrishDwarf("Balin");
        int vidaEsperada = 0;
        // Act
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        // Assert
        assertEquals(vidaEsperada, irishDwarf.getVida());
    }
    
    @Test 
    public void adicionaItemNoInventarioEInventarioNaoEstaVazio(){
        // Arrange 
        IrishDwarf irishDwarf = new IrishDwarf("Balin");
        Item item = new Item(6, "pão");
        // Act
        irishDwarf.adicionarItem(item);
        // Assert
        assertTrue(irishDwarf.getInventario().getListaItens().contains(item));
    }
    
    @Test 
    public void removeItemNoInventarioEInventarioEstaVazio(){
        // Arrange 
        IrishDwarf irishDwarf = new IrishDwarf("Balin");
        Item item = new Item(6, "pão");
        // Act
        irishDwarf.adicionarItem(item);
        irishDwarf.perderItem(item);
        // Assert
        assertFalse(irishDwarf.getInventario().getListaItens().contains(item));
    }
    
    @Test
    public void IrishDwarfNasceComNumeroDaSorte101(){
         IrishDwarf irishDwarf = new IrishDwarf("Balin");
         double numeroEsperado = 101.0;
         // Assert
         // Quando usa-se double no assertEquals, é necessário mais um parametro para definir uma "margem de diferença", já que dois doubles poderão não ser iguais
         assertEquals(numeroEsperado, irishDwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void NumeroDaSorteDeIrishDwarfQueNasceuEmAnoBissextoENaoTemVidaEntre80E90(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2012);
        IrishDwarf irishDwarf = new IrishDwarf("Atchim", data);
        double numeroEsperado = 101.0;
         // Assert
         assertEquals(numeroEsperado, irishDwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void NumeroDaSorteDeIrishDwarfQueNasceuEmAnoBissextoETemVidaEntre80E90(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2012);
        IrishDwarf irishDwarf = new IrishDwarf("Atchim", data);
        double numeroEsperado = (101.0*-33);
        // Act
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        // Assert
        assertEquals(numeroEsperado, irishDwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void NumeroDaSorteDeIrishDwarfQueNaoNasceuEmAnoBissextoENaoTemNomeIgualSeixasOuMeireles(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2011);
        IrishDwarf irishDwarf = new IrishDwarf("Atchim", data);
        double numeroEsperado = 101.0;       
        // Assert
        assertEquals(numeroEsperado, irishDwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void NumeroDaSorteDeIrishDwarfQueNaoNasceuEmAnoBissextoETemNomeIgualSeixas(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2011);
        IrishDwarf irishDwarf = new IrishDwarf("Seixas", data);
        double numeroEsperado = ((101*33) % 100);       
        // Assert
        assertEquals(numeroEsperado, irishDwarf.getNumeroSorte(), 0.1); 
    }
    
      @Test
    public void NumeroDaSorteDeIrishDwarfQueNaoNasceuEmAnoBissextoETemNomeIgualMeireles(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2011);
        IrishDwarf irishDwarf = new IrishDwarf("Meireles", data);
        double numeroEsperado = ((101*33) % 100);       
        // Assert
        assertEquals(numeroEsperado, irishDwarf.getNumeroSorte(), 0.1); 
    }
    
    @Test
    public void criarIrishDwarfComNumeroDaSorteMenorQue0(){
        // Arrange 
        DataTerceiraEra data = new DataTerceiraEra(22,02,2000);
        IrishDwarf irishDwarf = new IrishDwarf("Atchim", data);
        int experienciaEsperada = 2;
        // Act
        irishDwarf.levarDano(); 
        irishDwarf.levarDano(); 
        irishDwarf.levarDano();
        // Assert
        assertEquals(experienciaEsperada, irishDwarf.getExperiencia()); 
    }
    
    @Test
    public void criarIrishDwarfComNumeroDaSorteEntre0E100(){
        // Arrange 
        DataTerceiraEra data = new DataTerceiraEra(22,02,2011);
        IrishDwarf irishDwarf = new IrishDwarf("Meireles", data);
        int vidaEsperada = 110; 
        int experienciaEsperada = 0;
        // Assert
        assertEquals(vidaEsperada, irishDwarf.getVida()); 
        assertEquals(experienciaEsperada, irishDwarf.getExperiencia()); 
    }
    
    @Test
    public void testarSorteDeIrishDwarfQueNasceuEmAnoBissextoETemVidaEntre80E90(){
        DataTerceiraEra data = new DataTerceiraEra(22,02,2012);
        IrishDwarf irishDwarf = new IrishDwarf("Atchim", data);
        Item item = new Item(3, "capacete");
        irishDwarf.adicionarItem(item);
        int quantidadeEsperada = 6003;
        // Act
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.levarDano();
        irishDwarf.tentarSorte();       
        // Assert
        assertEquals(quantidadeEsperada, irishDwarf.getInventario().getListaItens().get(0).getQuantidade()); 
    }
}

