
import com.lucia.producto.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductoTest {

    @Test
    public void comprobacionCalcularPrecioMax() {
        Assertions.assertEquals(12, Producto.calcularPrecioMax(8));
    }

    @Test
    public void comprobacionCalcularPrecioMin() {
        Assertions.assertEquals(4, Producto.calcularPrecioMin(8));
    }
}
