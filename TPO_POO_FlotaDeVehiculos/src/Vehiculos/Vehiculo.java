package Vehiculos;

import Clientes.Viaje;
import Empresas.Conductor;
import Excepciones.FlotaException;

public abstract class Vehiculo {
    private String patente;
    private int capacidad;
    private int estado;
    private boolean tieneDuenio;


    public Vehiculo(String patente, int capacidad, int estado) {
        this.patente = patente;
        this.capacidad = capacidad;
        this.estado = estado;
        this.tieneDuenio = false;

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

    public void setTieneDuenio(boolean tieneDuenio) {
        this.tieneDuenio = tieneDuenio;
    }

    //Funcion que calcula la tarifa total del viaje
    public abstract int tarifa(int km);

    public abstract boolean puedeIngresar(Viaje viaje);

    public boolean getTieneDuenio() {
        return tieneDuenio;
    }


}
