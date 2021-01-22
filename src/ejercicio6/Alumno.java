package ejercicio6;

public class Alumno {
    private String nompreAlumno;
    private double calificacionUno;
    private double calificacionDos;
    private double calificacionTres;
    private final static double  promedio = 7.9;
    private final static int ccantidadParciales = 3;

    public Alumno(String nompreAlumno,
                  double calificacionUno,
                  double calificacionDos,
                  double calificacionTres) {
        this.nompreAlumno = nompreAlumno;
        this.calificacionUno = calificacionUno;
        this.calificacionDos = calificacionDos;
        this.calificacionTres = calificacionTres;
    }

    public String getNompreAlumno() {
        return nompreAlumno;
    }

    public double calcularPromedio() {
        double resultado = ((calificacionUno
                + calificacionDos
                + calificacionTres) / ccantidadParciales);
        return resultado;
    }

    public boolean tieneExcelenca() {
        return calcularPromedio() > promedio;
    }
}
