package practica4;

/**
 * Representa una película con toda su información relevante.
 * Incluye título, director, año de estreno, género y duración.
 * Proporciona métodos para obtener información y determinar si es clásica.
 * 
 * @author Miguel
 * @version 1.0
 */
public class Pelicula {
    
    private String titulo;
    private String director;
    private int añoEstreno;
    private String genero;
    private int duracion;

    /**
     * Constructor que inicializa todos los datos de la película.
     * Realiza validaciones para asegurar que los datos sean correctos.
     * 
     * @param titulo Título de la película. No puede ser nulo o vacío.
     * @param director Director de la película. No puede ser nulo o vacío.
     * @param añoEstreno Año de estreno. Debe ser mayor a 1888.
     * @param genero Género de la película. No puede ser nulo o vacío.
     * @param duracion Duración en minutos. Debe ser mayor a 0.
     * @throws IllegalArgumentException si algún parámetro no cumple las validaciones
     */
    public Pelicula(String titulo, String director, int añoEstreno, String genero, int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a 0 minutos.");
        }
        if (añoEstreno < 1888) { 
            throw new IllegalArgumentException("El año de lanzamiento es inválido.");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        if (director == null || director.trim().isEmpty()) {
            throw new IllegalArgumentException("El director no puede estar vacío.");
        }
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("El género no puede estar vacío.");
        }
        
        this.titulo = titulo;
        this.director = director;
        this.añoEstreno = añoEstreno;
        this.genero = genero;
        this.duracion = duracion;
    }
    
    /**
     * Obtiene el título de la película.
     * 
     * @return el título de la película
     */
    public String getTitulo(){
        return titulo;
    }
    
    /**
     * Obtiene el director de la película.
     * 
     * @return el director de la película
     */
    public String getDirector() { 
        return director; 
    }
    
    /**
     * Obtiene el año de estreno de la película.
     * 
     * @return el año de estreno
     */
    public int getAñoEstreno() { 
        return añoEstreno; 
    }
    
    /**
     * Obtiene el género de la película.
     * 
     * @return el género de la película
     */
    public String getGenero() { 
        return genero; 
    }
    
    /**
     * Obtiene la duración de la película en minutos.
     * 
     * @return la duración en minutos
     */
    public int getDuracion() { 
        return duracion; 
    }
    
    /**
     * Regresa la información completa de la película formateada.
     * Incluye título, director, año, género y duración.
     * 
     * @return Cadena con toda la información de la película
     */
    public String getInformation() {
        return "Título: " + titulo + "\n" +
               "Director: " + director + "\n" +
               "Año de estreno: " + añoEstreno + "\n" +
               "Género: " + genero + "\n" +
               "Duración: " + duracion + " minutos\n";
    }
    
    /**
     * Determina si la película es clásica usando el año actual fijo (2026).
     * Una película es clásica si tiene más de 25 años desde su estreno.
     * 
     * @return true si la película es clásica, false en caso contrario
     */
    public boolean esClasica() {
        int añoActual = 2026;
        return (añoActual - añoEstreno) > 25;
    }
    
    /**
     * Determina si la película es clásica usando un año específico.
     * Este método es útil para pruebas unitarias.
     * 
     * @param añoActual El año actual para realizar el cálculo
     * @return true si la película es clásica, false en caso contrario
     */
    public boolean esClasica(int añoActual) {
        return (añoActual - añoEstreno) > 25;
    }
    
    /**
     * Representación de la película en formato corto.
     * Incluye título, año, género, duración y director.
     * 
     * @return Cadena con la representación corta de la película
     */
    @Override
    public String toString() {
        return titulo + " (" + añoEstreno + ") - " +
               genero + " - " + duracion + " min - dur " + 
               director;
    }
}