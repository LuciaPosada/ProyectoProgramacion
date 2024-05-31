import com.lucia.actividades.Mercado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MercadoTest {

    @Test
    public void comprobacionRenovarCantidades() {
        int cantidadMax = 40;
        int cantidadMin = 15;

        for (int i = 0; i < 1000; i++) { // Repeticion
            int resultado = Mercado.renovarCantidades(cantidadMax, cantidadMin);
            Assertions.assertTrue(resultado >= cantidadMin && resultado <= cantidadMax);
        }
    }

    @Test
    public void comprobacionCambiarPrecios() {
        int precioMax = 600;
        int precioMin = 80;

        for (int i = 0; i < 1000; i++) { // Repeticion
            int resultado = Mercado.cambiarPrecios(precioMax, precioMin);
            Assertions.assertTrue(resultado >= precioMin && resultado <= precioMax);
        }
    }

}
