package br.venson.net.designpatterns.strategy;

/**
 * Context: mantem uma referencia a RegraCliente atual e delega a ela o
 * calculo de desconto, frete e a etiqueta do relatorio. A regra pode ser
 * trocada em tempo de execucao com setRegraCliente().
 */
public class Pedido {
    private final double valor;
    private final double peso;
    private final String regiao;
    private RegraCliente regraCliente;

    public Pedido(RegraCliente regraCliente, double valor, double peso, String regiao) {
        this.regraCliente = regraCliente;
        this.valor = valor;
        this.peso = peso;
        this.regiao = regiao;
    }

    public void setRegraCliente(RegraCliente regraCliente) {
        this.regraCliente = regraCliente;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }

    public String getRegiao() {
        return regiao;
    }

    public double calcularDesconto() {
        return regraCliente.calcularDesconto(this);
    }

    public double calcularFrete() {
        return regraCliente.calcularFrete(this);
    }

    public String getEtiquetaCliente() {
        return regraCliente.getEtiqueta();
    }
}
