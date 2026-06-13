package com.lab.write.service;

import com.lab.entity.Matriculacion;
import com.lab.entity.Student;
import com.lab.mappers.StudentMapper;
import com.lab.write.entity.MatriculacionEntity;
import com.lab.write.entity.StudentEntity;
import com.lab.write.repository.StudentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MatriculacionCommandService {

    @Inject
    StudentRepository studentRepository;

    @Inject
    StudentMapper mapper;

    @Transactional
    public void matricular(String studentId, Matriculacion matriculacion) {

        StudentEntity student =
                studentRepository.findWithMatriculas(studentId);

        MatriculacionEntity entity =
                new MatriculacionEntity(
                        matriculacion.getId() != -1 ? String.valueOf(matriculacion.getId()) : null,
                        matriculacion.getNombre(),
                        matriculacion.getCreditos(),
                        student,
                        matriculacion.getNota().valor()
                );

        student.addMatriculacion(entity);

        studentRepository.persist(student);
    }
}