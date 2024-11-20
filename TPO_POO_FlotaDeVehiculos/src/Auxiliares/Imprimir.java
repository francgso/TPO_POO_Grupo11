package Auxiliares;
import Empresas.Conductor;

import java.util.ArrayList;

public class Imprimir {

    public void mostrarRankingPuntos(ArrayList <Conductor> copia, String mensaje){
        System.out.println(mensaje);
        System.out.printf("%-10s %-20s %-10s%n", "POSICIÓN", "NOMBRE", "PUNTOS");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < copia.size(); i++) {
            System.out.printf("%-10s %-20s %-10s%n", (i + 1) + "°", copia.get(i).getNombre(), copia.get(i).getPuntuacion());
        }

        System.out.println("\n");
    }

    public void mostrarRankingViajes(ArrayList<Conductor> copia, String mensaje) {
        System.out.println(mensaje);
        System.out.printf("%-10s %-20s %-10s%n", "POSICIÓN", "NOMBRE", "PUNTOS");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < copia.size(); i++) {
            System.out.printf("%-10s %-20s %-10s%n", (i + 1) + "°", copia.get(i).getNombre(), copia.get(i).getCantViajes());
        }

        System.out.println("\n");
    }

}
