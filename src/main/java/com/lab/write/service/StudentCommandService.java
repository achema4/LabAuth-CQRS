package com.lab.write.service;

import com.lab.entity.dominio.Student;
import com.lab.mappers.StudentMapper;
import com.lab.write.entity.MatriculacionEntity;
import com.lab.write.entity.StudentEntity;
import com.lab.write.repository.StudentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class StudentCommandService {

    @Inject
    StudentRepository repository;

    @Inject
    StudentMapper mapper;

    @Transactional
    public void create(Student student) {

        StudentEntity entity = mapper.toEntity(student);

        repository.persist(entity);
    }

    @Transactional
    public void update(Student student) {

        StudentEntity entity = mapper.toEntity(student);

        repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void delete(String id) {
        repository.deleteById(Long.valueOf(id));
    }

    @Transactional
    public void cambiarNota(String studentId, String matriculaId, double nuevaNota) {

        StudentEntity student =
                repository.findWithMatriculas(studentId);

        MatriculacionEntity matricula =
                student.getMatriculaciones()
                        .stream()
                        .filter(m -> m.getId().equals(matriculaId))
                        .findFirst().get();

        matricula.setNota(nuevaNota);

    }
}