package com.lab.mappers;

import com.lab.entity.dominio.Matriculacion;
import com.lab.entity.dominio.Student;
import com.lab.entity.dto.MatriculacionDTO;
import com.lab.entity.dto.NotaDTO;
import com.lab.entity.dto.StudentDTO;
import com.lab.read.entity.StudentView;
import com.lab.write.entity.MatriculacionEntity;
import com.lab.write.entity.StudentEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StudentMapper {

    public Student entityToDomain(StudentEntity entity) {
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
                                    m.getNota() != null ? m.getNota().getValor() : null
                            );

                    entity.addMatriculacion(matricula);
                });

        return entity;
    }


    public Student dTOtoDomain(StudentDTO dto) {

        Student student = new Student(dto.getId(), dto.getNombre());

        if (dto.getMatriculaciones() != null) {
            dto.getMatriculaciones()
                    .forEach(m -> student.matricular(
                            new Matriculacion(
                                    m.getNombre(),
                                    m.getCreditos()
                            )
                    ));
        }

        return student;
    }

    public Student viewToDomain(StudentView view) {

        Student student = new Student(
                view.id(),
                view.nombre()
        );

        if (view.matriculas() != null) {
            view.matriculas()
                    .forEach(m -> student.matricular(
                            new Matriculacion(
                                    m.getNombre(),
                                    m.getCreditos()
                            )
                    ));
        }

        return student;
    }


    public StudentDTO toDTO(Student student) {

        List<MatriculacionDTO> matriculaciones =
                student.getMatriculaciones()
                        .stream()
                        .map(m -> new MatriculacionDTO(
                                m.getId(),
                                m.getNombre(),
                                m.getCreditos(),
                                m.getNota() != null
                                        ? new NotaDTO(m.getNota().getValor().intValue())
                                        : null
                        ))
                        .collect(Collectors.toList());

        return new StudentDTO(
                student.getId(),
                student.getNombre(),
                matriculaciones
        );
    }

}