/* se pide crear un sistema para registrar candidatos para unas elecciones
asi como registrar y contabilizar los votos que la gente hace por los candidatos
y después determinar al ganador

codificar el programa que simule el registro de candidatos, las votaciones y muestre el candidato electo

a) el programa debe pedir desde la linea de comandos el nombre de los candidatos a registrar de uno en uno
   después de haber registrado a todos los candidatos se debe escribir "alto"
   entonces se termina el registro y empieza con la votación

b) el programa debe mostrar los nombres de los candidatos por los cales se puede votar
   y pedir que el usuario vote por algún candidato de uno por uno, para terminar la votación se escribe "alto"
   en caso de introducir el nombre de un candidato no registrado mostrar el mensaje "candidato no registrado"
   y descartar el voto

c) al terminar las votaciones el programa debera anunciar al candidato ganador (el que tenga mas votos)
   asi como su numero de votos
   de la siguiente forma "el ganador es: NOMBRE con VOTOS votos"

   NOTA: no modificar ninguna parte del código existente, solo agregar las funcionalidades*/
package proyectosjava;

import java.util.*;

public class ejercicio3 {

    public static void main(String[] args) {

        String mensajeRegistro = "" +
                "\n                    .----------.     " +
                "\n                    | REGISTRO |     " +
                "\n                    '----------'     " +
                "\n Ingrese los nombres de los candidatos uno por uno " +

                "\n";

        String mensajeVotacion = "" +
                "\n                    .----------.     " +
                "\n                    | VOTACIÓN |     " +
                "\n                    '----------'     " +
                "\n Ingrese el nombre del candidato votado uno por uno " +

                "\n";

        String mensajeConteo = "" +
                "\n                     .--------.       " +
                "\n                     | CONTEO |       " +
                "\n                     '--------'       " +
                "\n Fin de la votación los resultados del conteo son... " +

                "\n";
        String ALTO = "Alto";
        System.out.println(mensajeRegistro);
        //código para registrar candidatos en esta sección
        Map<String, Integer> mapaEntrada = new HashMap<>();
        Scanner entradaCandidato = new Scanner(System.in);
        String nombreCapitilizado = "";
        while (!nombreCapitilizado.equals(ALTO)) {
            System.out.print("Candidato: ");
            String nombreCandidato = entradaCandidato.nextLine();
            nombreCapitilizado = (nombreCandidato.substring(0, 1).toUpperCase() +
                    nombreCandidato.substring(1, nombreCandidato.length()).toLowerCase()).strip();
            if (!nombreCapitilizado.equals(ALTO) && !nombreCapitilizado.equals("")) {
                mapaEntrada.put(nombreCapitilizado, 0);
            }
        }
        //fin de registro de candidatos

        System.out.println(mensajeVotacion);
        //código para votar en esta sección}

        for (String nomCandidato : mapaEntrada.keySet()) {
            System.out.println("\t  - " + nomCandidato);
        }
        Scanner entradaNombre = new Scanner(System.in);
        System.out.print("\n");
        String votoCapitalizado = "";
        while (!votoCapitalizado.equals(ALTO)) {
            System.out.print("Candidato: ");
            String votoNombre = entradaNombre.nextLine();
            votoCapitalizado = (votoNombre.substring(0, 1).toUpperCase() +
                    votoNombre.substring(1, votoNombre.length()).toLowerCase()).strip();
            if (mapaEntrada.containsKey(votoCapitalizado)) {
                int votoActual = mapaEntrada.get(votoCapitalizado);
                mapaEntrada.put(votoCapitalizado, votoActual + 1);
            } else if (votoCapitalizado.equals(ALTO)) {
                break;
            } else {
                System.out.print("Candidato no encontrado \n");
            }
        }
        //fin de votación

        System.out.println(mensajeConteo);
        //código para conteo en esta sección
        List<Integer> sortList = new ArrayList<Integer>(mapaEntrada.values());
        Collections.sort(sortList);
        String canGanador = "";
        int maxVoto = sortList.get(sortList.size() - 1);
        for (String recNombre : mapaEntrada.keySet()) {
            if (maxVoto == mapaEntrada.get(recNombre)) {
                canGanador = recNombre;
            }
        }
        System.out.println("El ganador es: " + canGanador + " con " + maxVoto + " votos.");
        //fin de conteo
    }
}

