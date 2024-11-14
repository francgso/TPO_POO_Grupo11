import Clases.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Empresa SplinterVehiculos = new Empresa();

        Mecanico Juanse = new Mecanico("Juanse");
        SplinterVehiculos.aniadirMecanico(Juanse);

        Moto kawasaki = new Moto("aaa", 1, 40, 99);
        Conductor Mario = new Conductor("Mario", kawasaki);
        SplinterVehiculos.aniadirConductor(Mario);

        Moto tornado = new Moto("eee",  1, 40, 100);
        Conductor Tomas= new Conductor("Tomas", tornado);
        SplinterVehiculos.aniadirConductor(Tomas);

        Moto sanela = new Moto("aws456fgh", 1, 40, 100);
        Conductor Facundo = new Conductor("Facundo", sanela);
        SplinterVehiculos.aniadirConductor(Facundo);


        Cliente Cliente1 = new Cliente("Franco",21,86,false,true,false, false);
        Viaje constitucion = new Viaje(Cliente1, "Constitucion", 20,  1);

        Cliente Cliente2 = new Cliente("Juan Pablo",19,68,false,true, false, false);
        Viaje miami = new Viaje(Cliente2, "miami", 20, 1);

        Cliente Cliente3 = new Cliente("Ana Maria", 45, 70, false, true, false,false);
        Viaje viaje3 = new Viaje(Cliente3, "Retiro", 15, 1);

        Cliente Cliente4 = new Cliente("Carlos Perez", 35, 80, false, true, true, true);
        Viaje viaje4 = new Viaje(Cliente4, "Palermo", 10, 1);


        Cliente1.iniciarviaje(constitucion, SplinterVehiculos);
        Cliente2.iniciarviaje(miami, SplinterVehiculos);
        Cliente3.iniciarviaje(viaje3, SplinterVehiculos);
        Cliente4.iniciarviaje(viaje4, SplinterVehiculos);

        Cliente1.finalizarViaje(5);
        Cliente2.finalizarViaje(4);
        Cliente3.finalizarViaje(3);


        Imprimir impresora= new Imprimir();
        impresora.mostrar_ranking(SplinterVehiculos.ranking_puntuacion(), "RANKING DE PUNTOS");
        impresora.mostrar_ranking(SplinterVehiculos.ranking_cantviajes(), "RANKING DE CANTIDAD DE VIAJES");

    }
}