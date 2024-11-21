package Empresas;
import Excepciones.FlotaException;
import Vehiculos.Vehiculo;

public class Conductor extends Empleado{
    private int puntuacion;
    private Vehiculo vehiculo;
    private int cantViajes;

    public Conductor(String nombre) {
        super(nombre);
        this.cantViajes = 0;
    }

    public void asignarVehiculo(Vehiculo vehiculo) throws FlotaException {
        if (!vehiculo.getTieneDuenio() && this.vehiculo == null) {
            this.vehiculo = vehiculo;
            vehiculo.setTieneDuenio(true);
        } else if (this.vehiculo != null){
            throw new FlotaException("Este conductor ya es dueño de un vehículo.");
        }else{
            throw new FlotaException("Este vehiculo ya tiene dueño.");
        }
    }


    public Vehiculo getVehiculo(){
        return vehiculo;
    }

    public void setPuntuacion(int puntos) {
        puntuacion = (puntuacion *(cantViajes -1)+ puntos)/ cantViajes;
    }

    public void setSumarViajes() {
        this.cantViajes += 1;
    }

    public int getCantViajes() {
        return cantViajes;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
