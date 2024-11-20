package Empresas;

import Vehiculos.Vehiculo;

public class Conductor extends Empleado{
    private int puntuacion;
    private Vehiculo vehiculo;
    private int cantViajes;

    public Conductor(String nombre, Vehiculo vehiculo) {
        super(nombre);
        this.vehiculo = vehiculo;
        this.cantViajes = 0;
    }

    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public void setPuntuacion(int puntos) {
        puntuacion = (puntuacion *(cantViajes -1)+ puntos)/ cantViajes;
    }

    public void setSumarViajes() {
        this.cantViajes += 1;
    }

    public int getCantViajes() {
        return cantViajes;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
