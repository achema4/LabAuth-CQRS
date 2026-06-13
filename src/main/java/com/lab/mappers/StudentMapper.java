package com.lab.mappers;

import com.lab.entity.dominio.Matriculacion;
import com.lab.entity.dominio.Student;
import com.lab.read.entity.StudentView;
import com.lab.write.entity.MatriculacionEntity;
import com.lab.write.entity.StudentEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StudentMapper {

    public Student toDomain(StudentEntity entity) {
        Student student =
                new Student(entity.getId(), entity.getNombre());

        entity.getMatriculaciones()
                .forEach(m -> student.matricular(
                        new Matriculacion(
                                m.getAsignatura(),
                                m.getCreditos()
                        )));

        return student;
    }

    public StudentView toView(Student student) {
        return new StudentView(
                student.getId(),
                student.getNombre(),
                student.getMatriculaciones()
        );
    }

    public StudentEntity toEntity(Student student) {

        StudentEntity entity =
                new StudentEntity(
                        student.getId(),
                        student.getNombre()
                );

        student.getMatriculaciones()
                .forEach(m -> {
                    MatriculacionEntity matricula =
                            new MatriculacionEntity(
                                    String.valueOf(m.getId()),
                                    m.getNombre(),
                                    m.getCreditos(),
                                    entity,
                                    m.getNota().valor()
                            );

                    entity.addMatriculacion(matricula);
                });

        return entity;
    }
}