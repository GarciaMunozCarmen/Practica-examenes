import java.util.Scanner;

public class Reemplazo {
    public static String buscaYReemplaza(String textoOriginal, String textoBuscar, String nuevoTexto){
        if (textoOriginal.contains(textoBuscar)) {
            return textoOriginal.replace(textoBuscar, nuevoTexto);
        }else{
            return "Texto no encontrado";
        }
    }
    public static char buscarLetra(String texto, int posición){
        if(texto.length() < posición){
            return ' ';
        }
        return texto.charAt(posición);
    }
    public static int buscarOcurrencias(String texto, char letra){
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == letra){
                contador++;
            }
        }
        return contador;
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Introduce un texto: ");
    String texto = sc.nextLine();
    System.out.print("Introduce el texto que quieres buscar: ");
    String buscar = sc.nextLine();
    System.out.print("Introduce el texto por el que quieres reemplazar: ");
    String reemplazo = sc.nextLine();
    String textoCambiado = buscaYReemplaza(texto, buscar, reemplazo);
    System.out.printf("Texto cambiado: %s%n",textoCambiado);
    System.out.print("Introduce la posición de la letra que quieres buscar: ");
    int numero = sc.nextInt();
    char letraBuscada = buscarLetra(textoCambiado, numero); 
    System.out.printf("La letra en la posición %d es: %c%n", numero, letraBuscada);
    System.out.print("Introduce la letra qeu quieres contar: ");
    sc.close();
}
     
}