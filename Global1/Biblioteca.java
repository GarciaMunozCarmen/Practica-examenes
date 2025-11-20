import java.util.Arrays;
import java.util.Locale;

/** NO MODIFICAR: modelo simple de libro */
class Libro {
    private final String titulo;
    private final String autor;
    private final int paginas;
    private final int ejemplares; // >0 disponible

    public Libro(String titulo, String autor, int paginas, int ejemplares) {
        this.titulo = titulo; this.autor = autor; this.paginas = paginas; this.ejemplares = ejemplares;
    }
    public String getTitulo(){ return titulo; }
    public String getAutor(){ return autor; }
    public int getPaginas(){ return paginas; }
    public int getEjemplares(){ return ejemplares; }

    @Override public String toString(){
        return String.format(Locale.US, "%s (%s) - %dp - %s",
                titulo, autor, paginas, ejemplares>0? "disp":"no disp");
    }
}

public class Biblioteca {

    /**
     * Muestra cada libro en una línea, usando toString() del libro.
     * Recorre el array por índice o for-each y haz System.out.println(libro).
     */
    public static void listar(Libro[] cat) {
        for (Libro libro : cat) {
            System.out.println(libro.toString());
        }
    }

    /**
     * Devuelve el índice del libro cuyo título coincide EXACTO (ignorando mayúsculas/minúsculas).
     * Si no existe, devuelve -1.
     */
    public static int buscarTitulo(Libro[] cat, String texto) {
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].getTitulo().equalsIgnoreCase(texto)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Devuelve un NUEVO array con los libros que tienen ejemplares > 0 (disponibles).
     * Mantén el mismo orden. No alteres el array original.
     */
    public static Libro[] soloDisponibles(Libro[] cat) {
        int cuenta = 0;
        for (int i = 0; i < cat.length; i++) {
            if(cat[i].getEjemplares() > 0){
                cuenta++;
            }
        }
        Libro[] disponibles = new Libro[cuenta];
        int j = 0;
        for (int i = 0; i < cat.length; i++) {
            if(cat[i].getEjemplares() > 0){
                disponibles[j++] = cat[i];
            }
        }
        return disponibles;
    }

    /**
     * Devuelve el “número de páginas habitual” del catálogo:
     * suma todas las páginas y divide entre cuántos libros hay.
     * Si el array está vacío, devuelve 0.0.
     */
    public static double paginasHabituales(Libro[] cat) {
        int suma = 0;
        for (int i = 0; i < cat.length; i++) {
            suma += cat[i].getPaginas();
        }
        double media = suma / cat.length;
        return media;
    }

    /**
     * Devuelve el índice del libro con MÁS páginas.
     * En caso de empate, quédate con el primero que aparezca.
     * Si el array está vacío, devuelve -1.
     */
    public static int indiceMasLargo(Libro[] cat) {
        Libro masLargo = cat[0];
        for (int i = 0; i < cat.length; i++) {
            if(masLargo.getPaginas() < cat[i].getPaginas()){
                masLargo = cat[i];
            }
        }
        return buscarTitulo(cat, masLargo.getTitulo());
    }

    public static void main(String[] args) {
        Libro[] datos = {
                new Libro("El viento", "A. Ruiz", 320, 2),
                new Libro("Niebla", "M. Unamuno", 240, 0),
                new Libro("La isla", "P. Mena", 410, 3),
                new Libro("Cuentos", "V. Soto", 150, 1)
        };
        // Pruebas rápidas
        listar(datos);
        System.out.println("Titulo 'Niebla': " + buscarTitulo(datos, "niebla"));
        System.out.println("Disponibles: " + Arrays.toString(soloDisponibles(datos)));
        System.out.printf(Locale.US, "Paginación típica: %.1f%n", paginasHabituales(datos));
        System.out.println("Más largo idx: " + indiceMasLargo(datos));
    }
}