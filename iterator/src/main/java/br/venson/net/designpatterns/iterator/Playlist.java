package br.venson.net.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aggregate: guarda as faixas e cria iteradores para percorre-las de
 * diferentes formas, sem devolver a lista interna a nenhum cliente.
 */
public class Playlist {
    private final List<Faixa> faixas = new ArrayList<>();

    public void adicionar(Faixa faixa) {
        faixas.add(faixa);
    }

    public int tamanho() {
        return faixas.size();
    }

    public IteradorFaixas iterador() {
        return new ListaFaixasIterator(new ArrayList<>(faixas));
    }

    public IteradorFaixas iteradorEmbaralhado() {
        List<Faixa> copiaEmbaralhada = new ArrayList<>(faixas);
        Collections.shuffle(copiaEmbaralhada);
        return new ListaFaixasIterator(copiaEmbaralhada);
    }

    public IteradorFaixas iteradorFavoritas() {
        List<Faixa> favoritas = new ArrayList<>();
        for (Faixa faixa : faixas) {
            if (faixa.isFavorita()) {
                favoritas.add(faixa);
            }
        }
        return new ListaFaixasIterator(favoritas);
    }
}
