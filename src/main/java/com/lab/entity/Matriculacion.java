package com.lab.entity;

public class Matriculacion {

    private int id;
    private final String nombre;
    private final int creditos;
    private Nota nota;

    public Matriculacion(int id, String nombre, int creditos, Nota nota) {
        this.id = id;
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }
        if (creditos <= 0) {
            throw new IllegalArgumentException("Los créditos deben ser positivos");
        }

        this.nombre = nombre;
        this.creditos = creditos;
        this.nota = nota;
    }

    public Matriculacion(String nombre, int creditos) {
        validar(nombre, creditos);

        this.nombre = nombre;
        this.creditos = creditos;
        this.nota = null;
    }

    private void validar(String nombre, int creditos) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser vacío");
        }

        if (creditos <= 0) {
            throw new IllegalArgumentException("Los créditos deben ser positivos");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public Nota getNota() {
        return nota;
    }

    public void  setNota(Nota nota){

        this.nota=nota;
    }

    public int getId() {
        return this.id;
    }
}
