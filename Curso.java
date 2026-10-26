import java.util.Scanner;

/**
 * TDA 2D: representa el curso (vector de Estudiante + matriz de notas
 * que se arma a partir de los vectores de cada estudiante).
 */
public class Curso {

    public static final double NOTA_MINIMA = 0.0;
    public static final double NOTA_MAXIMA = 5.0;
    public static final double LIMITE_APROBADO = 3.0;
    public static final double LIMITE_RIESGO = 2.0;
    public static final double LIMITE_DESTACADO = 4.5;

    private String nombre;
    private Estudiante[] estudiantes;
    private int cantidadCortes;

    public Curso(String nombre, int cantidadEstudiantes, int cantidadCortes) {
        this.nombre = nombre;
        this.estudiantes = new Estudiante[cantidadEstudiantes];
        this.cantidadCortes = cantidadCortes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadEstudiantes() {
        return estudiantes.length;
    }

    public int getCantidadCortes() {
        return cantidadCortes;
    }

    // ---------------------------------------------------------------
    // Registro
    // ---------------------------------------------------------------

    public void registrarEstudiantes(Scanner teclado) {
        System.out.println("\n--- REGISTRO DE ESTUDIANTES ---");
        for (int i = 0; i < estudiantes.length; i++) {
            String nombreEst = "";
            while (nombreEst.isEmpty()) {
                System.out.print("Nombre del estudiante " + (i + 1) + ": ");
                nombreEst = teclado.nextLine().trim();
                if (nombreEst.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }
            }
            estudiantes[i] = new Estudiante(nombreEst, cantidadCortes);
        }
    }

    public void registrarNotas(Scanner teclado) {
        System.out.println("\n--- REGISTRO DE NOTAS (0.0 a 5.0) ---");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println("Estudiante: " + estudiantes[i].getNombre());
            for (int j = 0; j < cantidadCortes; j++) {
                double nota = leerNota(teclado, "  Nota del corte " + (j + 1) + ": ");
                estudiantes[i].setNota(j, nota);
            }
        }
    }

