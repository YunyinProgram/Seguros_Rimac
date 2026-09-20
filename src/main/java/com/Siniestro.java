package com;

class Siniestro {
    private Poliza poliza;
    private double montoReclamado;
    private String estado;
    private double montoAprobado;
    public Siniestro(Poliza poliza, double montoReclamado) {
        this.poliza = poliza;
        this.montoReclamado = montoReclamado;
        this.estado = "PENDIENTE";
        System.out.println("Siniestro registrado. Monto reclamado: S/" + montoReclamado);
    }
    public void evaluar() {
        if (!poliza.isActiva()) {
            estado = "RECHAZADO";
            montoAprobado = 0;
            System.out.println("Siniestro rechazado por póliza inactiva.");
        } else if (montoReclamado <= poliza.getCoberturaMaxima()) {
            estado = "APROBADO";
            montoAprobado = montoReclamado;
            System.out.println("Siniestro aprobado por monto completo: S/" + montoAprobado);


        } else {
            estado = "APROBADO";
            montoAprobado = poliza.getCoberturaMaxima();
            System.out.println("Siniestro aprobado parcialmente: S/" + montoAprobado);
        }
    }
    public String getEstado() { return estado; }
    public double getMontoAprobado() { return montoAprobado; }


}
