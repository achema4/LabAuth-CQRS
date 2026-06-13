package com.lab.service;


import com.lab.mappers.StudentMapper;
import com.lab.read.entity.StudentView;
import com.lab.read.repository.StudentReadRepository;
import com.lab.write.repository.StudentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

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
        List<StudentView> views = studentRepository.findAllWithMatriculas()
                .stream()
                .map(studentMapper::entityToDomain)
                .map(studentMapper::toView)
                .toList();

        views.forEach(studentReadRepository::save);
        studentReadRepository.dump();
    }

}
