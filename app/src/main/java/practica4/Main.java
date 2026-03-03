package practica4;

/**
 * Clase principal para probar el catálogo de películas.
 * Demuestra la funcionalidad de las clases Pelicula y Catalogo
 * con un ejemplo de las películas de Rocky.
 * 
 * @author Miguel
 * @version 1.0
 */
public class Main {
    
    /**
     * Método principal que ejecuta el programa de demostración.
     * Crea un catálogo, agrega tres películas de Rocky,
     * las muestra y realiza búsquedas.
     * 
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        
        Catalogo catalogo = new Catalogo();

        Pelicula rocky1 = new Pelicula(
            "Rocky", 
            "John G. Avildsen", 
            1976, 
            "Drama/Deportes", 
            120
        );
        
        Pelicula rocky2 = new Pelicula(
            "Rocky II", 
            "Sylvester Stallone", 
            1979, 
            "Drama/Deportes", 
            119
        );
        
        Pelicula rocky3 = new Pelicula(
            "Rocky III", 
            "Sylvester Stallone", 
            1982, 
            "Drama/Deportes", 
            99
        );

        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        catalogo.agregarPelicula(rocky3);

        catalogo.mostrarPeliculas();

        catalogo.buscarPelicula("Rocky II");
        
        System.out.println("\n=== ¿SON CLÁSICAS? ===");
        System.out.println(rocky1.getTitulo() + " ¿clásica? " + (rocky1.esClasica() ? "Sí" : "No"));
        System.out.println(rocky2.getTitulo() + " ¿clásica? " + (rocky2.esClasica() ? "Sí" : "No"));
        System.out.println(rocky3.getTitulo() + " ¿clásica? " + (rocky3.esClasica() ? "Sí" : "No"));
    }
}