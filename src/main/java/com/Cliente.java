package com;

class Cliente {
    private String nombre;
    private String dni;
    private boolean premium;
    public Cliente(String nombre, String dni, boolean premium) {
        this.nombre = nombre;
        this.dni = dni;
        this.premium = premium;
        System.out.println("Cliente creado: " + nombre + " | DNI: " + dni + " | Premium: " + premium);
    }
    public String getNombre() { return nombre; }
    public boolean isPremium() { return premium; }
}
