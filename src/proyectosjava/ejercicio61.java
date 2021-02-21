/* # escriba un programa que pida al usuario una lista de números enteros separados por coma
#               similar al ejercicio 4
# después ofrezca las siguientes opciones
#
# 1) imprimir números pares
# 2) imprimir números impares
# 3) imprimir números primos
# 4) salir
#
# como siempre, si se selecciona una opción invalida, mostrar el mensaje "opción no valida"*/
package proyectosjava;

import ejercicio6.Alumno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio61 {
    public static void main(String[] args) {
        int[] cacharNumeros;
        try {
            cacharNumeros = recibirNumeros();
        }
        catch (NumberFormatException e) {
            System.out.print("los elementos que ingresaste no contienen unicamente numeros");
            return;
        }
        Scanner recibirirOpciones = new Scanner(System.in);
        while (true) {
            mensajeMenu();
            System.out.print("Ingrese una opción: ");
            String procesarOpcion = recibirirOpciones.nextLine();
            switch (procesarOpcion) {
                case "1":
                    System.out.println("");
                    System.out.println("Números pares: " + calcularNumerosPares(cacharNumeros) + "\n");
                    break;
                case "2":
                    System.out.println("");
                    System.out.println("Números impares: " + calcularNumerosImpares(cacharNumeros));
                    break;
                case "3":
                    System.out.println("");
                    System.out.println("Números primos: " + calcularNumerosPrimos(cacharNumeros));
                    break;
                case "4":
                    return;
                default:
                    imprimirError();
            }
        }

    }

    private static void mensajeMenu() {
        String menu = "\nOPCIONES: \n" +
                "\t 1) Imprimir números pares \n" +
                "\t 2) Imprimir números impares \n" +
                "\t 3) Imprimir números impares \n" +
                "\t 4) Salir \n";
        System.out.println(menu);
    }

    private static boolean esPar(int numero) {
        if (numero % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    private static int[] calcularNumerosPares(int... numeros) {
        List<Integer> listaPares = new ArrayList<>();
        for (int numero : numeros) {
            listaPares.add(numero);
        }
        return listaPares.stream().mapToInt(i -> i).toArray();
    }

    private static int[] calcularNumerosImpares(int... numeros) {
        List<Integer> listaPares = new ArrayList<>();
        for (int numero : numeros) {
            if (!esPar(numero)) {
                listaPares.add(numero);
            }
        }
        return listaPares.stream().mapToInt(i -> i).toArray();
    }

    private static boolean esPrimo(int numero) {
        int contadorDivisores = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                contadorDivisores++;
            }
        }
        if (contadorDivisores == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    private static int[] calcularNumerosPrimos(int... numeros) {
        List<Integer> listaPrimos = new ArrayList<>();
        for (int numero : numeros) {
            if (esPrimo(numero)) {
                listaPrimos.add(numero);
            }
        }
        return listaPrimos.stream().mapToInt(i -> i).toArray();
    }

    private static void imprimirError() {
        System.out.println("Opcionm no valida");
    }

    private static int[] recibirNumeros() throws NumberFormatException {
        Scanner pedirNumeros = new Scanner(System.in);
        System.out.print("Ingrese una lista de números separados por coma: ");
        String[] numerosNoParseados = pedirNumeros.nextLine().strip().split(",");
        int[] numerosParseados = new int[numerosNoParseados.length];
        for (int i = 0; i < numerosParseados.length; i++) {
            numerosParseados[i] = Integer.parseInt(numerosNoParseados[i]);
        }
        return numerosParseados;
    }
}


