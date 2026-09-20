package com;

class PagoIndemnizacion {
    private Siniestro siniestro;
    private double montoPagado;
    private String estadoPago;
    public PagoIndemnizacion(Siniestro siniestro) {
        this.siniestro = siniestro;
        this.estadoPago = "NO_GENERADO";
    }
    public void generarPago() {
        if ("APROBADO".equalsIgnoreCase(siniestro.getEstado())) {
            montoPagado = siniestro.getMontoAprobado();
            estadoPago = "GENERADO";
            System.out.println("Pago generado por S/" + montoPagado);
        } else {
            System.out.println("No se genera pago. Siniestro no aprobado.");
        }
    }
    public String getEstadoPago() { return estadoPago; }
    public double getMontoPagado() { return montoPagado; }
}
