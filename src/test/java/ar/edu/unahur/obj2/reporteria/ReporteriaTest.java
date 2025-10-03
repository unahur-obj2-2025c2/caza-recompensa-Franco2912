package ar.edu.unahur.obj2.reporteria;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.cazadores.CazadorSigiloso;
import ar.edu.unahur.obj2.cazadores.CazadorUrbano;
import ar.edu.unahur.obj2.profugos.ArteMarcialAvanzado;
import ar.edu.unahur.obj2.profugos.EntrenamientoElite;
import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.profugos.Profugo;
import ar.edu.unahur.obj2.profugos.ProteccionLegal;
import ar.edu.unahur.obj2.zonas.Zona;

class ReporteriaTest {

    Zona zona1 = new Zona("Zona 1");
    Zona zona2 = new Zona("Zona 2");
    
    Cazador sigiloso = new CazadorSigiloso(40);
    Cazador urbano = new CazadorUrbano(50);

    IProfugo profugoSimple1 = new Profugo(30, 26, false);
    IProfugo conArteMarcial = new ArteMarcialAvanzado(new Profugo(30, 26, false));
    IProfugo conProteccionLegal = new ProteccionLegal(new Profugo(30, 3, false));

    IProfugo profugoSimpe2 = new Profugo(30, 26, true);
    IProfugo conEntrenamiento = new EntrenamientoElite(new Profugo(30, 26, true));
    IProfugo conArteMarcialYEntrenamiento = new ArteMarcialAvanzado(new EntrenamientoElite(new Profugo(30, 33, true)));

    Reporteria reporteria = new Reporteria(Arrays.asList(sigiloso, urbano));

    @BeforeEach
    void setUp() {
        zona1.vaciarProfugos();
        zona1.agregarProfugo(profugoSimple1);
        zona1.agregarProfugo(conArteMarcial);
        zona1.agregarProfugo(conProteccionLegal);

        zona2.vaciarProfugos();
        zona2.agregarProfugo(profugoSimpe2);
        zona2.agregarProfugo(conEntrenamiento);
        zona2.agregarProfugo(conArteMarcialYEntrenamiento);

    }


    @Test
    void testAgenciaProcesarCaptura()  {
        reporteria.procesoCaptura(sigiloso, zona1);
        reporteria.procesoCaptura(urbano, zona2);
        assertEquals(3, reporteria.cantidadDeProfugosCaptudados());
        assertEquals(urbano, reporteria.cazadorConMasCaptudas());
        assertEquals(conArteMarcialYEntrenamiento, reporteria.profugoMasHabil());
    }

    @Test
    void testCazadorConMasCaptudas() {

    }

    @Test
    void testProfugoMasHabil() {

    }
}
