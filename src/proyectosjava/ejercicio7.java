/*
# construir un programa que acepte una cadena de texto como argumento
# cuente las palabras diferentes que tiene el texto e imprima cada una de ellas
# junto con su cantidad de ocurrencias
#
# para hacer el conteo, use la clase Counter del modulo collections
#*/
package proyectosjava;

import utilidades.Counter;

public class ejercicio7 {
    public static void main(String[] args) {
        if (validarParametros(args)){
            contarPalabras(args[0]);
        }
    }

    public static boolean validarParametros(String[] parametro) {
        try {
            String inParametro = parametro[0];
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Parametros incorrectos");
            return false;
        }
    }

    public static void contarPalabras(String parametro) {
        Counter<String> contador = new Counter<>(
                parametro.
                        replaceAll(",", "").
                        split(" ")
        );
        for (var elementos : contador.items()) {
            System.out.println(elementos.getKey() + ":" +
                    elementos.getValue());
        }
    }
}
