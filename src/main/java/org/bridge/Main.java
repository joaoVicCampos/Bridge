package org.bridge;

public class Main {
    public static void main(String[] args) {
        Mensageiro email = new MensageiroEmail();
        Mensageiro sms = new MensageiroSms();

        Mensagem simples = new MensagemSimples(email);
        Mensagem urgente = new MensagemUrgente(sms);

        simples.enviar("Relatório mensal pronto.");
        urgente.enviar("Servidor principal fora do ar!");
    }
}