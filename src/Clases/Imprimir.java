package Clases;
import java.util.ArrayList;

public class Imprimir {

    //Estamos probando
    public void mostrar(String mensaje){
        System.out.println(mensaje);
    }

    public void mostrar_ranking(ArrayList <Conductor> copia, String mensaje){
        System.out.println(mensaje);
        for (int i = 1; i < copia.size()+1; i++) {
            System.out.println(""+i+"° Posición:" + copia.get(i-1).getPuntuacion() + " \tNombre: "+ copia.get(i-1).getNombre());
        }
        System.out.println();
    }

}
