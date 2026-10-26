# EA1_Campus_Digital_Andino

**Proyecto:** EA1. Taller: Modelado de datos utilizando la POO

**Estudiante:** Miguel Ángel Cañaveral Betancur  
**Asignatura:** Estructura de Datos  
**Docente:** Cristian David Lemus  

**Institución:** Institución Universitaria Digital de Antioquia  
**Lugar:** Medellín, Antioquia, Colombia  
**Año:** 2026

---

## 1. Descripción del proyecto

Campus Digital Andino es una aplicación de consola desarrollada en Java para gestionar estudiantes y sus calificaciones académicas.

El sistema permite registrar estudiantes mediante un código único y un nombre, ingresar las calificaciones correspondientes a tres cortes académicos, consultar promedios, buscar estudiantes por nombre y organizar los resultados según el promedio obtenido.

El proyecto aplica los fundamentos de la programación orientada a objetos (POO) y utiliza vectores y matrices para almacenar y administrar la información académica.

## 2. Objetivo

Desarrollar una aplicación de consola que permita administrar estudiantes y sus calificaciones mediante clases, objetos, vectores, matrices y métodos, aplicando los principios básicos de la programación orientada a objetos.

## 3. Funcionalidades

La aplicación cuenta con un menú de consola que permite realizar las siguientes operaciones:

- Registrar estudiantes con código y nombre.
- Registrar tres calificaciones por estudiante.
- Consultar los promedios individuales.
- Calcular los promedios de cada corte académico.
- Clasificar los resultados como distinguido, aprobado, en riesgo o reprobado.
- Buscar estudiantes por su nombre.
- Ordenar los estudiantes de mayor a menor promedio.
- Validar los datos ingresados por el usuario.

Las calificaciones se manejan en una escala de 0.0 a 5.0.

## 4. Tecnologías utilizadas

- **Lenguaje de programación:** Java.
- **Entorno de desarrollo:** Visual Studio Code.
- **Interfaz:** Consola.
- **Paradigma:** Programación orientada a objetos.
- **Estructuras de datos:** Vector de objetos y matriz bidimensional.

## 5. Estructura del proyecto

```text
EA1_Campus_Digital_Andino/
├── src/
│   ├── Main.java
│   ├── Estudiante.java
│   └── Curso.java
├── evidencias/
│   ├── captura_menu.png
│   ├── captura_registro.png
│   └── captura_resultados.png
└── README.md
```

La carpeta `evidencias/` debe contener las capturas reales de la ejecución del programa. Si todavía no has tomado las capturas, puedes crear la carpeta y añadirlas posteriormente.

## 6. Diseño de clases

### Clase `Estudiante`

Representa a cada estudiante registrado en el sistema.

**Atributos:**
- `codigo`: identifica al estudiante.
- `nombre`: almacena su nombre.

**Responsabilidades:**
- Consultar el código y el nombre.
- Modificar el nombre.
- Mostrar los datos del estudiante.

Los atributos son privados para aplicar el principio de encapsulamiento.

### Clase `Curso`

Administra los estudiantes registrados y sus calificaciones.

**Atributos principales:**
- `nombre`: nombre del curso.
- `estudiantes`: vector de objetos de tipo `Estudiante`.
- `notas`: matriz bidimensional de calificaciones.
- `cantidadEstudiantes`: número de estudiantes registrados.

**Responsabilidades:**
- Registrar estudiantes y evitar códigos duplicados.
- Registrar y validar las calificaciones.
- Buscar estudiantes por código o nombre.
- Calcular promedios individuales y por corte.
- Clasificar los resultados académicos.
- Ordenar los estudiantes según su promedio.

### Clase `Main`

Contiene el método principal `main()` y el menú de opciones de la aplicación.

Se encarga de recibir las opciones ingresadas por el usuario y ejecutar las operaciones correspondientes mediante los métodos de la clase `Curso`.

## 7. Estructuras de datos utilizadas

### Vector

Se utiliza `Estudiante[]` para almacenar los objetos de los estudiantes registrados. Cada posición representa un estudiante y permite acceder a su información.

### Matriz

Se utiliza `double[][]` para almacenar las calificaciones de los estudiantes.

- Las filas representan a los estudiantes.
- Las columnas representan los tres cortes académicos.

Por ejemplo, `notas[0][1]` representa la calificación del segundo corte del primer estudiante.

### Tipo de Dato Abstracto (TDA)

La clase `Estudiante` encapsula los datos y las operaciones propias de cada estudiante, mientras que la clase `Curso` administra los registros y las operaciones académicas. Esta organización separa responsabilidades y facilita el mantenimiento del código.

## 8. Cómo ejecutar el proyecto

### Requisitos previos

- Tener instalado el JDK de Java.
- Tener instalado Visual Studio Code.
- Abrir la carpeta del proyecto en Visual Studio Code.

### Compilar y ejecutar

Abre una terminal en Visual Studio Code y ejecuta los siguientes comandos desde la carpeta raíz del proyecto:

**1. Entrar a la carpeta del código fuente:**

```powershell
cd src
```

**2. Compilar las clases:**

```powershell
javac Main.java Estudiante.java Curso.java
```

**3. Ejecutar la aplicación:**

```powershell
java Main
```

Al iniciar, se mostrará el menú principal en la terminal. Sigue las instrucciones en pantalla para registrar estudiantes, ingresar calificaciones y consultar los resultados.

> Si los comandos `java` o `javac` no son reconocidos, verifica que el JDK esté instalado y que su carpeta `bin` esté configurada en la variable de entorno `PATH`. Después, reinicia la terminal.

## 9. Datos de prueba sugeridos

Para verificar el funcionamiento del programa, puedes utilizar los siguientes datos:

| Código | Nombre | Corte 1 | Corte 2 | Corte 3 | Promedio esperado |
|---|---|---:|---:|---:|---:|
| EST001 | Ana Torres | 4.5 | 4.6 | 4.8 | 4.63 |
| EST002 | Luis Perez | 2.5 | 3.0 | 3.5 | 3.00 |

Los promedios anteriores se calculan mediante la media aritmética de las tres calificaciones.

## 10. Evidencias de ejecución

Las evidencias deben ser capturas reales de la aplicación ejecutándose en la terminal de Visual Studio Code.

### Evidencia 1. Menú principal

![Menú principal](evidencias/evidencia%201.png)

Debe mostrar el nombre del proyecto y las opciones disponibles en el menú.

### Evidencia 2. Registro de estudiantes y calificaciones

![Registro de estudiantes y calificaciones](evidencias/evidencia%202.png)

Debe mostrar el ingreso de los datos de prueba y los mensajes de confirmación correspondientes.

### Evidencia 3. Consulta de resultados académicos

![Resultados académicos](evidencias/evidencia%203.png)

Debe mostrar los estudiantes registrados, sus calificaciones, los promedios y la clasificación académica.

## 11. Conclusión

El desarrollo de Campus Digital Andino permite aplicar los fundamentos de la programación orientada a objetos y el uso de estructuras de datos en Java.

El vector facilita la organización de los estudiantes registrados, mientras que la matriz permite almacenar y consultar las calificaciones de los tres cortes académicos. La separación en clases asigna responsabilidades específicas, favorece el encapsulamiento y mejora la organización del código.

Finalmente, las funciones de búsqueda, cálculo de promedios, clasificación y ordenamiento muestran cómo los vectores, las matrices y los tipos de datos abstractos pueden utilizarse para resolver un problema académico de manera estructurada.

---

**Autor:** Miguel Ángel Cañaveral Betancur  
**Institución:** Institución Universitaria Digital de Antioquia  
**Año:** 2026
