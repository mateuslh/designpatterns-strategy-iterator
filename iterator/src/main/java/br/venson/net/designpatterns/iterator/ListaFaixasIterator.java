package br.venson.net.designpatterns.iterator;

import java.util.List;

/**
 * ConcreteIterator: percorre sequencialmente uma lista de faixas ja
 * preparada (original, embaralhada ou filtrada) sem expor essa lista
 * ao cliente.
 */
public class ListaFaixasIterator implements IteradorFaixas {
    private final List<Faixa> faixas;
    private int posicaoAtual = 0;

    public ListaFaixasIterator(List<Faixa> faixas) {
        this.faixas = faixas;
    }

    @Override
    public boolean temProxima() {
        return posicaoAtual < faixas.size();
    }

    @Override
    public Faixa proxima() {
        return faixas.get(posicaoAtual++);
    }
}
