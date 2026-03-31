package org.bridge.mensageiro;

import org.bridge.Mensageiro;
import org.bridge.MensageiroEmail;
import org.bridge.MensageiroSms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MensageiroTest {
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
    public void emailEnvia() {
        Mensageiro email = new MensageiroEmail();
        email.enviar("AssuntoTeste", "CorpoTeste");
        String s = outContent.toString();
        assertTrue(s.contains("[EMAIL]"));
        assertTrue(s.contains("AssuntoTeste"));
        assertTrue(s.contains("CorpoTeste"));
    }

    @Test
    public void smsEnvia() {
        Mensageiro sms = new MensageiroSms();
        sms.enviar("AssuntoSMS", "CorpoSMS");
        String s = outContent.toString();
        assertTrue(s.contains("[SMS]"));
        assertTrue(s.contains("AssuntoSMS"));
        assertTrue(s.contains("CorpoSMS"));
    }
}

