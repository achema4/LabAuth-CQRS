package com.lab.service;


import com.lab.mappers.StudentMapper;
import com.lab.read.repository.StudentReadRepository;
import com.lab.write.repository.StudentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UpdateService {

    @Inject
    StudentRepository studentRepository;

    @Inject
    StudentReadRepository studentReadRepository;

    @Inject
    StudentMapper studentMapper;


    @Transactional
    public void update() {
        studentRepository.findAllWithMatriculas()
                .stream()
                .map(studentMapper::toDomain)
                .map(studentMapper::toView)
                .forEach(studentReadRepository::save);
    }

}
