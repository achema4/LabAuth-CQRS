package com.lab.read.service;


import com.lab.read.repository.StudentReadRepository;
import com.lab.read.entity.StudentView;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class StudentQueryService {

    @Inject
    StudentReadRepository readRepository;

    public StudentView getById(String id) {
        return readRepository.findById(id);
    }

    public List<StudentView> getAll() {
        return readRepository.findAll();
    }
}