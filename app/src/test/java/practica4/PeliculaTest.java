package practica4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para la clase Pelicula.
 * Verifica el correcto funcionamiento de constructores, getters
 * y métodos de la clase Pelicula.
 * 
 * @author Miguel
 * @version 1.0
 */
public class PeliculaTest {
    
    private Pelicula rocky1;
    private Pelicula rocky2;
    private Pelicula rocky3;
    private Pelicula rockyBalboa;

    /**
     * Configuración inicial antes de cada prueba.
     * Crea las películas de Rocky necesarias para las pruebas.
     */
    @BeforeEach
    void setUp() {
        rocky1 = new Pelicula("Rocky", "John G. Avildsen", 1976, "Drama/Deportes", 120);
        rocky2 = new Pelicula("Rocky II", "Sylvester Stallone", 1979, "Drama/Deportes", 119);
        rocky3 = new Pelicula("Rocky III", "Sylvester Stallone", 1982, "Drama/Deportes", 99);
        rockyBalboa = new Pelicula("Rocky Balboa", "Sylvester Stallone", 2006, "Drama/Deportes", 102);
    }

    /**
     * Prueba el constructor y la persistencia de datos.
     * Verifica que todos los atributos se guarden correctamente
     * y que las validaciones funcionen adecuadamente.
     */
    @Test
    @DisplayName("Test: Constructor y persistencia de datos")
    void testConstructorYPersistenciaDatos() {
        assertEquals("Rocky", rocky1.getTitulo());
        assertEquals("John G. Avildsen", rocky1.getDirector());
        assertEquals(1976, rocky1.getAñoEstreno());
        assertEquals("Drama/Deportes", rocky1.getGenero());
        assertEquals(120, rocky1.getDuracion());
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Pelicula("", "Director", 2000, "Género", 120);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Pelicula("Título", null, 2000, "Género", 120);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Pelicula("Título", "Director", 1800, "Género", 120);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Pelicula("Título", "Director", 2000, "Género", 0);
        });
    }

    /**
     * Prueba el método esClasica().
     * Verifica que las películas antiguas sean clásicas
     * y las recientes no lo sean.
     */
    @Test
    @DisplayName("Test: esClasica")
    void testEsClasica() {
        assertTrue(rocky1.esClasica());
        assertTrue(rocky2.esClasica());
        assertTrue(rocky3.esClasica());
        assertFalse(rockyBalboa.esClasica());
    }

    /**
     * Prueba el método getInformation().
     * Verifica que la información formateada sea correcta.
     */
    @Test
    @DisplayName("Test: getInformation")
    void testGetInformation() {
        String infoEsperada = "Título: Rocky\n" +
               "Director: John G. Avildsen\n" +
               "Año de estreno: 1976\n" +
               "Género: Drama/Deportes\n" +
               "Duración: 120 minutos\n";
        
        assertEquals(infoEsperada, rocky1.getInformation());
    }

    /**
     * Prueba el método getTitulo().
     * Verifica que retorne el título correcto.
     */
    @Test
    @DisplayName("Test: getTitulo")
    void testGetTitulo() {
        assertEquals("Rocky", rocky1.getTitulo());
        assertEquals("Rocky II", rocky2.getTitulo());
        assertEquals("Rocky III", rocky3.getTitulo());
    }

    /**
     * Prueba el método getDirector().
     * Verifica que retorne el director correcto.
     */
    @Test
    @DisplayName("Test: getDirector")
    void testGetDirector() {
        assertEquals("John G. Avildsen", rocky1.getDirector());
        assertEquals("Sylvester Stallone", rocky2.getDirector());
    }

    /**
     * Prueba el método getAñoEstreno().
     * Verifica que retorne el año correcto.
     */
    @Test
    @DisplayName("Test: getAñoEstreno")
    void testGetAñoEstreno() {
        assertEquals(1976, rocky1.getAñoEstreno());
        assertEquals(1979, rocky2.getAñoEstreno());
        assertEquals(1982, rocky3.getAñoEstreno());
    }

    /**
     * Prueba el método toString().
     * Verifica la representación en cadena de la película.
     */
    @Test
    @DisplayName("Test: toString")
    void testToString() {
        String esperado = "Rocky III (1982) - Drama/Deportes - 99 min - dur Sylvester Stallone";
        assertEquals(esperado, rocky3.toString());
    }
}