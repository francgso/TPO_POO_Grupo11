package Empresas;

import Excepciones.FlotaException;
import Clientes.Viaje;

import java.util.ArrayList;
import java.util.Comparator;

public class Empresa {

    private ArrayList<Conductor> conductores = new ArrayList<Conductor>();
    private Mecanico mecanico;

    public void aniadirConductor (Conductor conductor){
        conductores.add(conductor);
    }

    public void eliminarConductor (Conductor conductor) throws FlotaException {
        if (!conductores.remove(conductor)) {
            throw new FlotaException("El conductor seleccionado no es parte de la empresa.");
        }
    }

    //Comprueba que no exista un mecanico para agregar uno nuevo
    public void aniadirMecanico(Mecanico mecanico) throws FlotaException{
        if (mecanico!=null){
            this.mecanico = mecanico;
        }else{
            throw new FlotaException("Primero se debe despedir al Mecanico que esta en el empresa");
        }

    }

    //elimina el mecanico si es que existe
    public void eliminarMecanico (){
            mecanico = null;
    }

    //Muestra la cantidad de viajes de los conductores
    public ArrayList rankingCantViajes() {
        ArrayList<Conductor> copia = new ArrayList<>();
        copia.addAll(conductores);
        int ini = 0;
        int fin = copia.size();
        copia.sort(new Comparator<Conductor>() {
            @Override
            public int compare(Conductor c1, Conductor c2) {
                if (c1.getCantViajes() > c2.getCantViajes()) {
                    return -1;

                } else if (c2.getCantViajes() > c1.getCantViajes()) {
                    return 1;

                } else {
                    return 0;
                }

            }
        });

        return copia;

    }

    //Muestra el ranking segun la puntuacion de los conductores
    public ArrayList rankingPuntuacion() {
        ArrayList<Conductor> copia = new ArrayList<>();
        copia.addAll(conductores);
        int ini = 0;
        int fin = copia.size();
        copia.sort(new Comparator<Conductor>() {
            @Override
            public int compare(Conductor c1, Conductor c2) {
                if (c1.getPuntuacion() > c2.getPuntuacion()) {
                    return -1;

                } else if (c2.getPuntuacion() > c1.getPuntuacion()) {
                    return 1;

                } else {
                    return 0;
                }
            }
        });

        return copia;

    }



    //Asigna un conductor al viaje iniciado por el cliente
    public void asignacionConductor (Viaje viaje) throws FlotaException{
        Conductor conductorCandidato = null;

        int i = 0;
        int band=0;
        while (i < conductores.size() && band==0){
            conductorCandidato=conductores.get(i);

            if ( conductorCandidato.getDisponibilidad() && conductorCandidato.getVehiculo().puedeIngresar(viaje) ){
                viaje.setConductorAsignado(conductorCandidato);
                conductorCandidato.setDisponibilidad(false);
                band=1;
            //Si el conductor no pudo aceptar el viaje porque su vehículo está en mal estado, es enviado al mecánico
            }else if (conductorCandidato.getVehiculo().getEstado() <= 40) {
                mecanico.arreglar(conductorCandidato);
            }
            i++;
        }

        if (band == 0) {
            throw new FlotaException("No se han encontrado conductores disponibles para el viaje del cliente "+ viaje.getCliente().getNombre() + ". Intente más tarde. \n");
        }

    }

}
