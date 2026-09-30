package br.venson.net.designpatterns.strategy;

public class RelatorioPedido {

    public String formatar(Pedido pedido) {
        double valorDesconto = pedido.calcularDesconto();
        double valorFrete = pedido.calcularFrete();
        double total = pedido.getValor() - valorDesconto + valorFrete;

        return String.format(
                "%s | valor: %.2f | desconto: %.2f | frete: %.2f | total: %.2f",
                pedido.getEtiquetaCliente(), pedido.getValor(), valorDesconto, valorFrete, total);
    }
}
