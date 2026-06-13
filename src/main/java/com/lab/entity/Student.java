package com.lab.entity;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private final String id;
    private final String nombre;
    private final List<Matriculacion> matriculaciones = new ArrayList<>();

    public Student(String id, String nombre) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Id requerido");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre requerido");

        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Matriculacion> getMatriculaciones() {
        return Collections.unmodifiableList(matriculaciones);
    }

    public void matricular(Matriculacion matriculacion) {
        matriculaciones.add(matriculacion);
    }

    public int totalCreditos() {
        return matriculaciones.stream()
                .mapToInt(Matriculacion::getCreditos)
                .sum();
    }
}



