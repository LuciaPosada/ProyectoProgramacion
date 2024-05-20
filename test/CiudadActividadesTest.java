
import com.lucia.actividades.CiudadActividad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CiudadActividadesTest {

    // No he podido comprobar que los test funcionen

    @Test
    public void comprobacionIrHospital() {
        Assertions.assertEquals(90, CiudadActividad.irHospital(70));
    }

    @Test
    public void comprobacionAumentarEspacio() {
        Assertions.assertEquals(75, CiudadActividad.aumentarEspacio(50));
    }

}
