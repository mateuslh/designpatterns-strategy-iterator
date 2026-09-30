package br.venson.net.designpatterns.iterator;

/**
 * Iterator: interface comum para percorrer uma colecao de faixas sem
 * expor a estrutura interna do agregado (Playlist).
 */
public interface IteradorFaixas {

    boolean temProxima();

    Faixa proxima();
}
