package Clases;

public class Viaje {
    private Cliente cliente;
    private String Destino;
    private int cantKM;
    private Conductor conductor_asignado;
    private int capacidad;


    public Viaje(Cliente cliente, String destino, int cantKM, int capacidad) {
        this.cliente = cliente;
        Destino = destino;
        this.cantKM = cantKM;
        this.capacidad = capacidad;
    }


    public void setConductor_asignado(Conductor conductor_asignado) {
        this.conductor_asignado = conductor_asignado;

    }

    public int getCapacidad (){
        return capacidad;
    }

    public Conductor getConductor_asignado(){
        return conductor_asignado;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public int getCantKM() {
        return cantKM;
    }
}
