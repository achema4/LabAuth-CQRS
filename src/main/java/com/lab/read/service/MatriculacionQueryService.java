package com.lab.read.service;

import com.lab.read.entity.StudentView;
import com.lab.read.repository.StudentReadRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class MatriculacionQueryService {

    @Inject
    StudentReadRepository readRepository;

    public List<?> getMatriculasByStudent(String studentId) {

        StudentView view = readRepository.findById(studentId);

        return view.matriculas();
    }
}