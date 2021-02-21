/*
# construir un programa que acepte una cadena de texto como argumento
# cuente las palabras diferentes que tiene el texto e imprima cada una de ellas
# junto con su cantidad de ocurrencias
#
# para hacer el conteo, use la clase Counter del modulo collections
#*/
package proyectosjava;

public class ejercicio7 {
    public static void main(String[] args) {

    }

    public static boolean validarParametros(String[] parametro) {
        try {
            String inParametro = parametro[1];
            return true;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Parametros incorrectos");
            return false;
        }
    }

    public static void contarPalabras(String parametro){

    }
}
