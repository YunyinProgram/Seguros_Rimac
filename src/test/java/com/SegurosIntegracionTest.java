package com;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SegurosIntegracionTest {

    private Cliente cliente;
    private Poliza poliza;
    private Siniestro siniestro;
    private PagoIndemnizacion pago;

    @Before
    public void setUp() {
        // ARRANGE (Organizar): ¡Cero Mockito! Instanciamos las clases reales.
        cliente = new Cliente("Joao Castro", "12345678", true);
        poliza = new Poliza(cliente, "FULL");
        siniestro = new Siniestro(poliza, 15000.0);
        pago = new PagoIndemnizacion(siniestro);
    }

    @Test
    public void testIntegracion_FlujoAprobacionCompleto() {
        // ACT (Actuar): Ejecutamos las acciones del negocio en cadena
        siniestro.evaluar();
        pago.generarPago();

        // ASSERT (Confirmar): Verificamos que los estados pasaron de una clase a otra con éxito
        assertEquals("APROBADO", siniestro.getEstado());
        assertEquals("GENERADO", pago.getEstadoPago());
        assertEquals(15000.0, pago.getMontoPagado(), 0.0);
    }
}

// La clase SegurosIntegracionTest realiza una prueba de integración completa del flujo de negocio, desde la creación de un cliente y su póliza, hasta la evaluación de un siniestro y la generación del pago de indemnización. Se asegura de que los estados y montos se propaguen correctamente entre las clases involucradas.
// Esta prueba se realizo porque se quería probar la integración de todas las clases del sistema de seguros sin usar mocks, asegurando que el flujo completo funcione como se espera en un escenario realista.

