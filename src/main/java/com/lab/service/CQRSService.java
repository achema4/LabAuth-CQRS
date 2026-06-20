package com.lab.service;

import com.lab.entity.dominio.Student;
import com.lab.entity.dto.MatriculacionDTO;
import com.lab.entity.dto.StudentDTO;
import com.lab.mappers.MatriculacionMapper;
import com.lab.mappers.StudentMapper;
import com.lab.read.entity.StudentView;
import com.lab.read.repository.MapDBProducer;
import com.lab.read.service.StudentQueryService;
import com.lab.write.service.MatriculacionCommandService;
import com.lab.write.service.StudentCommandService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CQRSService {

    @Inject
    StudentCommandService studentCommandService;

    @Inject
    MatriculacionCommandService maticulacionCommandService;

    @Inject
    StudentQueryService studentQueryService;

    @Inject
    MapDBProducer mapDBProducer;

    @Inject
    StudentMapper studentMapper;
    @Inject
    MatriculacionMapper matriculacionMapper;



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

    public void addMatriculacion(String id, MatriculacionDTO dto) {
        maticulacionCommandService.matricular(id,matriculacionMapper.dtoToDomain(dto));
    }

    public void deleteStudent(String id) {
        studentCommandService.delete(id);
    }

    public void createStudent(StudentDTO dto) {
        studentCommandService.create(studentMapper.dTOtoDomain(dto));
    }

    public void updateStudent(String id, StudentDTO dto) {
        Student student = studentMapper.entityToDomain(studentCommandService.getById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Student no encontrado"
                        )
                ));
        studentCommandService.update(student);
    }
}
