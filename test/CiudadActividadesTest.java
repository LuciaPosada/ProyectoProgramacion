
import com.lucia.actividades.CiudadActividad;
import com.lucia.actividades.CompraVenta;
import com.lucia.producto.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CiudadActividadesTest {

    // No he podido comprobar que los test funcionen

    @Test
    public void comprobacionIrHospital() {
        Assertions.assertEquals(90, CiudadActividad.irHospital(70));
    }

}
