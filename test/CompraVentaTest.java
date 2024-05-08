import com.lucia.actividades.CompraVenta;
import com.lucia.producto.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompraVentaTest {

    @Test
    public void comprobacionCalcularPrecioTotal() {
        Assertions.assertEquals(816, CompraVenta.calcularPrecioTotal(17,48));
    }
}
