package com.lab.entity.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Matriculacion {

    private String id;
    private final String nombre;
    private final int creditos;
    private Nota nota;

    public Matriculacion(String id, String nombre, int creditos, Nota nota) {
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


    public String getId() {
        return this.id;
    }
}
