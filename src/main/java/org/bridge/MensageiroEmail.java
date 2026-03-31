package org.bridge;

public class MensageiroEmail implements Mensageiro {
    @Override
    public void enviar(String assunto, String corpo) {
        System.out.println("[EMAIL] Assunto: " + assunto + " | Corpo: " + corpo);
    }
}

