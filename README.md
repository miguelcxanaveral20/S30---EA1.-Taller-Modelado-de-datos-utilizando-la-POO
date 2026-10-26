"
# S30---EA1.-Taller-Modelado-de-datos-utilizando-la-POO
S30 - EA1. Taller Modelado de datos utilizando la POO
EA1_Campus_Digital_Andino



Miguel Ángel Cañaveral Betancur



Estructura de Datos



Docente
Cristian David Lemus



Institución Universitaria Digital de Antioquia



Medellín, Antioquia. 
2026
PÁGINA 1. DESCRIPCIÓN DEL PROYECTO

 EA1. Taller: Modelado de datos utilizando la POO

Institución: IU Digital de Antioquia  


1. Descripción del caso

El proyecto Campus Digital Andino consiste en desarrollar una aplicación de consola en Java para gestionar estudiantes y sus calificaciones académicas. El sistema permite registrar estudiantes mediante un código único y un nombre, ingresar las calificaciones correspondientes a tres cortes académicos, consultar promedios, buscar estudiantes por nombre y organizar los resultados según el promedio obtenido.

La aplicación utiliza programación orientada a objetos (POO) para organizar el código en clases con responsabilidades específicas. Asimismo, implementa estructuras de datos como vectores y matrices para almacenar y administrar la información académica.

2. Objetivo

Desarrollar una aplicación de consola que permita administrar estudiantes y sus calificaciones mediante clases, objetos, vectores, matrices y métodos, aplicando principios básicos de programación orientada a objetos.

### 3. Funcionalidades del sistema

El programa cuenta con un menú de consola que permite realizar las siguientes operaciones:

- Registrar estudiantes con código y nombre.
- Registrar tres calificaciones por estudiante, correspondientes a los cortes académicos.
- Consultar los promedios individuales y los promedios de cada corte.
- Clasificar los resultados académicos como distinguido, aprobado, en riesgo o reprobado.
- Buscar estudiantes por su nombre.
- Ordenar los estudiantes de mayor a menor promedio.
- Validar los datos ingresados por el usuario.

La aplicación utiliza una escala de calificación de 0.0 a 5.0. La clasificación académica se establece mediante las reglas implementadas en el programa.


PÁGINA 2. DISEÑO Y MODELADO DE CLASES

4. Diseño de clases

El sistema está compuesto por tres clases principales:

Clase Estudiante: representa a cada estudiante mediante los atributos `codigo` y `nombre`. Incluye métodos para consultar sus datos, modificar el nombre y mostrar su información. Sus atributos son privados para aplicar el principio de encapsulamiento.

Clase Curso:  administra los estudiantes y sus calificaciones. Contiene un vector de objetos `Estudiante` y una matriz bidimensional de notas. Sus métodos permiten registrar estudiantes y calificaciones, buscar información, calcular promedios, clasificar resultados y ordenar los estudiantes.

Clase Main: contiene el método principal del programa y el menú de consola. Recibe las opciones ingresadas por el usuario y ejecuta las operaciones correspondientes mediante los métodos de la clase `Curso`.

5. Diagrama de clases

Insertar aquí el diagrama de clases, que representa la estructura del sistema y las relaciones entre sus componentes.

text
┌───────────────────────────┐
│        Estudiante         │
├───────────────────────────┤
│ - codigo: String          │
│ - nombre: String          │
├───────────────────────────┤
│ + getCodigo(): String     │
│ + getNombre(): String     │
│ + setNombre(): void       │
│ + mostrarDatos(): void    │
└───────────────────────────┘
              ▲
              │
              │ Curso administra
              │ objetos Estudiante
              │
┌───────────────────────────┐
│           Curso           │
├───────────────────────────┤
│ - nombre: String          │
│ - estudiantes: Estudiante[]│
│ - notas: double[][]       │
│ - cantidadEstudiantes:int │
├───────────────────────────┤
│ + registrarEstudiante()   │
│ + registrarNota()         │
│ + buscarPorCodigo()       │
│ + buscarPorNombre()       │
│ + calcularPromedio()      │
│ + ordenarPorPromedio()    │
└───────────────────────────┘
              ▲
              │
              │ Utiliza
              │
┌───────────────────────────┐
│           Main            │
├───────────────────────────┤
│ + main(String[]): void    │
│ - mostrarMenu(): void     │
│ - registrarEstudiante()   │
│ - registrarNotas()        │
│ - mostrarEstudiantes()    │
└───────────────────────────┘


 6. Estructuras de datos utilizadas

Vector: se utiliza `Estudiante[]` para almacenar los objetos de los estudiantes registrados. Cada posición del vector corresponde a un estudiante y permite acceder a su código y nombre.

Matriz: se utiliza `double[][]` para almacenar las calificaciones. Las filas corresponden a los estudiantes y las columnas representan los tres cortes académicos. Por ejemplo, `notas[0][1]` representa la nota del segundo corte del primer estudiante.

Tipo de Dato Abstracto (TDA):  la clase `Estudiante` modela la información y las operaciones propias de un estudiante, mientras que la clase `Curso` organiza y administra los datos académicos. Esta separación permite encapsular la información y utilizar métodos para realizar las operaciones del sistema.

---

 PÁGINA 3. EVIDENCIAS Y CONCLUSIÓN
7. Evidencias de ejecución

Las siguientes evidencias deben corresponder a capturas reales de la aplicación ejecutándose en la terminal de Visual Studio Code.

Evidencia 1. Menú principal



La captura debe mostrar el nombre Campus Digital Andino y las opciones disponibles para administrar estudiantes y calificaciones.

Evidencia 2. Registro de estudiantes y calificaciones



Esta evidencia debe mostrar el ingreso de los datos de prueba y los mensajes de confirmación del programa.

Evidencia 3. Consulta de resultados académicos**



Esta captura debe permitir observar los resultados calculados por el programa y comprobar el funcionamiento de las consultas.

 8. Conclusión

El desarrollo de Campus Digital Andino permitió aplicar los fundamentos de la programación orientada a objetos y el uso de estructuras de datos en Java. El vector facilita la organización de los estudiantes registrados, mientras que la matriz permite almacenar y consultar las calificaciones de los tres cortes académicos.

La separación del programa en clases mejora la organización del código y asigna responsabilidades específicas a cada componente. Además, el encapsulamiento protege los atributos y permite acceder a la información mediante métodos definidos.

Finalmente, la implementación de operaciones de búsqueda, cálculo de promedios, clasificación y ordenamiento demuestra cómo los vectores, las matrices y los tipos de datos abstractos pueden utilizarse conjuntamente para resolver un problema académico de manera estructurada. 
"
