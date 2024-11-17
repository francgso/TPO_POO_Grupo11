package Vehículos;

import Clientes.Viaje;

public class Autobus extends Vehiculo {

    public Autobus(String patente, int capacidad, int estado) {
        super(patente, 1, estado);
    }

    @Override
    public int tarifa(int km) {
        return 18000 * km;
    }

    @Override

    /*Condiciones para pasar:
    -Si el estado del vehiculo es mayor a 40
    -Si el cliente no tiene animales
    -Si la cantidad de personas es mayor a 6 pero menor o igual a la capacidad del autobus
    */
    public boolean puedeIngresar(Viaje viaje) {
        if (this.getEstado() > 40
                && !viaje.clienteTieneAnimales()
                && viaje.getCantPersonas() >= 6
                && viaje.getCantPersonas() <= this.getCapacidad()) {

            viaje.setTarifa(tarifa(viaje.getCantKM()));

            return true;
        } else {
            return false;
        }
    }

}
