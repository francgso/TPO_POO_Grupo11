package Empresas;

public abstract class Empleado {
    private String nombre;
    private boolean disponibilidad;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.disponibilidad = true;

    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public String getNombre(){
        return nombre;
    }
}
