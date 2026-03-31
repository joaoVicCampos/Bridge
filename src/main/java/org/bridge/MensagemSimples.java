package org.bridge;

public class MensagemSimples extends Mensagem {
    public MensagemSimples(Mensageiro mensageiro) {
        super(mensageiro);
    }

    @Override
    public void enviar(String texto) {
        mensageiro.enviar("MENSAGEM", texto);
    }
}

