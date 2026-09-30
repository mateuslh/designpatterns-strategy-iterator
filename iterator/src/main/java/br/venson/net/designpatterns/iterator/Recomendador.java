package br.venson.net.designpatterns.iterator;

public class Recomendador {

    public void sugerirFavoritas(Playlist playlist) {
        System.out.println("Favoritas:");
        IteradorFaixas iterador = playlist.iteradorFavoritas();
        while (iterador.temProxima()) {
            System.out.println("  * " + iterador.proxima());
        }
    }
}
