package com.lab.read.entity;

import com.lab.entity.Matriculacion;

import java.util.List;

public record StudentView(
    String id,
    String nombre,
    List<Matriculacion> matriculas
) {}
