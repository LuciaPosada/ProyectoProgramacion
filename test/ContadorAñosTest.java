
import com.lucia.perfil.ContadorAños;
import com.lucia.producto.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContadorAñosTest {

    @Test
    public void comprobacionSumarAño() {
        Assertions.assertEquals(50, ContadorAños.sumarAño(49));
    }

    @Test
    public void comprobacionEmpeorarSaludMenos40Años() {
        Assertions.assertEquals(90, ContadorAños.empeorarSalud(100,25));
    }

    @Test
    public void comprobacionEmpeorarSaludMayor40Años() {
        Assertions.assertEquals(80, ContadorAños.empeorarSalud(100,41));
    }

    @Test
    public void comprobacionEmpeorarSaludMenor20Años() {
        Assertions.assertEquals(100, ContadorAños.empeorarSalud(100,18));
    }
}
