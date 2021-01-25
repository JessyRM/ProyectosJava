package ejercicio6;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio6 {

    private static List<Alumno> listaAlumnos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner recibirirOpciones = new Scanner(System.in);
        while (true) {
            mensajeMenu();
            System.out.print("Ingrese una opción: ");
            String procesarOpcion = recibirirOpciones.nextLine();
            switch (procesarOpcion) {
                case "1":
                    System.out.println("");
                    agregarAlumno(listaAlumnos);
                    break;
                case "2":
                    System.out.println("");
                    System.out.printf("\nPromedio general del grupo: %.2f"
                            , promedioGrupal(listaAlumnos));
                    System.out.print("\n");
                    break;
                case "3":
                    System.out.println("");
                    consultarPromedios(listaAlumnos);
                    break;
                case "4":
                    System.out.print("\nLa cantidad de alumnos con excelencia es: "
                            + consultarExcelencia(listaAlumnos) + "\n");
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
                "\t 1. Agregar alumno \n" +
                "\t 2. Condultar promedio grupal \n" +
                "\t 3. consultar prmedio de cada alumno \n" +
                "\t 4) Consulta de excelcia \n" +
                "\t 5) Salir \n";
        System.out.println(menu);
    }

    private static void agregarAlumno(@NotNull List<Alumno> listaAlumno) {
        Scanner pedirDatos = new Scanner(System.in);
        System.out.print("Nombre del Alumno: ");
        String nombreAlumno = pedirDatos.nextLine();
        System.out.print("Calificacion del primer parcial: ");
        double calificacionUno = Double.parseDouble(pedirDatos.nextLine());
        System.out.print("Calificacion del segundo parcial: ");
        double calificacionDos = Double.parseDouble(pedirDatos.nextLine());
        System.out.print("Calificacion del tercer parcial: ");
        double calificacionTres = Double.parseDouble(pedirDatos.nextLine());

        Alumno alumnoNuevo = new Alumno(nombreAlumno,
                calificacionUno,
                calificacionDos,
                calificacionTres);
        listaAlumno.add(alumnoNuevo);
    }

    private static double promedioGrupal(@NotNull List<Alumno> listaAlumnos) {
        double promedios = 0;
        for (Alumno alumno : listaAlumnos) {
            promedios += alumno.calcularPromedio();
        }
        return promedios / listaAlumnos.size();
    }

    private static void consultarPromedios(@NotNull List<Alumno> listaAlumnos) {
        for (Alumno datos : listaAlumnos) {
            System.out.printf("Nombre: " + datos.getNompreAlumno() +
                    "\nPromedio %.2f: " , datos.calcularPromedio());
            System.out.print("\n");
        }
    }

    private static int consultarExcelencia(List<Alumno> listaAlumnos) {
        int excelencia = 0;
        for (Alumno alumno : listaAlumnos) {
            if (alumno.tieneExcelenca()) {
                excelencia += 1;
            }
        }
        return excelencia;
    }

    private static void imprimirError() {
        System.out.println("\nOpcionm no valida");
    }
}