    private double leerNota(Scanner teclado, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim().replace(',', '.');
            try {
                double nota = Double.parseDouble(entrada);
                if (Double.isFinite(nota) && nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA) {
                    return nota;
                }
                System.out.println("  La nota debe estar entre 0.0 y 5.0.");
            } catch (NumberFormatException e) {
                System.out.println("  Ingrese un número válido.");
            }
        }
    }

    // ---------------------------------------------------------------
    // Vector de nombres y matriz de notas
    // ---------------------------------------------------------------

    /** Vector String[] con los nombres de los estudiantes. */
    public String[] obtenerNombresEstudiantes() {
        String[] nombresEstudiantes = new String[estudiantes.length];
        for (int i = 0; i < estudiantes.length; i++) {
            nombresEstudiantes[i] = estudiantes[i].getNombre();
        }
        return nombresEstudiantes;
    }

    /** Matriz double[n][m]: fila = estudiante, columna = corte. */
    public double[][] obtenerMatrizNotas() {
        double[][] notas = new double[estudiantes.length][cantidadCortes];
        for (int i = 0; i < estudiantes.length; i++) {
            for (int j = 0; j < cantidadCortes; j++) {
                notas[i][j] = estudiantes[i].getNotas()[j];
            }
        }
        return notas;
    }

    // ---------------------------------------------------------------
    // Cálculos
    // ---------------------------------------------------------------

    /** Vector con el promedio de cada estudiante. */
    public double[] calcularPromediosPorEstudiante() {
        double[] promedioEstudiante = new double[estudiantes.length];
        for (int i = 0; i < estudiantes.length; i++) {
            promedioEstudiante[i] = estudiantes[i].calcularPromedio();
        }
        return promedioEstudiante;
    }

    /** Vector con el promedio de cada corte (columna de la matriz). */
    public double[] calcularPromediosPorCorte() {
        double[] promedioCorte = new double[cantidadCortes];
        double[][] notas = obtenerMatrizNotas();
        for (int j = 0; j < cantidadCortes; j++) {
            double suma = 0;
            for (int i = 0; i < estudiantes.length; i++) {
                suma += notas[i][j];
            }
            promedioCorte[j] = suma / estudiantes.length;
        }
        return promedioCorte;
    }

    public double obtenerNotaMayorCurso() {
        double mayor = estudiantes[0].obtenerNotaMayor();
        for (int i = 1; i < estudiantes.length; i++) {
            if (estudiantes[i].obtenerNotaMayor() > mayor) {
                mayor = estudiantes[i].obtenerNotaMayor();
            }
        }
        return mayor;
    }

    public double obtenerNotaMenorCurso() {
        double menor = estudiantes[0].obtenerNotaMenor();
        for (int i = 1; i < estudiantes.length; i++) {
            if (estudiantes[i].obtenerNotaMenor() < menor) {
                menor = estudiantes[i].obtenerNotaMenor();
            }
        }
        return menor;
    }

    public boolean esAprobado(Estudiante e) {
        return e.calcularPromedio() >= LIMITE_APROBADO;
    }

    /** Riesgo: promedio entre 2.0 y 2.9 (es decir, >= 2.0 y < 3.0). */
    public boolean esRiesgo(Estudiante e) {
        double p = e.calcularPromedio();
        return p >= LIMITE_RIESGO && p < LIMITE_APROBADO;
    }

    public boolean esDestacado(Estudiante e) {
        return e.calcularPromedio() >= LIMITE_DESTACADO;
    }

    public int contarAprobados() {
        int c = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (esAprobado(estudiantes[i])) c++;
        }
        return c;
    }

    public int contarReprobados() {
        return estudiantes.length - contarAprobados();
    }

    public int contarEnRiesgo() {
        int c = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (esRiesgo(estudiantes[i])) c++;
        }
        return c;
    }

    public int contarDestacados() {
        int c = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (esDestacado(estudiantes[i])) c++;
        }
        return c;
    }

    // ---------------------------------------------------------------
    // Búsqueda y ordenamiento
    // ---------------------------------------------------------------

    /** Búsqueda lineal por nombre (ignora mayúsculas; acepta nombre parcial). */
    public Estudiante buscarEstudiantePorNombre(String nombreBuscado) {
        String buscado = nombreBuscado.trim().toLowerCase();
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getNombre().toLowerCase().contains(buscado)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    /**
     * Ordena de menor a mayor promedio (burbuja). Trabaja sobre una copia
     * del vector, así el orden de registro original no se pierde.
     */
    public Estudiante[] ordenarPorPromedio() {
        Estudiante[] ordenados = new Estudiante[estudiantes.length];
        double[] promedios = calcularPromediosPorEstudiante();

        for (int i = 0; i < estudiantes.length; i++) {
            ordenados[i] = estudiantes[i];
        }

        for (int i = 0; i < ordenados.length - 1; i++) {
            for (int j = 0; j < ordenados.length - 1 - i; j++) {
                if (promedios[j] > promedios[j + 1]) {
                    double tmpProm = promedios[j];
                    promedios[j] = promedios[j + 1];
                    promedios[j + 1] = tmpProm;

                    Estudiante tmpEst = ordenados[j];
                    ordenados[j] = ordenados[j + 1];
                    ordenados[j + 1] = tmpEst;
                }
            }
        }
        return ordenados;
    }

    // ---------------------------------------------------------------
    // Presentación
    // ---------------------------------------------------------------

    public void mostrarTablaNotas() {
        System.out.println("\n--- TABLA DE NOTAS ---");
        System.out.printf("%-22s", "ESTUDIANTE");
        for (int j = 0; j < cantidadCortes; j++) {
            System.out.printf("%9s", "Corte " + (j + 1));
        }
        System.out.printf("%10s%n", "PROMEDIO");
        System.out.println("-".repeat(22 + 9 * cantidadCortes + 10));

        String[] nombresEstudiantes = obtenerNombresEstudiantes();
        double[][] notas = obtenerMatrizNotas();
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.printf("%-22s", nombresEstudiantes[i]);
            for (int j = 0; j < cantidadCortes; j++) {
                System.out.printf("%9.1f", notas[i][j]);
            }
            System.out.printf("%10.2f%n", estudiantes[i].calcularPromedio());
        }

        System.out.println("-".repeat(22 + 9 * cantidadCortes + 10));
        System.out.printf("%-22s", "PROMEDIO POR CORTE");
        double[] pc = calcularPromediosPorCorte();
        for (int j = 0; j < cantidadCortes; j++) {
            System.out.printf("%9.2f", pc[j]);
        }
        System.out.println();
    }

    public void mostrarPromedios() {
        System.out.println("\n--- PROMEDIOS ---");
        double[] pe = calcularPromediosPorEstudiante();
        System.out.println("Por estudiante:");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.printf("  %-22s %.2f%n", estudiantes[i].getNombre(), pe[i]);
        }
        double[] pc = calcularPromediosPorCorte();
        System.out.println("Por corte:");
        for (int j = 0; j < cantidadCortes; j++) {
            System.out.printf("  Corte %-16d %.2f%n", j + 1, pc[j]);
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("\n--- ESTADÍSTICAS DEL CURSO ---");
        System.out.printf("Nota máxima del curso: %.1f%n", obtenerNotaMayorCurso());
        System.out.printf("Nota mínima del curso: %.1f%n", obtenerNotaMenorCurso());
    }

    public void mostrarClasificacion() {
        System.out.println("\n--- CLASIFICACIÓN ---");
        System.out.println("Aprobados (promedio >= 3.0): " + contarAprobados());
        listarPorCategoria(1);
        System.out.println("Reprobados (promedio < 3.0): " + contarReprobados());
        listarPorCategoria(2);
        System.out.println("En riesgo (promedio entre 2.0 y 2.9): " + contarEnRiesgo());
        listarPorCategoria(3);
        System.out.println("Desempeño destacado (promedio >= 4.5): " + contarDestacados());
        listarPorCategoria(4);
    }

    private void listarPorCategoria(int categoria) {
        boolean hay = false;
        for (int i = 0; i < estudiantes.length; i++) {
            Estudiante e = estudiantes[i];
            boolean pertenece = false;
            if (categoria == 1) pertenece = esAprobado(e);
            else if (categoria == 2) pertenece = !esAprobado(e);
            else if (categoria == 3) pertenece = esRiesgo(e);
            else if (categoria == 4) pertenece = esDestacado(e);

            if (pertenece) {
                System.out.printf("   - %-20s (%.2f)%n", e.getNombre(), e.calcularPromedio());
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("   (ninguno)");
        }
    }

    public void mostrarOrdenados() {
        Estudiante[] ordenados = ordenarPorPromedio();
        System.out.println("\n--- ESTUDIANTES ORDENADOS (menor a mayor promedio) ---");
        for (int i = 0; i < ordenados.length; i++) {
            System.out.printf("%2d. %-22s %.2f%n", i + 1,
                    ordenados[i].getNombre(), ordenados[i].calcularPromedio());
        }
    }

    public void mostrarResumenCurso() {
        System.out.println("\n==================================================");
        System.out.println(" RESUMEN DEL CURSO: " + nombre);
        System.out.println("==================================================");
        mostrarTablaNotas();
        mostrarPromedios();
        mostrarEstadisticas();
        mostrarClasificacion();
        mostrarOrdenados();
    }
}
