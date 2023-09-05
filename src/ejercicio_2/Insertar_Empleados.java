package ejercicio_2;

import datos.EmpleadoJDBC;
import domain.Empleado;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Insertar_Empleados {

    public static void main(String[] args) {

        EmpleadoJDBC empleado = new EmpleadoJDBC();

        List<Empleado> empleados = empleado.select();

        for (Empleado emp : empleados) {
            System.out.println("Empleados:" + emp);
        }

        // Creamos el objeto empleado
        /*Empleado emp1 = new Empleado();

        emp1.setDni(33200500);
        emp1.setApellido("Ríos");
        emp1.setNombre("Maria Laura");
        emp1.setAcceso(1);
        emp1.setEstado(true);

        // Insertamos el Empleado a la Base de Datos
        empleado.insert(emp1);
        
        //Dar de baja el Empleado
        empleado.delete(emp1);*/
        
        empleado.select();
        
    }
}
