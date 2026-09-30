package br.venson.net.designpatterns.strategy;

/**
 * Strategy: define a familia de algoritmos que variam por tipo de cliente
 * (desconto, frete e etiqueta do relatorio).
 */
public interface RegraCliente {

    double calcularDesconto(Pedido pedido);

    double calcularFrete(Pedido pedido);

    String getEtiqueta();
}
