package Empresas;

public class Mecanico extends Empleado{
    private Conductor conductorAtendido;

    public Mecanico(String nombre) {
        super(nombre);
    }

    //Funcion que permite arreglar el vehiculo. Marca al mecanico y al conductor como no disponible mientas lo arregla
    public void arreglar(Conductor conductor){
        this.setDisponibilidad(false);
        conductor.setDisponibilidad(false);
        conductor.getVehiculo().setEstado(100);
        conductorAtendido = conductor;
        entregarVehiculo();
    }

    //Devuelve el vehiculo y marca al mecanico y conductor como disponible
    private void entregarVehiculo(){
        this.setDisponibilidad(true);
        conductorAtendido.setDisponibilidad(true);
    }

}
