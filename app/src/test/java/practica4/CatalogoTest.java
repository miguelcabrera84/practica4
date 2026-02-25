package Practica4.app.src.test.java.practica4;

import org.junit.jupiter.api.Test;

import Practica4.app.src.main.java.practica4.Catalogo;
import Practica4.app.src.main.java.practica4.Pelicula;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CatalogoTest {
    private Catalogo catalogo;
    private Pelicula rocky1;
    private Pelicula rocky2;
    private Pelicula rocky3;
    
    // Para capturar la salida de consola
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        rocky1 = new Pelicula("Rocky", "John G. Avildsen", 1976, "Drama/Deportes", 120);
        rocky2 = new Pelicula("Rocky II", "Sylvester Stallone", 1979, "Drama/Deportes", 119);
        rocky3 = new Pelicula("Rocky III", "Sylvester Stallone", 1982, "Drama/Deportes", 99);
        
        //para capturar lo que imprime
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterEach
    void tearDown() {
        // Restaurar el sistem.out
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    void testAgregarPelicula() {
        catalogo.agregarPelicula(rocky1);
        String salida = outContent.toString();
        assertTrue(salida.contains("Película agregada: Rocky (1976)"));
        
        outContent.reset();
        catalogo.agregarPelicula(rocky2);
        salida = outContent.toString();
        assertTrue(salida.contains("Película agregada: Rocky II (1979)"));
        
        outContent.reset();
        catalogo.agregarPelicula(rocky3);
        salida = outContent.toString();
        assertTrue(salida.contains("Película agregada: Rocky III (1982)"));
    }

    @Test
    void testMostrarPeliculas_CatalogoVacio() {
        catalogo.mostrarPeliculas();
        String salida = outContent.toString();
        assertTrue(salida.contains("No hay películas en el catálogo"));
    }

    @Test
    void testMostrarPeliculas_ConPeliculas() {
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        catalogo.agregarPelicula(rocky3);
        outContent.reset();
        
        catalogo.mostrarPeliculas();
        String salida = outContent.toString();
        
        assertTrue(salida.contains("=== LISTA DE PELÍCULAS ==="));
        assertTrue(salida.contains("1. Rocky (1976)"));
        assertTrue(salida.contains("2. Rocky II (1979)"));
        assertTrue(salida.contains("3. Rocky III (1982)"));
    }

    @Test
    void testBuscarPelicula_Existente() {
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        catalogo.agregarPelicula(rocky3);
        outContent.reset();
        
        catalogo.buscarPelicula("Rocky II");
        String salida = outContent.toString();
        
        assertTrue(salida.contains("=== BUSCANDO PELÍCULA: Rocky II ==="));
        assertTrue(salida.contains("¡PELÍCULA ENCONTRADA!"));
        assertTrue(salida.contains("Rocky II"));
        assertTrue(salida.contains("Sylvester Stallone"));
        assertTrue(salida.contains("1979"));
    }

    @Test
    void testBuscarPelicula_Existente_Rocky1() {
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        catalogo.agregarPelicula(rocky3);
        outContent.reset();
        
        catalogo.buscarPelicula("Rocky");
        String salida = outContent.toString();
        
        assertTrue(salida.contains("=== BUSCANDO PELÍCULA: Rocky ==="));
        assertTrue(salida.contains("¡PELÍCULA ENCONTRADA!"));
        assertTrue(salida.contains("Rocky"));
        assertTrue(salida.contains("John G. Avildsen"));
        assertTrue(salida.contains("1976"));
    }

    @Test
    void testBuscarPelicula_Existente_Rocky3() {
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        catalogo.agregarPelicula(rocky3);
        outContent.reset();
        
        catalogo.buscarPelicula("Rocky III");
        String salida = outContent.toString();
        
        assertTrue(salida.contains("=== BUSCANDO PELÍCULA: Rocky III ==="));
        assertTrue(salida.contains("¡PELÍCULA ENCONTRADA!"));
        assertTrue(salida.contains("Rocky III"));
        assertTrue(salida.contains("Sylvester Stallone"));
        assertTrue(salida.contains("1982"));
    }

    @Test
    void testBuscarPelicula_NoExistente() {
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        catalogo.agregarPelicula(rocky3);
        outContent.reset();
        
        catalogo.buscarPelicula("Titanic");
        String salida = outContent.toString();
        
        assertTrue(salida.contains("No se encontró la película: Titanic"));
    }

    @Test
    void testBuscarPelicula_CaseInsensitive() {
        catalogo.agregarPelicula(rocky1);
        outContent.reset();
        
        catalogo.buscarPelicula("rocky");
        String salida = outContent.toString();
        assertTrue(salida.contains("¡PELÍCULA ENCONTRADA!"));
        
        outContent.reset();
        catalogo.buscarPelicula("ROCKY");
        salida = outContent.toString();
        assertTrue(salida.contains("¡PELÍCULA ENCONTRADA!"));
        
        outContent.reset();
        catalogo.buscarPelicula("rOcKy");
        salida = outContent.toString();
        assertTrue(salida.contains("¡PELÍCULA ENCONTRADA!"));
    }

    @Test
    void testBuscarPelicula_CatalogoVacio() {
        outContent.reset();
        
        catalogo.buscarPelicula("Rocky");
        String salida = outContent.toString();
        
        assertTrue(salida.contains("No se encontró la película: Rocky"));
    }
}