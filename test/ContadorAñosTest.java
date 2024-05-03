
import com.lucia.perfil.ContadorAños;
import com.lucia.producto.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContadorAñosTest {

    @Test
    public void comprobacionSumarAño() {
        Assertions.assertEquals(50, ContadorAños.sumarAño(49));
    }
}
