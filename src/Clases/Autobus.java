package Clases;

public class Autobus extends Vehiculo {

    public Autobus(String patente, int capacidad, int estado) {
        super(patente, 1, estado);
    }

    @Override
    public int tarifa(int km) {
        return 18000 * km;
    }

    @Override
    //puede ingresarsi no tiene animales y si la cantidad de gente es mayor a 6 y menor a la capacidad del Autobus.
    public boolean puedeIngresar(Viaje viaje) {
        if (this.getEstado() > 40) {
            if (!viaje.getCliente().tieneAnimales() && viaje.getCapacidad() >= 6 && viaje.getCapacidad() <= this.getCapacidad()) {
                System.out.println("Tarifa del viaje: " + tarifa(viaje.getCantKM()));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}