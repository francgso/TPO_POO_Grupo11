package Clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Empresa {

    private ArrayList<Conductor> conductores = new ArrayList<Conductor>();
    private Mecanico mecanico;

    public void aniadirConductor (Conductor conductor){
        conductores.add(conductor);
    }

    public void eliminarConductor (Conductor conductor){
        conductores.remove(conductor);
    }

    //Comprueba que no exista un mecanico para agregar uno nuevo
    public void aniadirMecanico(Mecanico mecanico){
        if (mecanico!=null){
            this.mecanico = mecanico;
        }else{
            System.out.println("Primero se debe despedir al Mecanico que esta en el empresa");
        }

    }

    //elimina el mecanico si es que existe
    public void eliminarMecanico (){
        if (this.mecanico != null){
            mecanico = null;
        }
    }

    //Muestra la cantidad de viajes de los conductores
    public ArrayList ranking_cantviajes() {
        ArrayList<Conductor> copia = new ArrayList<>();
        copia.addAll(conductores);
        int ini = 0;
        int fin = copia.size();
        copia.sort(new Comparator<Conductor>() {
            @Override
            public int compare(Conductor c1, Conductor c2) {
                if (c1.getCant_viajes() > c2.getCant_viajes()) {
                    return -1;

                } else if (c2.getCant_viajes() > c1.getCant_viajes()) {
                    return 1;

                } else {
                    return 0;
                }

            }
        });

        return copia;

    }

    //Muestra el ranking segun la puntuacion de los conductores
    public ArrayList ranking_puntuacion() {
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



    //Asigna un conductor al viaje iniciado por el cliente.
    public void asignacionConductor (Viaje viaje){
        Conductor conductorCandidato = null;

        int i = 0;
        int band=0;
        while (i < conductores.size() && band==0){
            conductorCandidato=conductores.get(i);

            if ( conductorCandidato.getDisponibilidad() && conductorCandidato.getVehiculo().puedeIngresar(viaje) ){
                viaje.setConductor_asignado(conductorCandidato);
                conductorCandidato.setDisponibilidad(false);
                band=1;
            //Si el conductor no pudo aceptar el viaje porque su vehículo está en mal estado, es enviado al mecánico
            }else if (conductorCandidato.getVehiculo().getEstado() <= 40) {
                mecanico.arreglar(conductorCandidato);
            }
            i++;
        }


       // Modificación en el metodo de la empresa
        try {
            if (band == 0) {
                throw new ConductorNoDisponibleException("No se han encontrado conductores disponibles. Intente más tarde. \n");
            } else {
                System.out.println("Se ha encontrado un conductor. Disfrute el viaje con: " + conductorCandidato.getNombre() + ".\n");
            }
        } catch (ConductorNoDisponibleException e) {
            System.out.println(e.getMessage());
        }


    }

}
