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
-
