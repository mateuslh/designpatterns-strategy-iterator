package br.venson.net.designpatterns.iterator;

public class Player {

    public void tocarTudo(Playlist playlist) {
        IteradorFaixas iterador = playlist.iterador();
        while (iterador.temProxima()) {
            System.out.println("Tocando: " + iterador.proxima());
        }
    }

    public void tocarEmbaralhado(Playlist playlist) {
        // O embaralhamento acontece numa copia; a playlist original nao muda.
        IteradorFaixas iterador = playlist.iteradorEmbaralhado();
        while (iterador.temProxima()) {
            System.out.println("Tocando (shuffle): " + iterador.proxima());
        }
    }
}
