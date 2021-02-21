/*
# crear un programa que pida al usuario un carácter
# después pida un numero (ancho)
# después otro numero (alto)
#
# el programa después debera
# imprimir un rectángulo usando ese carácter, con las medidas que se le especificaron
#
# al pedir los datos el programa debera validar:
#
#       - que solo sea un carácter el especificado,
#       si se reciben mas, pedir al usuario nuevamente el dato,
#       asi, sucesivamente hasta que sea solo un carácter
#
#       - que el ancho sea un numero entero
#       de no ser un numero entero, pedir el dato de nuevo al usuario
#
#       - que el alto sea un numero entero
#       de no ser un numero entero, pedir el dato de nuevo al usuario
#
#
# ejemplo:
#
#   carácter: *
#   ancho: 5
#   alto: 3
#
#   *****
#   *****
#   *****
* */

package proyectosjava;

import java.util.Scanner;

public class ejercicio62 {

    public static void main(String[] args) {
        String caracter = pedirCaracter();
        int ancho = pedirDimension("ancho");
        int alto = pedirDimension("alto");
        imprimirForma(caracter, ancho, alto);

    }

    public static String pedirCaracter() {
        Scanner inCaracter = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese un caracter: ");
            String caracter = inCaracter.nextLine();
            if (validarCaracter(caracter)) {
                return caracter;
            }
            else {
                System.out.println("Ingreso mas de un caracter");
            }
        }
    }

    public static boolean validarCaracter(String caracter) {
        return caracter.length() == 1;
    }

    public static int pedirDimension(String  direccion) {
        while (true) {
            Scanner inDimension = new Scanner(System.in);
            try {
                System.out.print("Ingrese el " + direccion + ": ");
                int dimension = Integer.parseInt(inDimension.nextLine());
                return dimension;
            }
            catch (NumberFormatException e) {
                System.out.println("No ingreso un numero entero");
            }
        }
    }

    public static void imprimirForma(String caracter, int ancho, int alto) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                System.out.print(caracter);
            }
            System.out.println("");
        }
    }
}
