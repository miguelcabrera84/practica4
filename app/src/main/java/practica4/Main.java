package practica4;

/**
 * Clase principal para probar el catálogo de películas
 */
public class Main {
    
    /**
     * Método principal que ejecuta el programa
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {
        
        //*Crear catálogo
        Catalogo catalogo = new Catalogo();

        //*
        // Crear películas de ROCKY  */
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

        // Agregar películas al catálogo
        catalogo.agregarPelicula(rocky1);
        catalogo.agregarPelicula(rocky2);
        catalogo.agregarPelicula(rocky3);

        // Mostrar todas las películas
        catalogo.mostrarPeliculas();

        // Buscar una película específica
        catalogo.buscarPelicula("Rocky II");
        
        // Probar método esClasica()
        System.out.println("\n=== ¿SON CLÁSICAS? ===");
        System.out.println(rocky1.getTitulo() + " ¿clásica? " + (rocky1.esClasica() ? "Sí" : "No"));
        System.out.println(rocky2.getTitulo() + " ¿clásica? " + (rocky2.esClasica() ? "Sí" : "No"));
        System.out.println(rocky3.getTitulo() + " ¿clásica? " + (rocky3.esClasica() ? "Sí" : "No"));
    }
}