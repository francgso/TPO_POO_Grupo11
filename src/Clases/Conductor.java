package Clases;

public class Conductor extends Empleado{
    private int puntuacion;
    private Vehiculo vehiculo;
    private int cant_viajes;

    public Conductor(String nombre, Vehiculo vehiculo) {
        super(nombre);
        this.vehiculo = vehiculo;
        this.cant_viajes = 0;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public void setPuntuacion(int puntos) {
        puntuacion = (puntuacion *(cant_viajes-1)+ puntos)/cant_viajes;
    }

    public void setSumar_viajes() {
        this.cant_viajes += 1;
    }

    public int getCant_viajes() {
        return cant_viajes;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
