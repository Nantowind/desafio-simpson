# Desafío **Leafnoise** Simpson



## Primera Versión 1)

Esta consigna aplica a la **primera versión**, en este caso solo se necesitaba implementar a la clase `PlantaNuclear` el método `estaEnPeligro()` que determina si está en peligro si el uranio es mayor a 10,000.

```java
class PlantaNuclear {
    private EmpleadoControl empleadoDeControl;
    private int cantidadDeUranio;
    private Burns duenio;

    public PlantaNuclear(EmpleadoControl empleadoDeControl, int cantidadDeUranio, Burns duenio) {
        this.empleadoDeControl = empleadoDeControl;
        this.cantidadDeUranio = cantidadDeUranio;
        this.duenio = duenio;
    }

    public void agregarUranio(int cantidad) {
        cantidadDeUranio += cantidad;
    }

    public boolean estaEnPeligro() {
        return (cantidadDeUranio > 10000 && empleadoDeControl.estaDistraido()) || duenio.estaPobre();
    }
}
```
## Segunda Versión 1)

Me gustó bastante el desafío por la temática, así que me tomé la libertad de hacer una **segunda versión** en código, con ánimos de complicarlo un poco y agregar funciones a la `PlantaNuclear`. Esta versión es ejecutada desde este proyecto y utiliza Java y Spring. Se ejecuta desde el navegador con el endpoint `/index` a través del localhost. Es simple y la consigna para resolverlo es la siguiente:

### Consigna

La planta nuclear de Springfield necesita mantener entre 9,500 y 10,000 unidades de uranio para funcionar correctamente. Homero y el pato Eduardo trabajan juntos durante 8 horas diarias para lograr esto. Eduardo es más eficiente que Homero y puede cargar hasta 18 unidades de uranio por hora por cada unidad de energía que tiene. Por otro lado, Homero solo puede cargar 6 unidades de uranio por cada unidad de energía.

**Homero** puede volverse loco si su energía supera las 80 unidades debido a la radiación del uranio. Si su energía baja de las 70 unidades, se distraerá. ¡En ambos casos, la planta dejará de funcionar!

**Eduardo** es menos tolerante a la radiación y solo puede soportar 45 unidades de energía antes de volverse loco. Se distraerá si tiene menos de 35 unidades de energía.

Para mantener la energía de los empleados, el Sr. Burns ha destinado $155 para comprar donas. Cada dona cuesta $4, y si se gastan más de $155, el Sr. Burns quedará en bancarrota y la planta se irá al "hoyo del diablo".

Cada dona proporciona 3 unidades de energía a los empleados. Sin embargo, Eduardo tiene una habilidad especial para robar donas a Homero. ¡Cuando le roba donas a Homero, cada dona robada le proporciona 4 unidades de energía!

### Desafío

El desafío es encontrar la cantidad adecuada de donas para Homero y Eduardo, y cuántas donas debe robar Eduardo para mantener la planta nuclear funcionando correctamente sin que ninguno de ellos se vuelva loco o se distraiga, y sin que el Sr. Burns quede en bancarrota.



## Desafio parte 2)

