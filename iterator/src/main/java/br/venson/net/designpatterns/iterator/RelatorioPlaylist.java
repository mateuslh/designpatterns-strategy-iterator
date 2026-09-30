package br.venson.net.designpatterns.iterator;

public class RelatorioPlaylist {

    public void resumo(Playlist playlist) {
        int totalSegundos = 0;
        IteradorFaixas iterador = playlist.iterador();
        while (iterador.temProxima()) {
            totalSegundos += iterador.proxima().getDuracaoSegundos();
        }
        System.out.printf("Total de faixas: %d | duracao: %d min%n",
                playlist.tamanho(), totalSegundos / 60);
    }
}
