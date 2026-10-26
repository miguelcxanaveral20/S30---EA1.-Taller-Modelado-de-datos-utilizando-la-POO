/**
 * TDA 1D: representa a un estudiante y su vector de notas.
 */
public class Estudiante {

    private String nombre;
    private double[] notas;

    public Estudiante(String nombre, int cantidadCortes) {
        this.nombre = nombre;
        this.notas = new double[cantidadCortes];
    }

    public String getNombre() {
        return nombre;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNota(int corte, double nota) {
        notas[corte] = nota;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        return suma / notas.length;
    }

    public double obtenerNotaMayor() {
        double mayor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > mayor) {
                mayor = notas[i];
            }
        }
        return mayor;
    }

    public double obtenerNotaMenor() {
        double menor = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }
        return menor;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre);
        System.out.print("Notas:      ");
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("C%d=%.1f  ", i + 1, notas[i]);
        }
        System.out.println();
        System.out.printf("Promedio:   %.2f%n", calcularPromedio());
        System.out.printf("Nota mayor: %.1f | Nota menor: %.1f%n",
                obtenerNotaMayor(), obtenerNotaMenor());
    }
}
