package ejercicio_2;

import datos.HerramientaJDBC;
import domain.Herramienta;
import java.util.List;

/**
 *
 * @author Juan
 */
public class Insertar_Herramientas {

    public static void main(String[] args) {
        
        
        
        HerramientaJDBC herramienta = new HerramientaJDBC();

        List<Herramienta> herramientaObra = herramienta.select();
        
        //Creamos las Herramientas
        
        /*Herramienta H_1 = new Herramienta();
        
        H_1.setNombre("Martillo");
        H_1.setDescripcion("Tipo Maza");
        H_1.setStock(5);
        H_1.setEstado(true);
        
        // Insertamos las Herramientas
        herramienta.insert(H_1);
        
        Herramienta H_2 = new Herramienta();
        
        H_2.setNombre("Destornillador");
        H_2.setDescripcion("Philips");
        H_2.setStock(5);
        H_2.setEstado(true);
        
        herramienta.insert(H_2);
        
        Herramienta H_3 = new Herramienta();
        
        H_3.setNombre("Destornillador");
        H_3.setDescripcion("Tipo Buscapolo");
        H_3.setStock(5);
        H_3.setEstado(true);
        
        herramienta.insert(H_3);
        
        Herramienta H_4 = new Herramienta();
        
        H_4.setNombre("Taladro");
        H_4.setDescripcion("Con Percutor");
        H_4.setStock(10);
        H_4.setEstado(true);
        
        herramienta.insert(H_4);*/
        
        
        // Seleccionamos las Herramientas que tengan stock mayor a 10
        for (Herramienta H : herramientaObra) {
            System.out.println(H.getNombre() + " " + H.getStock());
        }
        
        
    }
    
}
