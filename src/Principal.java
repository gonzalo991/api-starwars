import modelos.Pelicula;
import servicios.ConsultaPelicula;
import servicios.GeneradorDeArchivos;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Escriba el número de la película de Star Wars que quiere consultar");

        try{
            var numeroDePelicula = Integer.parseInt(lectura.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
            System.out.println(pelicula);
            GeneradorDeArchivos generador = new GeneradorDeArchivos();
            generador.guardarJson(pelicula);
        } catch(NumberFormatException e){
            System.out.println("Numero no encontrado: "+ e.getMessage());
        } catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación");
        }
    }
}