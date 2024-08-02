package yuriimpellizzeri;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<CatalogoElem> elementi;

    public Catalogo() {
        this.elementi = new ArrayList<>();
    }

    // Aggiunta di un elemento
    public void aggiungiElemento(CatalogoElem elemento) {
        elementi.add(elemento);
    }


}
