package com.lab.service;

import com.lab.entity.dominio.Student;
import com.lab.entity.dto.StudentDTO;
import com.lab.mappers.StudentMapper;
import com.lab.read.entity.StudentView;
import com.lab.read.service.StudentQueryService;
import com.lab.write.service.StudentCommandService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CQRSService {

    @Inject
    StudentCommandService studentCommandService;
    @Inject
    StudentQueryService studentQueryService;

    @Inject
    StudentMapper studentMapper;

    public void postStudent(StudentDTO studentDTO) {

        Student student= studentMapper.dTOtoDomain(studentDTO);
        if(student.getId() == null ){
            studentCommandService.create(student);
        }
        else{
            studentCommandService.update(student);
        }


    }

    public StudentDTO getStudent(String id){
        StudentView studentView = studentQueryService.getById(id);
        Student student= studentMapper.viewToDomain(studentView);
        StudentDTO studentDTO= studentMapper.toDTO(student);
        return studentDTO;
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentView> views = studentQueryService.getAll();

        return views.stream()
                .map(studentMapper::viewToDomain)
                .map(studentMapper::toDTO)
                .toList();
    }
}
