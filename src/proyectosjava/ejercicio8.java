/*
# escriba un programa qué acepte como argumento una cadena de texto
# y transforme la cadena de acuerdo a las siguientes banderas
#
# -r        invierta la cadena de texto
# -fN       imprima solo las primeras N letras de la cadena
# -lN       imprimir solo las ultimas N letras de la cadena

* */
package proyectosjava;

public class ejercicio8 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Hay muy pocos argumentos");
            return;
        }
        if(args[0].equals("-r")){
            String salidaInvertir = invertirCadena(args[1]);
            System.out.println(salidaInvertir);
        }else if (args[0].startsWith("-f")){
            String salidaPrimeras = imprimirPrimeras(args[1], sacarNumero(args[0]));
            System.out.println(salidaPrimeras);
        }else if(args[0].startsWith("-l")){
            String salidaUltimas = imprimirUltimas(args[1], sacarNumero(args[0]));
            System.out.println(salidaUltimas);
        }else {
            System.out.println("Tú eres invalido");
        }


    }

    private static String invertirCadena(String inParametro) {
        int len = inParametro.length();
        StringBuilder parametro = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            parametro.append(inParametro.charAt(i));
        }
        return parametro.toString();
    }

    private static String imprimirPrimeras(String inParametro, int numero) {
        int len = inParametro.length();
        if (len <= numero) {
            return inParametro;
        }
        StringBuilder parametro = new StringBuilder();
        for (int i = 0; i < numero; i++) {
            parametro.append(inParametro.charAt(i));
        }
        return parametro.toString();
    }

    private static String imprimirUltimas(String inParametros, int numero){
        int len = inParametros.length();
        if(len <=numero){
            return inParametros;
        }
        StringBuilder parametro = new StringBuilder();
        for (int i = len - numero; i < len; i++){
            parametro.append(inParametros.charAt(i));
        }
        return parametro.toString();
    }

    public static int sacarNumero(String numero){
        int len = numero.length();
        if(len <= 2){
            return 0;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 2; i < len; i++){
            out.append(numero.charAt(i));
        }
        return Integer.parseInt(out.toString());
    }
}
