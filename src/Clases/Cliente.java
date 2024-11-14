package Clases;

public class Cliente {
    private String nombre;
    private int edad;
    private Viaje viaje_inicializado;
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
    public void iniciarviaje(Viaje viaje, Empresa empresa){
        empresa.asignacionConductor(viaje);
        this.viaje_inicializado = viaje;
    }

    //Se finaliza el viaje anteriormente inicializado. Si no se inicializó el viaje anteriormente no se va a poder finalizar.
    //Se pasa por parámetro una puntuación al conductor, el cual va a repercutir en su atributo "puntuación". También se disminuye el estado del vehículo según los KM hechos.
    public void finalizarViaje(int puntuacion){
        if (viaje_inicializado.getConductor_asignado() != null) {
            System.out.println("Finalizando viaje...\n");
            viaje_inicializado.getConductor_asignado().setSumar_viajes();
            viaje_inicializado.getConductor_asignado().setPuntuacion(puntuacion);
            viaje_inicializado.getConductor_asignado().setDisponibilidad(true);

            int disminucion = viaje_inicializado.getCantKM() / 2 + 1;
            viaje_inicializado.getConductor_asignado().getVehiculo().disminuirEstado(disminucion);
        }
        else{
            System.out.println("No se ha iniciado ningún viaje. \n");
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


}
