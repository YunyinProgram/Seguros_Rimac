package com;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SiniestroTestMockito {

    // @Mock: "Voy a controlar la Póliza para que simule estar inactiva"
    @Mock
    private Poliza polizaMock;

    // @InjectMocks: "Controlando la póliza, voy a probar la clase Siniestro"
    @InjectMocks
    private Siniestro siniestro;

    @Before
    public void setUp() {
        // Inicializa las anotaciones de Mockito en IntelliJ
        MockitoAnnotations.openMocks(this);

        // Seteamos explícitamente el mock a través del constructor, agregando un reclamo base de 5000
        siniestro = new Siniestro(polizaMock, 5000.0);
    }

    @Test
    public void testSiniestro_ConPolizaInactiva_RechazaSiniestro() {
        // ARRANGE (Organizar): Configuramos el comportamiento de la póliza mockeada
        // No importa si la póliza real tiene fallos, aquí forzamos a que responda 'false' (inactiva)
        when(polizaMock.isActiva()).thenReturn(false);

        // ACT (Actuar): Ejecutamos la función a probar
        siniestro.evaluar();

        // ASSERT (Confirmar): Comparamos los valores esperados aislando a la clase Poliza
        assertEquals("RECHAZADO", siniestro.getEstado());
        assertEquals(0.0, siniestro.getMontoAprobado(), 0.0);
    }
}

// La clase SiniestroTestMockito realiza pruebas unitarias de la clase Siniestro utilizando Mockito para simular el comportamiento de la clase Poliza. Se asegura de que el método evaluar funcione correctamente cuando la póliza está inactiva, verificando que el estado del siniestro sea "RECHAZADO" y que el monto aprobado sea 0.0. Esta prueba se realizó para probar la clase Siniestro de manera aislada, sin depender de la implementación real de Poliza, permitiendo un control total sobre el comportamiento de la póliza durante la prueba.
// Esta prueba se realizo porque se quería probar la clase Siniestro de manera aislada, sin depender de la implementación real de Poliza, permitiendo un control total sobre el comportamiento de la póliza durante la prueba.

