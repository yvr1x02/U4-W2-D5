package yuriimpellizzeri;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();

        try {
            // Aggiunta di libri e riviste
            Libro libro1 = new Libro("12345", "HackLog vol1", 2017, 241, "Stefano Novelli", "Sicurezza Informatica");
            Libro libro2 = new Libro("67890", "HackLog vol2", 2018, 374, "Stefano Novelli", "Sicurezza Informatica");

            Rivista rivista1 = new Rivista("09876", "Hacker journal", 2024, 32, Periodicita.SEMESTRALE);
            Rivista rivista2 = new Rivista("54321", "Vogue", 2024, 75, Periodicita.MENSILE);

            catalogo.aggiungiElemento(libro1);
            catalogo.aggiungiElemento(libro2);
            catalogo.aggiungiElemento(rivista1);
            catalogo.aggiungiElemento(rivista2);
        } catch (Exception e) {
            System.out.println("Errore nell'inserimento degli elementi nel catalogo: " + e.getMessage());
        }

        while (true) {
            try {
                System.out.println("----------- Catalogo ------------");
                catalogo.getElementi().forEach(System.out::println);
                System.out.println("---------------------------------");

                System.out.println("*************** Scegli un'opzione per favore (1-5) ***************");
                System.out.println("1 --> Rimuovi un elemento per codice ISBN");
                System.out.println("2 --> Cerca un elemento per codice ISBN");
                System.out.println("3 --> Cerca un elemento per anno di pubblicazione");
                System.out.println("4 --> Cerca un elemento per autore");
                System.out.println("5 --> Esci");


                String input = scanner.nextLine();
                int scelta;
                try {
                    scelta = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Errore: Inserisci un numero valido.");
                    continue;
                }

                switch (scelta) {
                    case 1:
                        System.out.println("Inserisci l'ISBN da rimuovere per favore.");
                        String isbnDaRimuovere = scanner.nextLine();
                        catalogo.rimuoviElemento(isbnDaRimuovere);
                        System.out.println("Elemento eliminato!");
                        break;

                    case 2:
                        System.out.println("Inserisci l'ISBN da cercare per favore.");
                        String isbnDaCercare = scanner.nextLine();
                        Optional<CatalogoElem> elemento = catalogo.cercaElemento(isbnDaCercare);
                        if (elemento.isPresent()) {
                            System.out.println(elemento.get());
                        } else {
                            System.out.println("Elemento non trovato.");
                        }
                        break;

                    case 3:
                        System.out.println("Inserisci l'anno di pubblicazione da cercare per favore.");
                        int annoDaCercare;
                        try {
                            annoDaCercare = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Errore: Inserisci un anno valido.");
                            continue;
                        }
                        List<CatalogoElem> elementiPerAnno = catalogo.cercaPerAnno(annoDaCercare);
                        if (elementiPerAnno.isEmpty()) {
                            System.out.println("Nessun elemento trovato per l'anno " + annoDaCercare);
                        } else {
                            elementiPerAnno.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        System.out.print("Inserisci l'autore da cercare per favore. ");
                        String autoreDaCercare = scanner.nextLine();
                        List<Libro> libriPerAutore = catalogo.cercaPerAutore(autoreDaCercare);
                        if (libriPerAutore.isEmpty()) {
                            System.out.println("Nessun libro trovato per l'autore " + autoreDaCercare);
                        } else {
                            System.out.println("Libri trovati per l'autore " + autoreDaCercare);
                            libriPerAutore.forEach(System.out::println);
                        }
                        break;

                    case 5:
                        System.out.println("Uscita...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opzione non valida. Per favore scegli un numero tra 1 e 5.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }
}
