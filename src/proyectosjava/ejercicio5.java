package proyectosjava;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ejercicio5 {

    private static Map<String, String> agendaTelefonica = new HashMap<>();

    public static void main(String[] args) {
        Scanner recibirirOpciones = new Scanner(System.in);
        while (true) {
            mensajeMenu();
            System.out.print("Ingrese una opción: ");
            String procesarOpcion = recibirirOpciones.nextLine();
            switch (procesarOpcion) {
                case "1":
                    System.out.println("");
                    buscarContacto(agendaTelefonica);
                    break;
                case "2":
                    System.out.println("");
                    pedirDatos(agendaTelefonica);
                    break;
                case "3":
                    System.out.println("");
                    modificarContacto(agendaTelefonica);
                    break;
                case "4":
                    eliminarContacto(agendaTelefonica);
                    break;
                case "5":
                    return;
                default:
                    imprimirError();
            }
        }
    }

    private static void mensajeMenu() {
        String menu = "\nOPCIONES: \n" +
                "\t 1) Consultar número de contacto \n" +
                "\t 2) Agregar contacto \n" +
                "\t 3) Eliminar contacto \n" +
                "\t 4) Modificar número de contacto \n" +
                "\t 5) Salir \n";
        System.out.println(menu);
    }

    private static void buscarContacto(Map<String, String> agendaTelefonica) {
        Scanner pedirContacto = new Scanner(System.in);
        System.out.print("Nombre: ");
        String contacto = nombreCapitalizado(pedirContacto.nextLine());
        if (agendaTelefonica.containsKey(contacto)) {
            String numero = agendaTelefonica.get(contacto);
            System.out.print("\nEl numero de " + contacto + " es " + numero + "." + "\n");
        } else {
            mensajeError(contacto);
        }
    }

    private static void pedirDatos(Map<String, String> agendaTelefonica) {
        Scanner pedirDatos = new Scanner(System.in);
        System.out.print("Nombre: ");
        String contacto = nombreCapitalizado(pedirDatos.nextLine());
        System.out.print("Numero: ");
        String numero = pedirDatos.nextLine();
        agendaTelefonica.put(contacto, numero);
    }

    private static void modificarContacto(Map<String, String> agendaTelefonica) {
        Scanner pedirContacto = new Scanner(System.in);
        System.out.print("Nombre: ");
        String contacto = nombreCapitalizado(pedirContacto.nextLine());
        if (agendaTelefonica.containsKey(contacto)) {
            String numero = agendaTelefonica.remove(contacto);
            System.out.print("\n" + contacto + " fue eliminada" + "\n");
        } else {
            mensajeError(contacto);
        }
    }

    private static void eliminarContacto(Map<String, String> agendaTelefonica) {
        Scanner pedirContacto = new Scanner(System.in);
        System.out.print("Nombre: ");
        String contacto = nombreCapitalizado(pedirContacto.nextLine());
        if (agendaTelefonica.containsKey(contacto)) {
            String numeroAnterior = agendaTelefonica.get(contacto);
            System.out.print("Nuevo Numero: ");
            String numeroNuevo = pedirContacto.nextLine();
            agendaTelefonica.put(contacto, numeroNuevo);
            System.out.print("\n" + contacto + " ha sido cambiado de " + numeroAnterior + " a " + numeroNuevo);
        } else {
            mensajeError(contacto);
        }
    }

    private static void imprimirError() {
        System.out.println("Opcionm no valida");
    }

    private static void mensajeError(String nombreContacto) {
        System.out.print("\n" + nombreContacto + " no esta registrada en tu agenda" + "\n");
    }
    private static String nombreCapitalizado(String nombre){
        String nombreMayuscula = (nombre.substring(0, 1).toUpperCase() +
                nombre.substring(1, nombre.length()).toLowerCase());
        return nombreMayuscula;
    }

}