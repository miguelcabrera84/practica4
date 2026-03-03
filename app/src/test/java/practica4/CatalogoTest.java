package practica4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Clase de pruebas unitarias para la clase Catalogo.
 * Verifica el correcto funcionamiento de todos los métodos
 * de la clase Catalogo.
 * 
 * @author Miguel
 * @version 1.0
 */
public class CatalogoTest {
    
    private Catalogo catalogo;
    private Pelicula rocky1;
    private Pelicula rocky2;
    private Pelicula rocky3;
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Configuración inicial antes de cada prueba.
     * Crea el catálogo y las películas necesarias,
     * y redirige System.out para capturar la salida.
     */
    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        rocky1 = new Pelicula("Rocky", "John G. Avildsen", 1976, "Drama/Deportes", 120);
        rocky2 = new Pelicula("Rocky II", "Sylvester Stallone", 1979, "Drama/Deportes", 119);
        rocky3 = new Pelicula("Rocky III", "Sylvester Stallone", 1982, "Drama/Deportes", 99);
        
        System.setOut(new PrintStream(outContent));
    }
    
    /**
     * Limpieza después de cada prueba.
     * Restaura System.out y limpia el buffer de salida.
     */
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    /**
     * Prueba el método agregarPelicula().
     * Verifica que las películas se agreguen correctamente.
     */
    @Test
    @DisplayName("Test: agregarPelicula")
    void testAgregarPelicula() {
        catalogo.agregarPelicula(rocky1);
        String salida = outContent.toString();
        assertTrue(salida.contains("Película agregada: Rocky (1976)"));
        assertEquals(1, catalogo.getCantidadPeliculas());
    }

    /**
     * Prueba el método getPeliculas().
     * Verifica que retorne una copia correcta de la lista.
     */
    @Test
    @DisplayName("Test: getPeliculas")
    void testGetPeliculas() {
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        
        ArrayList<Pelicula> peliculas = catalogo.getPeliculas();
        assertEquals(2, peliculas.size());
        assertEquals("Rocky", peliculas.get(0).getTitulo());
        assertEquals("Rocky II", peliculas.get(1).getTitulo());
    }

    /**
     * Prueba el método getInformacion() con catálogo vacío.
     */
    @Test
    @DisplayName("Test: getInformacion - Catálogo vacío")
    void testGetInformacion_Vacio() {
        assertEquals("El catálogo está vacío.", catalogo.getInformacion());
    }

    /**
     * Prueba el método getInformacion() con películas.
     */
    @Test
    @DisplayName("Test: getInformacion - Con películas")
    void testGetInformacion_ConPeliculas() {
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        
        String info = catalogo.getInformacion();
        assertTrue(info.contains("Rocky (1976)"));
        assertTrue(info.contains("Rocky II (1979)"));
    }

    /**
     * Prueba el método mostrarPeliculas().
     */
    @Test
    @DisplayName("Test: mostrarPeliculas")
    void testMostrarPeliculas() {
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        outContent.reset();
        
        catalogo.mostrarPeliculas();
        String salida = outContent.toString();
        
        assertTrue(salida.contains("1. Rocky (1976)"));
        assertTrue(salida.contains("2. Rocky II (1979)"));
    }

    /**
     * Prueba el método buscarPelicula() con título existente.
     */
    @Test
    @DisplayName("Test: buscarPelicula - Existente")
    void testBuscarPelicula_Existente() {
        catalogo.agregarPelicula(rocky1);
        outContent.reset();
        
        catalogo.buscarPelicula("Rocky");
        String salida = outContent.toString();
        
        assertTrue(salida.contains("¡PELÍCULA ENCONTRADA!"));
    }

    /**
     * Prueba el método buscarPelicula() con título no existente.
     */
    @Test
    @DisplayName("Test: buscarPelicula - No existente")
    void testBuscarPelicula_NoExistente() {
        catalogo.agregarPelicula(rocky1);
        outContent.reset();
        
        catalogo.buscarPelicula("Titanic");
        String salida = outContent.toString();
        
        assertTrue(salida.contains("No se encontró la película: Titanic"));
    }

    /**
     * Prueba el método buscarPeliculaPorTitulo() con diferentes combinaciones
     * de mayúsculas y minúsculas.
     */
    @Test
    @DisplayName("Test: buscarPeliculaPorTitulo - Case Insensitive")
    void testBuscarPeliculaPorTitulo_CaseInsensitive() {
        catalogo.agregarPelicula(rocky1);
        
        Pelicula encontrada = catalogo.buscarPeliculaPorTitulo("rocky");
        assertNotNull(encontrada);
        assertEquals("Rocky", encontrada.getTitulo());
    }
}