package org.bridge;

public class MensageiroSms implements Mensageiro {
    @Override
    public void enviar(String assunto, String corpo) {
        System.out.println("[SMS] " + assunto + " - " + corpo);
    }
}

