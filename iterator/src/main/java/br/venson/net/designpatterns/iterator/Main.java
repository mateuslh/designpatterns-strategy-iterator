package br.venson.net.designpatterns.iterator;

public class Main {

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.adicionar(new Faixa("Faixa A", "Artista X", 210, true));
        playlist.adicionar(new Faixa("Faixa B", "Artista Y", 180, false));
        playlist.adicionar(new Faixa("Faixa C", "Artista Z", 240, true));

        Player player = new Player();
        Recomendador recomendador = new Recomendador();
        RelatorioPlaylist relatorio = new RelatorioPlaylist();

        relatorio.resumo(playlist);
        recomendador.sugerirFavoritas(playlist);

        System.out.println("Ordem original: " + descreverOrdem(playlist));
        player.tocarEmbaralhado(playlist);
        // A playlist original nao muda mais: o shuffle atua sobre uma copia
        // criada dentro do proprio iterador embaralhado.
        System.out.println("Ordem apos tocarEmbaralhado: " + descreverOrdem(playlist));
    }

    private static String descreverOrdem(Playlist playlist) {
        StringBuilder sb = new StringBuilder("[");
        IteradorFaixas iterador = playlist.iterador();
        while (iterador.temProxima()) {
            sb.append(iterador.proxima());
            if (iterador.temProxima()) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
