package org.bridge;

import java.util.ArrayList;
import java.util.List;

public class Coordenador {
    private final List<Mensagem> mensagens;

    public Coordenador() {
        this.mensagens = new ArrayList<>();
    }

    public void adicionar(Mensagem mensagem) {
        if (mensagem != null) {
            mensagens.add(mensagem);
        }
    }

    public void enviarTodas(String texto) {
        for (Mensagem m : mensagens) {
            m.enviar(texto);
        }
    }

    public void limpar() {
        mensagens.clear();
    }

    public int quantidade() {
        return mensagens.size();
    }
}


