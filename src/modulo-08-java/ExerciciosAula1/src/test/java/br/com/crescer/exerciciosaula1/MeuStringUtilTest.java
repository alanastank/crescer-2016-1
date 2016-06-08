package br.com.crescer.exerciciosaula1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MeuStringUtilTest {
    
    public MeuStringUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void seValidarStringRetornaTrueComStringVazia() {
        String palavra = "";
        assertTrue(MeuStringUtil.validarString(palavra));
    }

    @Test
    public void seValidarStringRetornaTruePraStringNula() {
        String palavra = null;
        assertTrue(MeuStringUtil.validarString(palavra));
    }
    
    @Test
    public void seValidarStringRetornaFalseComStringNaoVaziaEComEspaco() {
        String palavra = "teste teste";
        assertFalse(MeuStringUtil.validarString(palavra));
    }
    
    @Test
    public void seContarVogaisComStringVaziaRetorna0() {
        String palavra = "";
        assertEquals(0, MeuStringUtil.contarVogais(palavra));
    }
    
    @Test
    public void seContarVogaisComStringNulaRetorna0() {
        String palavra = null;
        assertEquals(0, MeuStringUtil.contarVogais(palavra));
    }
    
    @Test
    public void seContarVogaisComStringNãoVaziaRetornaCorretamente() {
        String palavra = "teste";
        assertEquals(2, MeuStringUtil.contarVogais(palavra));
    }
    
    @Test
    public void seContarVogaisComStringNãoVaziaEComEspacoRetornaCorretamente() {
        String palavra = "teste teste";
        assertEquals(4, MeuStringUtil.contarVogais(palavra));
    }
    
    @Test
    public void seInverterStringNaoVaziaRetornaCorretamente() {
        String palavra = "teste";
        assertEquals("etset", MeuStringUtil.inverterString(palavra));
    }
    
    @Test
    public void seInverterStringNaoVaziaEComEspacoRetornaCorretamente() {
        String palavra = "teste teste";
        assertEquals("etset etset", MeuStringUtil.inverterString(palavra));
    }
    
    @Test
    public void seInverterStringVaziaRetornaVazio() {
        String palavra = "";
        assertEquals("", MeuStringUtil.inverterString(palavra));
    }
    
    @Test
    public void seInverterStringNulaRetornaVazio() {
        String palavra = null;
        assertEquals("", MeuStringUtil.inverterString(palavra));
    }
    
    @Test
    public void seVerificarSeEhPalindromoComStringPalindromaRetornaTrue() {
        String palavra = "ovo";
        assertTrue(MeuStringUtil.verificarSeEhPalindromo(palavra));
    }
    
    @Test
    public void seVerificarSeEhPalindromoComStringPalindromaEComEspacoRetornaTrue() {
        String palavra = "ame a ema";
        assertTrue(MeuStringUtil.verificarSeEhPalindromo(palavra));
    }
    
    @Test
    public void seVerificarSeEhPalindromoComStringNaoPalindromaRetornaFalse() {
        String palavra = "roma";
        assertFalse(MeuStringUtil.verificarSeEhPalindromo(palavra));
    }
    
    @Test
    public void seVerificarSeEhPalindromoComStringNaoPalindromaEComEspacoRetornaFalse() {
        String palavra = "roma roma";
        assertFalse(MeuStringUtil.verificarSeEhPalindromo(palavra));
    }
    
    @Test
    public void seVerificarSeEhPalindromoComStringVaziaRetornaFalse() {
        String palavra = "";
        assertFalse(MeuStringUtil.verificarSeEhPalindromo(palavra));
    }
    
    @Test
    public void seVerificarSeEhPalindromoComStringNulaRetornaFalse() {
        String palavra = null;
        assertFalse(MeuStringUtil.verificarSeEhPalindromo(palavra));
    }   
}
