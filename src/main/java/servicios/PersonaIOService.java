package servicios;

import com.google.gson.Gson;
import modelos.Persona;

import java.io.*;
import java.util.List;

public class PersonaIOService {
    private Persona persona;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private String path = "src/main/resources/datos/empleados.json";

    public void escribirJson(List<Persona> personaList){
        try {
            fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            String personaJson = new Gson().toJson(personaList);
            bufferedWriter.write(personaJson);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo"+e.getMessage());
        }
    }

    public Persona leerJson(){
        String linea, fichero="";
        try{
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            while ((linea = bufferedReader.readLine()) != null) {
                fichero += linea;
            }
            persona = new Gson().fromJson(fichero, Persona.class);
        } catch (IOException e) {
            System.out.println("No existe el archivo");
        }
        return persona;
    }
}
