package yuriimpellizzeri;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
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


        while (true) {
            System.out.println("----------- Catalogo ------------");
            catalogo.getElementi().forEach(System.out::println);
            System.out.println("---------------------------------");


            System.out.println("*************** Scegli un opzione per favore (1-5) ***************");
            System.out.println("1 --> Rimuovi un elemento per codice ISBN");
            System.out.println("2 --> Cerca un elemento per codice ISBN");
            System.out.println("3 --> Cerca un elemento per anno di pubblicazione");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {

                case 1:
                    System.out.println("Inserisci l'ISBN da rimuovere per favore.");
                    String isbnDaRimuovere = scanner.nextLine();
                    catalogo.rimuoviElemento(isbnDaRimuovere);
                    System.out.println("elemento eliminato!");
                   

                case 2:
                    System.out.println("Inserisci l'ISBN da cercare per favore.");
                    String isbnDaCercare = scanner.nextLine();
                    Optional<CatalogoElem> elemento = catalogo.cercaElemento(isbnDaCercare);
                    if (elemento.isPresent()) {
                        System.out.println(elemento.get());
                    } else {
                        System.out.println("elemento non trovato");
                    }
                case 3:
                    System.out.println("Inserisci l'anno di pubblicazione da cercare per favore.");
                    int annoDaCercare = scanner.nextInt();
                    List<CatalogoElem> elementiPerAnno = catalogo.cercaPerAnno(annoDaCercare);
                    if (elementiPerAnno.isEmpty()) {
                        System.out.println("nessun elemento trovato per l'anno " + annoDaCercare);
                    } else {
                        elementiPerAnno.forEach(System.out::println);
                    }
            }
        }


    }


}