```java
public class EmpleadoTablaDB {
    private String nombre;
    private String apellido;
    private TipoEmpleado tipo;
    private String soloEmpleadoBueno;
    private String soloEmpleadoMalo;
    // todos sus getters y setters
}

public enum TipoEmpleado {
    BUENO, MALO
}

public abstract class Empleado {
    private String nombre;
    private String apellido;
    // todos sus getters y setters
}

public class EmpleadoMalo extends Empleado {
    private String soloEmpleadoMalo;
    // todos sus getters y setters
}

public class EmpleadoBueno extends Empleado {
    private String soloEmpleadoBueno;
    // todos sus getters y setters
}

public class EmpleadoNuevo extends Empleado {
}

public class EmpleadoFactory {
    public Empleado obtenerEmpleado(EmpleadoTablaDB empleadoDB) {
        if (empleadoDB.getTipo() == null) {
            return crearEmpleadoNuevo(empleadoDB);
        }

        switch (empleadoDB.getTipo()) {
            case MALO:
                return crearEmpleadoMalo(empleadoDB);
            case BUENO:
                return crearEmpleadoBueno(empleadoDB);
            default:
                throw new IllegalArgumentException("Tipo de empleado desconocido: " + empleadoDB.getTipo());
        }
    }

    private EmpleadoMalo crearEmpleadoMalo(EmpleadoTablaDB empleadoDB) {
        EmpleadoMalo homero = new EmpleadoMalo();
        homero.setNombre(empleadoDB.getNombre());
        homero.setApellido(empleadoDB.getApellido());
        homero.setSoloEmpleadoMalo(empleadoDB.getSoloEmpleadoMalo());
        return homero;
    }

    private EmpleadoBueno crearEmpleadoBueno(EmpleadoTablaDB empleadoDB) {
        EmpleadoBueno smithers = new EmpleadoBueno();
        smithers.setNombre(empleadoDB.getNombre());
        smithers.setApellido(empleadoDB.getApellido());
        smithers.setSoloEmpleadoBueno(empleadoDB.getSoloEmpleadoBueno());
        return smithers;
    }

    private EmpleadoNuevo crearEmpleadoNuevo(EmpleadoTablaDB empleadoDB) {
        EmpleadoNuevo nuevo = new EmpleadoNuevo();
        nuevo.setNombre(empleadoDB.getNombre());
        nuevo.setApellido(empleadoDB.getApellido());
        return nuevo;
    }
}
```
 
### Explicacion de refactorizacion 

#### Comprobación de tipo de empleado NULL:
Imagina que estás buscando un tipo específico de empleado, pero en algunos casos, no sabes qué tipo de empleado es. En lugar de usar un método que podría ocultar errores no relacionados y confundirnos, decidimos verificar explícitamente si no sabemos el tipo de empleado (es decir, si es NULL). Así, hacemos nuestro código más fácil de entender y evitamos errores ocultos.


##### Uso de un bloque "switch" en lugar de "if-else":
Cuando estás eligiendo entre múltiples opciones, en lugar de usar un montón de "if-else" que pueden ser difíciles de leer y mantener, decidi utilizar un bloque "switch".

##### Creación de métodos de fábrica para instanciar empleado:
En lugar de mezclar la creación de diferentes tipos de empleados en un solo lugar, separamos esa responsabilidad en diferentes "métodos de fábrica"
Esto hace que el código sea más fácil de leer y mantener, ya que si necesitamos cambiar la forma en que creamos un empleado, solo necesitamos modificar la fábrica correspondiente.

##### Lanzamiento de una excepción para tipos de empleados desconocidos:
Supongamos que encontramos un tipo de empleado que no reconocemos. En lugar de ignorarlo y seguir adelante, se lanzar una excepción.

## Desafio parte 3)


```sql
SELECT 
    a.dni,
    a.fecha_nacimiento,
    t.codigo AS codigo_travesura,
    t.fecha AS fecha_travesura,
    t.descripcion AS descripcion_travesura,
    nd.descripcion AS descripcion_nivel_delictivo
FROM 
    alumnos a
JOIN 
    travesuras t ON a.dni = t.dni_alumno
JOIN 
    niveles_delictivos nd ON t.nivel_delictivo = nd.codigo
WHERE 
    a.nombre = 'Bart' AND 
    a.apellido = 'Simpson' AND 
    nd.codigo > 3;
```

## Desafio parte 4)
Bueno, imaginate que estás armando muñecos. Las **clases abstractas** son como un muñeco básico, pero le falta algo para estar completo, como la ropa o el peinado. Vos le agregás eso que falta y lo personalizás a tu gusto.

Las **interfaces** son como una lista de cosas que el muñeco debe saber hacer, por ejemplo, bailar o cantar. No te dicen cómo hacerlo, solo te aseguran que el muñeco va a poder hacer esas cosas.

Entonces, usás una **clase abstracta** para el muñeco base y una **interfaz** para agregarle las habilidades que querés que tenga.

