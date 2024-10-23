import servicios.PersonaService;


public class Principal {
    public static void main(String[] args) {
        PersonaService personaService = new PersonaService();
        personaService.menu();
    }
}
