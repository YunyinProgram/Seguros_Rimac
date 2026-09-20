package com;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PagoIndemnizacionTestMockito {

    // @Mock: "Voy a controlar el Siniestro para que me diga que está aprobado por 15000"
    @Mock
    private Siniestro siniestroMock;

    // @InjectMocks: "Controlando el siniestro, voy a probar PagoIndemnizacion"
    @InjectMocks
    private PagoIndemnizacion pago;

    @Before
    public void setUp() {
        // Inicializa las anotaciones de Mockito en IntelliJ
        MockitoAnnotations.openMocks(this);

        // Seteamos explícitamente el mock inyectándolo en el constructor (como hace el profe con set)
        pago = new PagoIndemnizacion(siniestroMock);
    }

    @Test
    public void testGenerarPago_ConSiniestroAprobado_GeneraCorrectamente() {
        // ARRANGE (Organizar): Simulamos el comportamiento del Siniestro mockeado
        // No importa cómo funciona Siniestro por dentro, aquí forzamos su respuesta
        when(siniestroMock.getEstado()).thenReturn("APROBADO");
        when(siniestroMock.getMontoAprobado()).thenReturn(15000.0);

        // ACT (Actuar): Ejecutamos la función de la clase PagoIndemnizacion
        pago.generarPago();

        // ASSERT (Confirmar): Comparamos los valores esperados aislando a Siniestro
        assertEquals("GENERADO", pago.getEstadoPago());
        assertEquals(15000.0, pago.getMontoPagado(), 0.0);
    }
}

// La clase PagoIndemnizacionTestMockito realiza pruebas unitarias de la clase PagoIndemnizacion utilizando Mockito para simular el comportamiento de la clase Siniestro. Se asegura de que el método generarPago funcione correctamente cuando el siniestro está aprobado, verificando que el estado del pago y el monto pagado sean los esperados.
// Esta prueba se realizo porque se quería probar la clase PagoIndemnizacion de manera aislada, sin depender de la implementación real de Siniestro, permitiendo un control total sobre el comportamiento del siniestro durante la prueba.
