package examen1p1_gabrielzelaya;
import java.util.Scanner;

public class Examen1P1_GabrielZelaya {
    
    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        int menu;
        do {
            System.out.println("----------Menú----------");
            System.out.println("(1)Conjuntos \n(2)Cifrado por substitución \n(3)Sobre \n(4)Salir");
            menu = entrada.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Ingrese el primer conjunto con la estructura adecuada: ");
                    entrada = new Scanner(System.in);
                    String conjunto1 = entrada.next();
                    System.out.println("Ingrese el segundo conjunto con la estructura adecuada: ");
                    String conjunto2 = entrada.next();
                    conjuntos(conjunto1,conjunto2);
                    break;
                case 2:
                    System.out.println("Ingrese una cadena: ");
                    entrada = new Scanner(System.in);
                    String str = entrada.next();
                    cifrado(str);
                    break;
                case 3:
                    System.out.println("Ingrese un número par: ");
                    int par = entrada.nextInt();
                    System.out.println("Ingrese un caracter: ");
                    char c = entrada.next().charAt(0);
                    sobres(par,c);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("El número que ingresó no es válido, intente de nuevo");
                    break;
            }
        }while(menu != 4);
        if (menu ==4) {
            System.out.println("Saliendo del menú");
        }
    }
    
    public static void conjuntos(String str1, String str2){
        String con1 = str1, con2 = str2;
        boolean formaCorrecta = false;
        if ( (con1.startsWith("{") && con1.endsWith("}")) ) {
            formaCorrecta = true;
        }
        
        if ( (con2.startsWith("{") && con2.endsWith("}")) ) {
            formaCorrecta = true;
        }
        
        if (formaCorrecta == true) {
            boolean sonIguales = false;
            String letrasRepetidas = ""; 
            con1 = con1.replace("{", "");
            con1 = con1.replace("}","");
            
            con2 = con2.replace("{","");
            con2 = con2.replace("}","");
            
            String union = con1 + "," + con2;

            con2 = con2.replace(",","");
            con1 = con1.replace(",", "");
            
            for (int i = 0; i < con1.length(); i++) {
                for (int j = 0; j < con2.length(); j++) {
                    char letra1 = con1.charAt(i);
                    char letra2 = con2.charAt(j);
                    if (letra1 == letra2) {
                        letrasRepetidas = letrasRepetidas + letra1;
                    }
                }
            }
            if (letrasRepetidas.length() == con1.length()) {
                sonIguales = true;
            }
            
            
            if (sonIguales == true) {
                System.out.println("Ambos conjuntos son iguales");
            } else if( (sonIguales == false) && (letrasRepetidas.length() > 0)) {
                System.out.println("Ambos conjuntos no son iguales");
                System.out.println("Unión: " + "{" + union + "}");
                System.out.println("Intersección: " + "{" + letrasRepetidas + "}");
            } else {
                System.out.println("Ambos conjuntos no son iguales");
                System.out.println("Unión: " + "{" + union + "}");
                System.out.println("Intersección: {0}");    
            }
        } else {
            System.out.println("Ingresó el formato equivocado");
        }
    }
    
    public static void cifrado(String str1){
        String cadena = str1;
        cadena = cadena.toLowerCase();
        String cifrado = "";
        for (int i = 0; i < cadena.length(); i++) {
            char letra = cadena.charAt(i);
            int ascii = (int)letra;
            int calc = 97+ascii-122;
            char nuevaLetra = (char)calc;
            cifrado = cifrado + nuevaLetra;
        }
        System.out.println(cifrado);     
    }
    
    public static void sobres(int par, char character){
        int numero = par;
        char c = character;
        int tamaño = numero * 2;
        for (int i = 0; i < tamaño.length(); i++) {
            System.out.println(c);
            for (int j = 0; j < tamaño.length(); j++) {
                System.out.print(c);
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
    
}
