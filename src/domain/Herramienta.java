package domain;

/**
 *
 * @author Juan
 */
public class Herramienta {

    private int id_Herramienta;
    private String nombre;
    private String descripcion;
    private int stock;
    private boolean estado;

    public int getId_Herramienta() {
        return id_Herramienta;
    }

    public void setId_Herramienta(int id_Herramienta) {
        this.id_Herramienta = id_Herramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Herramienta{" + "id_Herramienta=" + id_Herramienta + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock + ", estado=" + estado + '}';
    }

}
