package com.lab.write.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "matriculaciones")
@Getter
@Setter
public class MatriculacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String asignatura;

    private Integer creditos;

    private Double nota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    protected MatriculacionEntity() {
    }

    public MatriculacionEntity(
            String id,
            String asignatura,
            Integer creditos,
            StudentEntity student,
            Double nota) {

        this.id = id;
        this.asignatura = asignatura;
        this.creditos = creditos;
        this.student = student;
        this.nota=nota;
    }
}

