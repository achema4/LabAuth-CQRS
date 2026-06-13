package com.lab.entity;

public record Nota(Double valor) {

    public Nota {
        if (valor != null && (valor < 0 || valor > 10)) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 10");
        }
    }

    public static Nota noDisponible() {
        return new Nota(null);
    }

    public static Nota getNota(double valor) {
        return new Nota(valor);
    }

    public boolean disponible() {
        return valor != null;
    }
}
