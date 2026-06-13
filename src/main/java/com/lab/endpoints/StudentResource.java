package com.lab.endpoints;

import com.lab.entity.dominio.Student;
import com.lab.entity.dto.StudentDTO;
import com.lab.service.CQRSService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/student")
public class StudentResource {

    @Inject
    CQRSService service;

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Student REST";
    }

    @Path("/getStudent/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDTO getStudent(@PathParam("id") String id) {
       return service.getStudent(id);
    }
    @Path("/getAllStudents")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentDTO> getAllStudent() {
        return service.getAllStudents();
    }

    @Path("/postStudent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postStudent(StudentDTO student) {
        service.postStudent(student);
        return "received student %s".formatted(student.getNombre());
    }

}
