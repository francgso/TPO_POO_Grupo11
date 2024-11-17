package Vehículos;

import Clientes.Viaje;

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
    /*Condiciones para pasar:
     -Si el estado del vehiculo es superior a 40
     -Si el cliente tiene animales, depende de si el conductor permite animales. Si no los tiene, no importa si el conductor permite o no.
     -Si el cliente tiene equipaje, depende de si el conductor permite equipaje. Si no lo tiene, no importa si el conductor permite o no.
     -Si la cantidad de personas es menor o igual que la capacidad del auto*/
    public boolean puedeIngresar(Viaje viaje) {

            if (this.getEstado() > 40
                    && (!viaje.clienteTieneAnimales() || this.permiteAnimales)
                    && (!viaje.clienteEquipaje() || this.permiteEquipaje)
                    && (viaje.getCantPersonas() <= this.getCapacidad())){
                    viaje.setTarifa(tarifa(viaje.getCantKM()));

                return true;
            } else {
                return false;
            }

        }


    }
