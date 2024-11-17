import Auxiliares.Imprimir;
import Excepciones.FlotaException;
import Clientes.Cliente;
import Clientes.Viaje;
import Empresas.Conductor;
import Empresas.Empresa;
import Empresas.Mecanico;
import Vehículos.Auto;
import Vehículos.Autobus;
import Vehículos.Moto;


public class Main {
    public static void main(String[] args) {
        Empresa SplinterVehiculos = new Empresa();

        Mecanico Juanse = new Mecanico("Juan Sebastian Aragón Gaudelli");
        try {
            SplinterVehiculos.aniadirMecanico(Juanse);
        } catch (FlotaException e){
            System.out.println(e.getMessage());
        }

        Moto kawasaki = new Moto("aaa", 1, 40, 99);
        Conductor Mario = new Conductor("Mario", kawasaki);
        SplinterVehiculos.aniadirConductor(Mario);

        Moto tornado = new Moto("eee",  1, 40, 100);
        Conductor Tomas= new Conductor("Tomas", tornado);
        SplinterVehiculos.aniadirConductor(Tomas);

        Moto sanela = new Moto("aws456fgh", 1, 40, 100);
        Conductor Facundo = new Conductor("Facundo", sanela);
        SplinterVehiculos.aniadirConductor(Facundo);

        Auto palio = new Auto("ab 123 cd", 4, 100,true, true);
        Conductor Santiago = new Conductor("Santiago", palio);
        SplinterVehiculos.aniadirConductor(Santiago);

        Autobus linea134 = new Autobus("fg 456 kj", 40, 100);
        Conductor Sebastian = new Conductor("Sebastian", linea134);
        SplinterVehiculos.aniadirConductor(Sebastian);


        Cliente Cliente1 = new Cliente("Franco",21,86,false,true,false, false);
        Viaje constitucion = new Viaje(Cliente1, "Constitucion", 20,  1);

        Cliente Cliente2 = new Cliente("Juan Pablo",19,68,false,true, false, false);
        Viaje miami = new Viaje(Cliente2, "miami", 20, 1);

        Cliente Cliente3 = new Cliente("Ana Maria", 45, 70, false, true, false,false);
        Viaje viaje3 = new Viaje(Cliente3, "Retiro", 15, 1);

        Cliente Cliente4 = new Cliente("Carlos Perez", 35, 80, false, true, true, true);
        Viaje viaje4 = new Viaje(Cliente4, "Palermo", 10, 1);


        //INICIALIZAMOS VIAJES
        try {
            Cliente1.iniciarviaje(constitucion, SplinterVehiculos);
        } catch (FlotaException e) {
            System.out.println(e.getMessage());
        }

        try {
            Cliente1.iniciarviaje(miami, SplinterVehiculos);
        } catch (FlotaException e) {
            System.out.println(e.getMessage());
        }

        try {
            Cliente2.iniciarviaje(miami, SplinterVehiculos);
        }catch (FlotaException e){
            System.out.println(e.getMessage());
        }

        try {
            Cliente3.iniciarviaje(viaje3, SplinterVehiculos);
        }catch(FlotaException e){
            System.out.println(e.getMessage());
        }

        try {
            Cliente4.iniciarviaje(viaje4, SplinterVehiculos);
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
            Cliente1.finalizarViaje(5);
        } catch(FlotaException e) {
            System.out.println(e.getMessage());
        }

        try {
            Cliente2.finalizarViaje(4);
        } catch(FlotaException e) {
            System.out.println(e.getMessage());
        }

        try {
            Cliente3.finalizarViaje(3);
        } catch(FlotaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n");

        Imprimir impresora= new Imprimir();
        impresora.mostrarRankingPuntos(SplinterVehiculos.rankingPuntuacion(), "RANKING DE PUNTOS");
        impresora.mostrarRankingViajes(SplinterVehiculos.rankingCantViajes(), "RANKING DE CANTIDAD DE VIAJES");

    }
}