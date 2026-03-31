package org.bridge;

public abstract class Mensagem {
    protected final Mensageiro mensageiro;

    protected Mensagem(Mensageiro mensageiro) {
        this.mensageiro = mensageiro;
    }

    public abstract void enviar(String texto);
}

