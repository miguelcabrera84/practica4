package Practica4.app.src.test.java.practica4;

import org.junit.jupiter.api.Test;

import Practica4.app.src.main.java.practica4.Pelicula;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    @Test
    void testEsClasica() {
        //3 peliculas de Rocky
        Pelicula rocky1 = new Pelicula("Rocky", "John G. Avildsen", 1976, "Drama/Deportes", 120);
        Pelicula rocky2 = new Pelicula("Rocky II", "Sylvester Stallone", 1979, "Drama/Deportes", 119);
        Pelicula rocky3 = new Pelicula("Rocky III", "Sylvester Stallone", 1982, "Drama/Deportes", 99);
        
        // Verificaciones
        assertTrue(rocky1.esClasica());
        assertTrue(rocky2.esClasica());
        assertTrue(rocky3.esClasica());
    }

    @Test
    void testGetInformation() {
        Pelicula pelicula = new Pelicula("Rocky", "John G. Avildsen", 1976, "Drama/Deportes", 120);
        
        String infoEsperada = "Título: Rocky\n" +
               "Director: John G. Avildsen\n" +
               "Año de estreno: 1976\n" +
               "Género: Drama/Deportes\n" +
               "Duración: 120 minutos\n";
        
        assertEquals(infoEsperada, pelicula.getInformation());
    }

    @Test
    void testGetTitulo() {
        Pelicula pelicula = new Pelicula("Rocky II", "Sylvester Stallone", 1979, "Drama/Deportes", 119);
        
        assertEquals("Rocky II", pelicula.getTitulo());
    }

    @Test
    void testToString() {
        Pelicula pelicula = new Pelicula("Rocky III", "Sylvester Stallone", 1982, "Drama/Deportes", 99);
        
        String esperado = "Rocky III (1982) - Drama/Deportes - 99 min - dur Sylvester Stallone";
        assertEquals(esperado, pelicula.toString());
    }
}