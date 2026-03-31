package org.bridge.coordenador;

import org.bridge.Coordenador;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordenadorTest {
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
    public void enviarTodasEnviaParaTodos() {
        Mensageiro email = new MensageiroEmail();
        Mensageiro sms = new MensageiroSms();
        Mensagem simples = new MensagemSimples(email);
        Mensagem urgente = new MensagemUrgente(sms);

        Coordenador c = new Coordenador();
        c.adicionar(simples);
        c.adicionar(urgente);
        c.enviarTodas("Broadcast");

        String s = outContent.toString();
        assertTrue(s.contains("[EMAIL]"));
        assertTrue(s.contains("[SMS]"));
        assertTrue(s.contains("Broadcast"));
    }

    @Test
    public void limparEAvaliarQuantidade() {
        Mensageiro email = new MensageiroEmail();
        Mensagem simples = new MensagemSimples(email);
        Coordenador c = new Coordenador();
        c.adicionar(simples);
        assertEquals(1, c.quantidade());
        c.limpar();
        assertEquals(0, c.quantidade());
    }
}

