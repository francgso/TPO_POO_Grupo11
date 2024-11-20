package Vehiculos;

import Clientes.Viaje;

public class Moto extends Vehiculo{

    private int pesoMaximoPorPasajero;

    public Moto (String patente, int capacidad, int estado, int pesoMaximoPorPasajero){
        super (patente,capacidad,estado);
        this.pesoMaximoPorPasajero= pesoMaximoPorPasajero;

    }

    @Override
    public int tarifa(int km) {
        return 2500*km;
    }


    @Override
    /*Condiciones para pasar:
    -Si el estado del vehiculo es mas de 40.
    -Si el cliente no es discapacitado.
    -Si el cliente tiene mas de 18 anios.
    -Si el cliente no tiene animales.
    -Si el cliente no tiene equipaje.
    -Si el cliente tiene casco.
    -Si la cantidad de personas del viaje es menor o igual a la capacidad de la moto
    -Si el peso del pasajero es menor o igual al peso maximo permitido por la moto.
    */
    public boolean puedeIngresar(Viaje viaje) {

            if (this.getEstado() > 40
                    && !viaje.clienteDiscapacitado() && viaje.clienteEdad() > 18 && !viaje.clienteTieneAnimales()
                    && !viaje.clienteEquipaje() && viaje.clienteCasco() && viaje.getCantPersonas() <= this.getCapacidad()
                    && this.pesoMaximoPorPasajero >= viaje.clientePeso()){
                viaje.setTarifa(tarifa(viaje.getCantKM()));

                return true;
            }else{
                return false;
            }

    }






}
