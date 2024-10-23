package servicios;

import Lpersonas.Lpersonas;
import com.google.gson.Gson;
import modelos.Persona;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PersonaService {
    private Persona persona;
    private Scanner sc;
    private PersonaIOService personaIOService;
    Scanner scan = new Scanner(System.in);
    public PersonaService() {
        sc = new Scanner(System.in);
        personaIOService = new PersonaIOService();
    }

    public void menu(){
        int opcion = 0;
        do{
            System.out.println("MENU DE OPCIONES JSON");
            System.out.println("1 -> CREAR EMPLEADO ");
            System.out.println("2 -> VISUALIZAR EMPLEADO ");
            System.out.println("0 -> SALIR DEL  MENU ");
            System.out.println("Ingrese una opcion del menu");
            opcion = sc.nextInt();
            switch (opcion){
                case 1: CrearPersona();
                    break;
                case 2: LeerJson();
                    break;
                case 3: opcion = 0;
            }
        }while (opcion != 0);

    }

    public List<Persona> LeerJson() {
        Gson gson = new Gson();
        List<Persona> listaPersonas = new ArrayList<>();
        String path = "src/main/resources/datos/empleados.json";

        System.out.println("Intentando leer el archivo en: " + path);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            String jsonString = jsonStringBuilder.toString();
            Persona[] personasArray = gson.fromJson(jsonString, Persona[].class);

            listaPersonas = Arrays.asList(personasArray);


            System.out.println("Cantidad de personas leídas: " + listaPersonas.size());
            for (Persona p : listaPersonas) {
                System.out.println(p);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            e.printStackTrace();
        }

        return listaPersonas;
    }


    private List<Persona> CrearPersona() {
        List<Persona> listaPersonas = new ArrayList<>();
        boolean p = true;

        while (p) {
            System.out.println("Ingrese el nombre:");
            String nombre = sc.next();
            System.out.println("Ingrese el telefono:");
            String telefono = sc.next();
            System.out.println("Ingrese el correo:");
            String correo = sc.next();
            String fechaActual = new Date().toString();

            Persona persona = new Persona(nombre, telefono, correo, fechaActual);
            listaPersonas.add(persona);


            personaIOService.escribirJson(listaPersonas);
            System.out.println("Se guardó la persona " + persona + " en un archivo JSON.");

            System.out.println("¿Crear una nueva persona? (y/n)");
            String s = sc.next();
            if (!s.equalsIgnoreCase("y")) {
                p = false;
            }
        }

        return listaPersonas;
    }

}









