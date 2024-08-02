package yuriimpellizzeri;

public class Application {

    public static void main(String[] args) {

        Catalogo catalogo = new Catalogo();

        // Aggiunta di libri e riviste
        Libro libro1 = new Libro("12345", "HackLog vol1", 2017, 241, "Stefano Novelli", "Sicurezza Informatica");
        Libro libro2 = new Libro("67890", "HackLog vol2", 2018, 374, "Stefano Novelli", "Sicurezza Informatica");

        Rivista rivista1 = new Rivista("09876", "Hacker journal", 2024, 32, Periodicita.SEMETRALE);
        Rivista rivista2 = new Rivista("54321", "Vogue", 2024, 75, Periodicita.MENSILE);

        catalogo.aggiungiElemento(libro1);
        catalogo.aggiungiElemento(libro2);
        catalogo.aggiungiElemento(rivista1);
        catalogo.aggiungiElemento(rivista2);


        System.out.println("Catalogo: ");
        catalogo.getElementi().forEach(System.out::println);


    }


}
