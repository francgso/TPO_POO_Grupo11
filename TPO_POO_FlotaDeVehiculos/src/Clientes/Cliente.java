package Clientes;

import Excepciones.FlotaException;
import Empresas.Empresa;

public class Cliente {
    private String nombre;
    private int edad;
    private Viaje viajeInicializado;
    private int peso;
    private boolean esDiscapacitado;
    private boolean traeCasco;
    private boolean tieneAnimales;
    private boolean tieneEquipaje;


    public Cliente(String nombre, int edad, int peso, boolean esDiscapacitado, boolean traeCasco, boolean tieneAnimales, boolean tieneEquipaje) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.esDiscapacitado = esDiscapacitado;
        this.traeCasco = traeCasco;
        this.tieneAnimales = tieneAnimales;
        this.tieneEquipaje = tieneEquipaje;
    }
    //El cliente inicia un viaje ya creado, solicitando un conductor que cumpla con las exigencias del viaje.
    public void iniciarviaje(Viaje viaje, Empresa empresa) throws FlotaException {
        if (this.viajeInicializado == null) {
            empresa.asignacionConductor(viaje);
            this.viajeInicializado = viaje;
        } else{
            throw new FlotaException("Ya has inicializado un viaje. Debes de finalizarlo antes de comenzar otro.");
        }

    }

    /*Se finaliza el viaje anteriormente inicializado. Si no se inicializó el viaje anteriormente no se va a poder finalizar.
      Se pasa por parámetro una puntuación al conductor, el cual va a repercutir en su atributo "puntuación".
      También se disminuye el estado del vehículo según los KM hechos.*/

    public void finalizarViaje(int puntuacion) throws FlotaException{
        if (this.viajeInicializado !=null && viajeInicializado.getConductorAsignado() != null) {

            viajeInicializado.getConductorAsignado().setSumarViajes();
            viajeInicializado.getConductorAsignado().setPuntuacion(puntuacion);
            viajeInicializado.getConductorAsignado().setDisponibilidad(true);

            int disminucion = viajeInicializado.getCantKM() / 2 + 1;
            viajeInicializado.getConductorAsignado().getVehiculo().disminuirEstado(disminucion);
            this.viajeInicializado=null;
        }
        else{
            throw new FlotaException ("No se ha iniciado ningún viaje. \n");
        }
    }

    public boolean getEsDiscapacitado(){
        return esDiscapacitado;
    }

    public int getPeso() {
        return peso;
    }

    public boolean traeCasco() {
        return traeCasco;
    }

    public boolean tieneAnimales() {
        return tieneAnimales;
    }

    public boolean tieneEquipaje() {
        return tieneEquipaje;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() { return nombre; }

}
