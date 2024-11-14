package Clases;

public class Auto extends Vehiculo {

    private boolean permiteEquipaje;
    private boolean permiteAnimales;

    public Auto(String patente, int capacidad, int estado, boolean permiteEquipaje, boolean permiteAnimales) {
        super(patente, capacidad, estado);
        this.permiteAnimales= permiteAnimales;
        this.permiteEquipaje= permiteEquipaje;
    }

    @Override
    public int tarifa(int km) {
        return 4000*km;
    }

    @Override
    //puede ingresar si coincide que tenga animales, equipaje permita animales, equipaje. Y si la capacidad es menor a la aceptada
    public boolean puedeIngresar(Viaje viaje) {
        if (this.getEstado() > 40) {
            if ((!viaje.getCliente().tieneAnimales() || this.permiteAnimales) && (!viaje.getCliente().tieneEquipaje() || this.permiteEquipaje)
                    && (viaje.getCapacidad() <= this.getCapacidad())){
                System.out.println("Tarifa del viaje: " + tarifa(viaje.getCantKM()));
                return true;
            } else {
                return false;
            }

        }else {
            return false;

        }
    }
}