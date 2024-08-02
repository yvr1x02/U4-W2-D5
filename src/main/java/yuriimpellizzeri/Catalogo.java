package yuriimpellizzeri;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalogo {
    private List<CatalogoElem> elementi;

    public Catalogo() {
        this.elementi = new ArrayList<>();
    }

    // Aggiunta di un elemento
    public void aggiungiElemento(CatalogoElem elemento) {
        elementi.add(elemento);
    }

    // rimoxione di un elemento dato un codice ISBN

    public void rimuoviElemento(String isbn) {
        elementi.removeIf(elemento -> elemento.getIsbn().equals(isbn));
    }

    //ricerca per ISBN

    public Optional<CatalogoElem> cercaElemento(String isbn) {
        return elementi.stream()
                .filter(elemento -> elemento.getIsbn().equals(isbn))
                .findFirst();
    }


    public List<CatalogoElem> getElementi() {
        return new ArrayList<>(elementi);
    }
}
