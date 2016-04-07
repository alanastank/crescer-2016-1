import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest {
    
    @Test
    public void testaMetodoEhBissextoComAnoNaoBissexto() {
        DataTerceiraEra data = new DataTerceiraEra(12, 02, 1998);
        assertEquals(false, data.ehBissexto());
    }
    
    @Test
    public void testaMetodoEhBissextoComAnoBissexto() {
        DataTerceiraEra data = new DataTerceiraEra(22, 10, 2016);
        assertEquals(true, data.ehBissexto());
    }
}