package Clases;

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
    //puede ingresar si no es discapacitado, edad > 18, peso <= 110, si no tiene animales, si no tiene equipaje y si tiene casco
    public boolean puedeIngresar(Viaje viaje) {
        if (this.getEstado() > 40){
            if (!viaje.getCliente().getEsDiscapacitado() && viaje.getCliente().getEdad() > 18 && !viaje.getCliente().tieneAnimales()
            && !viaje.getCliente().tieneEquipaje() && viaje.getCliente().traeCasco() && viaje.getCapacidad() <= this.getCapacidad()
            && this.pesoMaximoPorPasajero >= viaje.getCliente().getPeso()){
                System.out.println("Tarifa del viaje: " + tarifa(viaje.getCantKM()));
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }






}
