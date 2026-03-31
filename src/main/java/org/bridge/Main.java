package org.bridge;

public class Main {
    public static void main(String[] args) {
        Mensageiro email = new MensageiroEmail();
        Mensageiro sms = new MensageiroSms();

        Mensagem simples = new MensagemSimples(email);
        Mensagem urgente = new MensagemUrgente(sms);

        simples.enviar("Relatório mensal pronto.");
        urgente.enviar("Servidor principal fora do ar!");

        Coordenador coordenador = new Coordenador();
        coordenador.adicionar(simples);
        coordenador.adicionar(urgente);

        System.out.println("--- Enviando via Coordenador ---");
        coordenador.enviarTodas("Aviso: manutenção programada às 22h.");
    }
}