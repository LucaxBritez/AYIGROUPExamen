package Entidades;

public class Usuario {

    int dni;

    String nombre;
    String apellido;

    RolUsuario rol;

    public Usuario(int dni, String nombre, String apellido, RolUsuario rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public Usuario() {

    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
}
