import Auxiliares.Imprimir;
import Excepciones.FlotaException;
import Clientes.Cliente;
import Clientes.Viaje;
import Empresas.Conductor;
import Empresas.Empresa;
import Empresas.Mecanico;
import Vehiculos.Auto;
import Vehiculos.Autobus;
import Vehiculos.Moto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Empresa splinterVehiculos = new Empresa();

        Mecanico juanse = new Mecanico("Juan Sebastian Aragón Gaudelli");
        try {
            splinterVehiculos.aniadirMecanico(juanse);
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }


        Moto kawasaki = new Moto("aaa", 1, 40, 99);
        Conductor mario = new Conductor("Mario", kawasaki);
        try {
            splinterVehiculos.aniadirConductor(mario);
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }


        Moto tornado = new Moto("eee",  1, 40, 100);
        Conductor tomas= new Conductor("Tomas", tornado);
        try {
            splinterVehiculos.aniadirConductor(tomas);
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }


        Moto sanela = new Moto("aws456fgh", 1, 40, 100);
        Conductor facundo = new Conductor("Facundo", sanela);
        try {
            splinterVehiculos.aniadirConductor(facundo);
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }


        Auto palio = new Auto("ab 123 cd", 4, 100,true, true);
        Conductor santiago = new Conductor("Santiago", palio);
        try {
            splinterVehiculos.aniadirConductor(santiago);
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }


        Autobus autobus1 = new Autobus("fg 456 kj", 40, 100);
        Conductor sebastian = new Conductor("Sebastian", autobus1);
        try {
            splinterVehiculos.aniadirConductor(sebastian);
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }


        Cliente cliente1 = new Cliente("Franco",21,86,false,true,false, false);
        Viaje constitucion = new Viaje(cliente1, "Constitucion", 20,  1);

        Cliente cliente2 = new Cliente("Juan Pablo",19,68,false,true, false, false);
        Viaje miami = new Viaje(cliente2, "miami", 20, 1);

        Cliente cliente3 = new Cliente("Ana Maria", 45, 70, false, true, false,false);
        Viaje viaje3 = new Viaje(cliente3, "Retiro", 15, 1);

        Cliente cliente4 = new Cliente("Carlos Perez", 35, 80, false, true, true, true);
        Viaje viaje4 = new Viaje(cliente4, "Palermo", 10, 1);


        //INICIALIZAMOS VIAJES
        try {
            cliente1.iniciarviaje(constitucion, splinterVehiculos);
        } catch (FlotaException e) {
            System.out.println(e.getMessage());
        }

        try {
            cliente1.iniciarviaje(miami, splinterVehiculos);
        } catch (FlotaException e) {
            System.out.println(e.getMessage());
        }

        try {
            cliente2.iniciarviaje(miami, splinterVehiculos);
        }catch (FlotaException e){
            System.out.println(e.getMessage());
        }

        try {
            cliente3.iniciarviaje(viaje3, splinterVehiculos);
        }catch(FlotaException e){
            System.out.println(e.getMessage());
        }

        try {
            cliente4.iniciarviaje(viaje4, splinterVehiculos);
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }



        //COMPROBAMOS SI UN VIAJE TIENE UNA TARIFA ASIGNADA
        try{
            System.out.println(viaje4.getTarifa());
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }


        //FINALIZAMOS VIAJES
        try {
            cliente1.finalizarViaje(5);
        } catch(FlotaException e) {
            System.out.println(e.getMessage());
        }

        try {
            cliente2.finalizarViaje(4);
        } catch(FlotaException e) {
            System.out.println(e.getMessage());
        }

        try {
            cliente3.finalizarViaje(3);
        } catch(FlotaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n");

        Imprimir impresora= new Imprimir();
        impresora.mostrarRankingPuntos(splinterVehiculos.rankingPuntuacion(), "RANKING DE PUNTOS");
        impresora.mostrarRankingViajes(splinterVehiculos.rankingCantViajes(), "RANKING DE CANTIDAD DE VIAJES");

    }
}