package datos;

import domain.Herramienta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class HerramientaJDBC {
    
    private static final String SQL_SELECT = "SELECT id_Herramienta, nombre, descripcion, stock , estado FROM herramienta WHERE stock > 10";
    private static final String SQL_INSERT = "INSERT INTO herramienta(nombre, descripcion, stock, estado) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE herramienta SET Nombre=?, Descripcion=? WHERE id_Herramienta=?";
    private static final String SQL_DELETE = "DELETE FROM herramienta WHERE id_Herramienta=?";
    
    public List<Herramienta> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Herramienta herramienta = null;
        List<Herramienta> herramientas = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                
                //Recuperamos las columnas de cada Registro
                int id_Herramienta = rs.getInt("id_Herramienta");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int stock = rs.getInt("stock");
                boolean estado = rs.getBoolean("estado");
                
                //Creamos el Objeto Herramienta
                herramienta = new Herramienta();
                herramienta.setId_Herramienta(id_Herramienta);
                herramienta.setNombre(nombre);
                herramienta.setDescripcion(descripcion);
                herramienta.setStock(stock);
                herramienta.setEstado(estado);
                
                //Agregamos cada Herramienta a la Lista
                herramientas.add(herramienta);
            }
            
             } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return herramientas;
    }
    
    public int insert(Herramienta herramienta){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, herramienta.getNombre());
            stmt.setString(2, herramienta.getDescripcion());
            stmt.setInt(3, herramienta.getStock());
            stmt.setBoolean(4, herramienta.isEstado());
            
            
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
}
