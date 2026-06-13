package com.lab.write.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "matriculaciones")
public class MatriculacionEntity {

    @Id
    private String id;

    private String asignatura;

    private int creditos;

    private double nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    protected MatriculacionEntity() {
    }

    public MatriculacionEntity(
            String id,
            String asignatura,
            int creditos,
            StudentEntity student,
            double nota) {

        this.id = id;
        this.asignatura = asignatura;
        this.creditos = creditos;
        this.student = student;
        this.nota=nota;
    }

    public String getId() {
        return id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public int getCreditos() {
        return creditos;
    }

    public double getNotat(){return nota;}

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity studentEntity) {
        this.student=studentEntity;
    }

    public void setNota(double nuevaNota) {
        this.nota=nuevaNota;
    }
}

