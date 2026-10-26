import java.util.Scanner;

public class Main {

    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("      CAMPUS DIGITAL ANDINO");
        System.out.println("   Gestión de calificaciones");
        System.out.println("======================================");

        int n = leerEnteroPositivo("Cantidad de estudiantes (n): ");
        int m = leerEnteroPositivo("Cantidad de evaluaciones/cortes (m): ");

        Curso curso = new Curso("Campus Digital Andino", n, m);
        curso.registrarEstudiantes(teclado);
        curso.registrarNotas(teclado);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    curso.mostrarTablaNotas();
                    break;
                case 2:
                    curso.mostrarPromedios();
                    break;
                case 3:
                    curso.mostrarEstadisticas();
                    break;
                case 4:
                    curso.mostrarClasificacion();
                    break;
                case 5:
                    curso.mostrarOrdenados();
                    break;
                case 6:
                    buscar(curso);
                    break;
                case 7:
                    curso.mostrarResumenCurso();
                    break;
                case 0:
                    System.out.println("Gracias por usar Campus Digital Andino.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n============= MENÚ =============");
        System.out.println("1. Tabla de notas");
        System.out.println("2. Promedios por estudiante y por corte");
        System.out.println("3. Nota máxima y mínima del curso");
        System.out.println("4. Aprobados, reprobados, en riesgo y destacados");
        System.out.println("5. Ordenar estudiantes por promedio");
        System.out.println("6. Buscar estudiante por nombre");
        System.out.println("7. Resumen completo del curso");
        System.out.println("0. Salir");
        System.out.println("================================");
    }

    private static void buscar(Curso curso) {
        System.out.print("Nombre (o parte del nombre) a buscar: ");
        String nombre = teclado.nextLine();
        Estudiante e = curso.buscarEstudiantePorNombre(nombre);
        System.out.println("\n--- RESULTADO DE LA BÚSQUEDA ---");
        if (e == null) {
            System.out.println("No se encontró ningún estudiante con ese nombre.");
        } else {
            e.mostrarInfo();
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(teclado.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número entero válido.");
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor que 0.");
        }
    }
}
