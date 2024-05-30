
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

    @Test
    public void comprobacionCalcularPremioLoteria() {
	int maxGanancias = CiudadAcividad.MAX_GANANCIAS_LOTERIA;
        int minGanancias = CiudadAcividad.MIN_GANANCIAS_LOTERIA;

        for (int i = 0; i < 1000; i++) {
            int premio = CiudadAcividad.calcularPremioLoteria();
            assertTrue("El premio debe estar dentro del rango", premio >= minGanancias && premio <= maxGanancias);
        }
    }

    @Test
    public void comprobacionAumentarCostoSalud() {
        Assertions.assertEquals(500, CiudadActividad.aumentarCosto("Salud"));
    }
    @Test
    public void comprobacionAumentarCostoEspacio() {
        Assertions.assertEquals(250, CiudadActividad.aumentarCosto("Espacio"));
    }

    @Test
    public void comprobacionAumentarCostoLoteria() {
        Assertions.assertEquals(2500, CiudadActividad.aumentarCosto("Loteria"));
    }
}
