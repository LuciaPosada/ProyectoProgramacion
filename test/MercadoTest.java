import com.lucia.producto.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MercadoTest {

    @Test
    public void comprobacionRenovarCantidades() {
        int cantidadMax = 40;
        int cantidadMin = 15;

        for (int i = 0; i < 1000; i++) { // Repeticion
            int resultado = Mercado.renovarCantidades(cantidadMax, cantidadMin);
            Assertions.assertTrue("El resultado debe estar dentro del rango", resultado >= cantidadMin && resultado <= cantidadMax);
        }
    }

    @Test
    public void comprobacionCambiarPrecios() {
        int precioMax = 600;
        int precioMin = 80;

        for (int i = 0; i < 1000; i++) { // Repeticion
            int resultado = Mercado.cambiarPrecios(precioMax, precioMin);
            Assertions.assertTrue("El resultado debe estar dentro del rango", resultado >= precioMin && resultado <= precioMax);
        }
    }

}
