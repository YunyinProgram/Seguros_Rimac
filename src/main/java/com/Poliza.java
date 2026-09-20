package com;

class Poliza {
    private Cliente cliente;
    private String tipo;
    private double coberturaMaxima;
    private boolean activa;
    public Poliza(Cliente cliente, String tipo) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.activa = true;
        if ("FULL".equalsIgnoreCase(tipo)) {
            this.coberturaMaxima = 20000;
        } else {
            this.coberturaMaxima = 10000;
        }
        if (cliente.isPremium()) {
            this.coberturaMaxima += 2000;
        }
        System.out.println("Póliza creada para " + cliente.getNombre() +
                " | Tipo: " + tipo +
                " | Cobertura: " + coberturaMaxima);
    }
    public boolean isActiva() { return activa; }
    public double getCoberturaMaxima() { return coberturaMaxima; }
    public void desactivar() {
        this.activa = false;
        System.out.println("Póliza desactivada");
    }
}
