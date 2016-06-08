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
    public void seRetornaTrueComStringVazia() {
        String palavra = "";
        assertTrue(MeuStringUtil.validarString(palavra));
    }

    @Test
    public void seRetornaTruePraStringNula() {
        String palavra = null;
        assertTrue(MeuStringUtil.validarString(palavra));
    }
    
    @Test
    public void seRetornaFalseComStringNaoVaziaEComEspaco() {
        String palavra = "teste teste";
        assertFalse(MeuStringUtil.validarString(palavra));
    }
    
}
