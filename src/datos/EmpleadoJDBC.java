package datos;

import domain.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class EmpleadoJDBC {
    private static final String SQL_SELECT = "SELECT id_Empleado, dni, apellido, nombre, acceso, estado FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado(dni, apellido, nombre, acceso, estado) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET Apellido=?, Nombre=? WHERE id_Empleado=?";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE id_Empleado=5";
    
    public List<Empleado> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                
                //Recuperamos las columnas de cada Registro
                int id_Empleado= rs.getInt("id_Empleado");
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                int acceso = rs.getInt("acceso");
                boolean estado = rs.getBoolean("estado");
                
                //Creamos el Objeto Empleado
                empleado = new Empleado();
                empleado.setId_Empleado(id_Empleado);
                empleado.setDni(dni);
                empleado.setApellido(apellido);
                empleado.setNombre(nombre);
                empleado.setAcceso(acceso);
                empleado.setEstado(estado);
                
                //Agregamos cada Empleado a la Lista
                empleados.add(empleado);
            }
                
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empleados;
    }
    
    public int insert(Empleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, empleado.getDni());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getNombre());
            stmt.setInt(4, empleado.getAcceso());
            stmt.setBoolean(5, empleado.isEstado());
            
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int update(Empleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, empleado.getDni());
            stmt.setString(2, empleado.getApellido());
            stmt.setString(3, empleado.getNombre());
            stmt.setInt(4, empleado.getAcceso());
            stmt.setBoolean(5, empleado.isEstado());
            
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int delete(Empleado empleado){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getId_Empleado());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
}
