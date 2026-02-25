package practica4;

/**
 * Representa una película
 */
public class Pelicula {
    
    /** Título de la película */
    private String titulo;
    
    /** Director de la película */
    private String director;
    
    /** Año en que se estrenó */
    private int añoEstreno;
    
    /** Género cinematográfico */
    private String genero;
    
    /** Duración en minutos */
    private int duracion;

    /**
     * Obtiene el título de la película
     * @return el título
     */
    public String getTitulo(){
        return titulo;
    }

    /**
     * Constructor que inicializa todos los datos de la película
     * @param titulo Título de la película
     * @param director Director de la película
     * @param añoEstreno Año de estreno
     * @param genero Género de la película
     * @param duracion Duración en minutos
     */
    public Pelicula(String titulo, String director, int añoEstreno, String genero, int duracion){
        this.titulo = titulo;
        this.director = director;
        this.añoEstreno = añoEstreno;
        this.genero = genero;
        this.duracion = duracion;
    }
    
    /**
     * Regresa la información completa de la película
     * @return Cadena con título, director, año, género y duración
     */
    public String getInformation() {
        return "Título: " + titulo + "\n" +
               "Director: " + director + "\n" +
               "Año de estreno: " + añoEstreno + "\n" +
               "Género: " + genero + "\n" +
               "Duración: " + duracion + " minutos\n";
    }
    
    /**
     * Determina si la película es clásica
     */
    public boolean esClasica() {
        int añoActual = 2026;
        return (añoActual - añoEstreno) > 25;
    }
    
    /**
     * Representación de la película en formato corto
     * @return Título, año, género, duración y director
     */
    public String toString() {
        return titulo + " (" + añoEstreno + ") - " +
               genero + " - " + duracion + " min - dur " + 
               director;
    }
}