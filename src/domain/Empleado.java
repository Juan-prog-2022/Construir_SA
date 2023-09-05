package domain;

/**
 *
 * @author Juan
 */
public class Empleado {

    private int id_Empleado;
    private int dni;
    private String apellido;
    private String nombre;
    private int acceso;
    private boolean estado;

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAcceso() {
        return acceso;
    }

    public void setAcceso(int acceso) {
        this.acceso = acceso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_Empleado=" + id_Empleado + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", acceso=" + acceso + ", estado=" + estado + '}';
    }

    

}
