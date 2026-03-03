package practica4;

import java.util.ArrayList;

/**
 * Clase que representa un catálogo de películas.
 * Permite agregar, mostrar y buscar películas en una colección.
 * 
 * @author Miguel
 * @version 1.0
 */
public class Catalogo {
    
    private ArrayList<Pelicula> peliculas;

    /**
     * Constructor que crea un catálogo vacío con capacidad por defecto.
     */
    public Catalogo() {
        peliculas = new ArrayList<>();
    }
    
    /**
     * Constructor que crea un catálogo con una capacidad inicial específica.
     * 
     * @param capacidad La capacidad inicial del catálogo. Debe ser mayor a 0.
     * @throws IllegalArgumentException si la capacidad es menor o igual a 0
     */
    public Catalogo(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad del catálogo debe ser mayor a 0.");
        }
        peliculas = new ArrayList<>(capacidad);
    }

    /**
     * Agrega una película al catálogo.
     * 
     * @param pelicula La película que se va a agregar. No puede ser nula.
     * @throws IllegalArgumentException si la película es nula
     */
    public void agregarPelicula(Pelicula pelicula) {
        if (pelicula == null) {
            throw new IllegalArgumentException("No se puede agregar una película nula.");
        }
        peliculas.add(pelicula);
        System.out.println("Película agregada: " + pelicula.toString());
    }

    /**
     * Muestra todas las películas del catálogo por consola.
     * Si el catálogo está vacío, muestra un mensaje indicándolo.
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
     * Busca una película por su título y muestra el resultado por consola.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     * 
     * @param titulo El título de la película a buscar
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
    
    /**
     * Busca una película por su título y la retorna.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     * 
     * @param titulo El título de la película a buscar. No puede ser nulo o vacío.
     * @return La película encontrada, o null si no existe
     * @throws IllegalArgumentException si el título es nulo o está vacío
     */
    public Pelicula buscarPeliculaPorTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El término de búsqueda no puede estar vacío.");
        }
        for (Pelicula p : peliculas) {
            if (p.getTitulo().equalsIgnoreCase(titulo)) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Obtiene una copia de la lista de películas del catálogo.
     * 
     * @return ArrayList con todas las películas del catálogo
     */
    public ArrayList<Pelicula> getPeliculas() {
        return new ArrayList<>(peliculas);
    }
    
    /**
     * Obtiene la cantidad de películas en el catálogo.
     * 
     * @return número de películas en el catálogo
     */
    public int getCantidadPeliculas() {
        return peliculas.size();
    }
    
    /**
     * Obtiene información formateada del catálogo.
     * Si está vacío, retorna un mensaje indicándolo.
     * Si tiene películas, muestra cada una con título, año y director.
     * 
     * @return String con la información del catálogo
     */
    public String getInformacion() {
        if (peliculas.isEmpty()) {
            return "El catálogo está vacío.";
        }
        StringBuilder info = new StringBuilder();
        for (Pelicula p : peliculas) {
            info.append("- ")
                .append(p.getTitulo())
                .append(" (").append(p.getAñoEstreno()).append("), Dir: ")
                .append(p.getDirector())
                .append("\n");
        }
        return info.toString().trim();
    }
}