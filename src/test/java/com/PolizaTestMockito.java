package com;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PolizaTestMockito {

    // @Mock: "Voy a controlar el Cliente para que siempre me diga que es Premium y me dé un nombre"
    @Mock
    private Cliente clienteMock;

    // @InjectMocks: "Controlando el cliente, voy a probar la clase Poliza"
    @InjectMocks
    private Poliza poliza;

    @Before
    public void setUp() {
        // Inicializa las anotaciones de Mockito en IntelliJ
        MockitoAnnotations.openMocks(this);

        // ARRANGE (Organizar mocks): Configuramos el comportamiento ANTES de inyectarlo
        // Necesitamos simular el nombre para que el System.out.println de Poliza no dé error (NullPointerException)
        when(clienteMock.isPremium()).thenReturn(true);
        when(clienteMock.getNombre()).thenReturn("Manuel Castro");

        // Seteamos explícitamente el mock a través del constructor, pasando el mock y el tipo de póliza
        poliza = new Poliza(clienteMock, "FULL");
    }

    @Test
    public void testPoliza_ConClientePremium_CalculaCobertura() {
        // ACT (Actuar): El cálculo ya se ejecutó en el constructor, así que solo obtenemos el valor
        double resultado = poliza.getCoberturaMaxima();
        double esperado = 22000.0; // 20000 por ser FULL + 2000 extra por ser cliente Premium

        // ASSERT (Confirmar): Comparamos los valores esperados aislando a la clase Cliente
        assertEquals(esperado, resultado, 0.0);
    }
}

// La clase PolizaTestMockito realiza pruebas unitarias de la clase Poliza utilizando Mockito para simular el comportamiento de la clase Cliente. Se asegura de que el cálculo de la cobertura máxima funcione correctamente cuando el cliente es Premium, verificando que el valor calculado sea el esperado. Esta prueba se realizó para probar la clase Poliza de manera aislada, sin depender de la implementación real de Cliente, permitiendo un control total sobre el comportamiento del cliente durante la prueba.
// Esta prueba se realizo porque se quería probar la clase Poliza de manera aislada, sin depender de la implementación real de Cliente, permitiendo un control total sobre el comportamiento del cliente durante la prueba.
