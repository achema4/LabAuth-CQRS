package com.lab.write.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nombre;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<MatriculacionEntity> matriculaciones = new ArrayList<>();

    protected StudentEntity() {
    }

    public StudentEntity(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<MatriculacionEntity> getMatriculaciones() {
        return matriculaciones;
    }

    public void addMatriculacion(MatriculacionEntity matricula) {
        matricula.setStudent(this);
        this.matriculaciones.add(matricula);
    }

}
