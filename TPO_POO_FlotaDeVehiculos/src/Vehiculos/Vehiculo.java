package Vehiculos;

import Clientes.Viaje;

public abstract class Vehiculo {
    private String patente;
    private int capacidad;
    private int estado;


    public Vehiculo(String patente, int capacidad, int estado) {
        this.patente = patente;
        this.capacidad = capacidad;
        this.estado = estado;

    }

    public String getPatente() {
        return patente;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    //Disminuye el estado del vehiculo
    public void disminuirEstado(int disminucion){
        this.estado -= disminucion;
    }

    //Funcion que calcula la tarifa total del viaje
    public abstract int tarifa(int km);

    public abstract boolean puedeIngresar(Viaje viaje);
}
