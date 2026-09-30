package br.venson.net.designpatterns.strategy;

public class RegraClienteCorporativo implements RegraCliente {

    @Override
    public double calcularDesconto(Pedido pedido) {
        return pedido.getValor() * 0.20;
    }

    @Override
    public double calcularFrete(Pedido pedido) {
        double freteBase = 0.0;
        double fretePorPeso = pedido.getPeso() * 3.0;
        double adicionalRegiao = pedido.getRegiao().equalsIgnoreCase("norte") ? 30.0 : 0.0;
        return freteBase + fretePorPeso + adicionalRegiao;
    }

    @Override
    public String getEtiqueta() {
        return "Cliente corporativo (20% de desconto)";
    }
}
