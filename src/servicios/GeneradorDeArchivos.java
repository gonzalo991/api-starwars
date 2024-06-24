package servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Pelicula;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivos {

    public void guardarJson(Pelicula pelicula) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escritura = new FileWriter(pelicula.title()+".json");
        escritura.write(gson.toJson(pelicula));
        escritura.close();
    }
}
