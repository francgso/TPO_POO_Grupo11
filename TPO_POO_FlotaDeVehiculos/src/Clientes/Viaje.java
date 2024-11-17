package Clientes;

import Excepciones.FlotaException;
import Empresas.Conductor;

public class Viaje {
    private Cliente cliente;
    private String Destino;
    private int cantKM;
    private Conductor conductorAsignado;
    private int cantPersonas;
    private int tarifa;


    public Viaje(Cliente cliente, String destino, int cantKM, int cantPersonas) {
        this.cliente = cliente;
        Destino = destino;
        this.cantKM = cantKM;
        this.cantPersonas = cantPersonas;
    }

    public boolean clienteDiscapacitado(){
        return this.cliente.getEsDiscapacitado();
    }

    public boolean clienteEquipaje(){
        return this.cliente.tieneEquipaje();
    }

    public int clienteEdad(){
        return this.cliente.getEdad();
    }

    public int clientePeso(){
        return this.cliente.getPeso();
    }

    public boolean clienteCasco(){
        return this.cliente.traeCasco();
    }

    public boolean clienteTieneAnimales(){
        return this.cliente.tieneAnimales();
    }


    public void setConductorAsignado(Conductor conductorAsignado) {
        this.conductorAsignado = conductorAsignado;
    }

    public int getCantPersonas(){
        return cantPersonas;
    }

    public Conductor getConductorAsignado(){
        return conductorAsignado;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public int getCantKM() {
        return cantKM;
    }

    public void setTarifa(int tarifa){
        this.tarifa = tarifa;
    }

    public int getTarifa() throws FlotaException {
        if (this.tarifa != 0){
            return tarifa;

        }
        else{
            throw new FlotaException("No existe una tarifa debido a que no se ha podido inicializar el viaje");
        }
    }
}

