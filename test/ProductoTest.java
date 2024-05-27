
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

    @Test
    public void comprobacionCalcularCantidadMax() {
        Assertions.assertEquals(70, Producto.calcularCantidadMax(35));
    }

    @Test
    public void comprobacionCalcularCantidadMin() {
        Assertions.assertEquals(20, Producto.calcularCantidadMin(30));
    }
}
