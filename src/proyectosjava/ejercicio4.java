/*crear un programa que pida una lista de números al usuario desde la linea de comandos
 cada numero debera ir separado por una coma ","
 después de ingresar su lista de números al usuario se le pedirá que elija
 entre 4 opciones
 1) quiere sumarlos todos
 2) quiere multiplicarlos todos
 3) quiere imprimirlos todos
 4) quiere salir del programa

 si el usuario teclea una opción incorrecta mandar el mensaje "opción no valida"

 el programa principal estará codificado, solamente deberán escribirse las funciones:
 "sumar_todos"
 esta función debe regresar la suma de los números (un número)
 "multiplicar_todos"
  esta función debe regresar la multiplicación de los números (un número)
  "imprimir_todos"
  No regresa nada
  "imprimir_error"
  No regresa nada*/

package proyectosjava;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ejercicio4 {

    public static void main(String[] args) {
        float[] cacharNumeros = recibirNumeros();
        Scanner recibirirOpciones = new Scanner(System.in);
        while(true){
            mensajeMenu();
            System.out.print("Ingrese una opción: ");
            String procesarOpcion = recibirirOpciones.nextLine();
            switch (procesarOpcion){
                case "1":
                    System.out.println("");
                    System.out.println("La suma de los numeros: " + sumarTodos(cacharNumeros) + "\n");
                    break;
                case "2":
                    System.out.println("");
                    System.out.println("La multiplicacion de los numeros es: " + multiplicarTodo(cacharNumeros));
                    break;
                case "3":
                    System.out.println("");
                    imprimirTodos(cacharNumeros);
                    break;
                case "4":
                    return;
                default:
                    imprimirError();
            }
        }
    }

    private static void mensajeMenu(){
        String menu = "\nOPCIONES: \n" +
                "\t 1) Sumarlo todo \n" +
                "\t 2) Multiplicarlo todo \n" +
                "\t 3) Imprimirlo todo \n" +
                "\t 4) Salir del programa \n";
        System.out.println(menu);
    }

    private static float sumarTodos(float ...numeros){
        float resultado = 0;
        for (float numero : numeros){
            resultado += numero;
        }
        return resultado;
    }

    private static float multiplicarTodo(float ...numeros){
        float resultado = 1f;
        for (float numero : numeros){
            resultado *= numero;
        }
        return resultado;
    }

    private static void imprimirTodos(float ...numeros){
        for(float numero : numeros){
            System.out.print(" " + numero + "\n");
        }
    }

    private static void imprimirError(){
        System.out.println("Opcionm no valida");
    }

    private static float[] recibirNumeros(){
        Scanner pedirNumeros = new Scanner(System.in);
        System.out.print("Ingrese una lista de números separados por coma: ");
        String[] numerosNoParseados = pedirNumeros.nextLine().strip().split(",");
        float[] numerosParseados = new float[numerosNoParseados.length];
        for(int i = 0; i < numerosParseados.length; i++){
            numerosParseados[i] = Float.parseFloat(numerosNoParseados[i]);
        }
        return numerosParseados;
    }
}