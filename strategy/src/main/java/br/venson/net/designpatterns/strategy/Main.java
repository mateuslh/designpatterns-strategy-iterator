package br.venson.net.designpatterns.strategy;

public class Main {

    public static void main(String[] args) {
        RelatorioPedido relatorio = new RelatorioPedido();

        Pedido comum = new Pedido(new RegraClienteComum(), 200.0, 2.0, "sul");
        Pedido vip = new Pedido(new RegraClienteVip(), 200.0, 2.0, "sul");
        Pedido corporativo = new Pedido(new RegraClienteCorporativo(), 200.0, 2.0, "norte");

        System.out.println(relatorio.formatar(comum));
        System.out.println(relatorio.formatar(vip));
        System.out.println(relatorio.formatar(corporativo));

        // Trocando a regra em tempo de execucao, sem recompilar nenhuma classe:
        comum.setRegraCliente(new RegraClienteVip());
        System.out.println("Apos upgrade para VIP -> " + relatorio.formatar(comum));

        // Adicionar um novo tipo de cliente agora exige apenas UMA nova classe
        // (implementar RegraCliente). Pedido, RelatorioPedido e as demais
        // regras nao precisam ser tocadas.
    }
}
