package practica4;

import java.util.ArrayList;

/**
 * Clase que representa el catálogo de películas
 */
public class Catalogo {
    
    /** Lista donde se guardan las películas */
    private ArrayList<Pelicula> peliculas;

    /**
     * Constructor que crea un catálogo vacío
     */
    public Catalogo() {
        peliculas = new ArrayList<>();
    }

    /**
     * Agrega una película al catálogo
     * @param pelicula La película que se va a agregar
     */
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Película agregada: " + pelicula.toString());
    }

    /**
     * Muestra todas las películas del catálogo
     */
    public void mostrarPeliculas() {
        System.out.println("\n=== LISTA DE PELÍCULAS ===");
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas en el catálogo.");
        } else {
            for (int i = 0; i < peliculas.size(); i++) {
                System.out.println((i + 1) + ". " + peliculas.get(i).toString());
            }
        }
    }

    /**
     * Busca una película por su título
     * @param titulo El título de la película a buscar (no importa mayúsculas/minúsculas)
     */
    public void buscarPelicula(String titulo) {
        System.out.println("\n=== BUSCANDO PELÍCULA: " + titulo + " ===");
        
        for (Pelicula p : peliculas) {
            if (p.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("¡PELÍCULA ENCONTRADA!");
                System.out.println(p.getInformation());
                return;
            }
        }
        
        System.out.println("No se encontró la película: " + titulo);
    }
}