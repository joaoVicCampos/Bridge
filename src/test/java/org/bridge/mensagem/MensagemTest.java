package org.bridge.mensagem;

import org.bridge.Mensagem;
import org.bridge.MensagemSimples;
import org.bridge.MensagemUrgente;
import org.bridge.Mensageiro;
import org.bridge.MensageiroEmail;
import org.bridge.MensageiroSms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MensagemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }

    @Test
    public void simplesDelegatesToMensageiro() {
        Mensageiro email = new MensageiroEmail();
        Mensagem simples = new MensagemSimples(email);
        simples.enviar("TextoSimples");
        String s = outContent.toString();
        assertTrue(s.contains("[EMAIL]"));
        assertTrue(s.contains("TextoSimples"));
    }

    @Test
    public void urgenteDelegatesToMensageiro() {
        Mensageiro sms = new MensageiroSms();
        Mensagem urgente = new MensagemUrgente(sms);
        urgente.enviar("TextoUrgente");
        String s = outContent.toString();
        assertTrue(s.contains("[SMS]"));
        assertTrue(s.contains("TextoUrgente"));
    }
}

