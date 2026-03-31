package org.bridge;

public class MensagemUrgente extends Mensagem {
    public MensagemUrgente(Mensageiro mensageiro) {
        super(mensageiro);
    }

    @Override
    public void enviar(String texto) {
        mensageiro.enviar("URGENTE", texto);
    }
}

