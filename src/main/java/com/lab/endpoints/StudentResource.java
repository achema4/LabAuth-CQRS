package com.lab.endpoints;

import com.lab.entity.dominio.Student;
import com.lab.entity.dto.StudentDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/student")
public class StudentResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Student REST";
    }

    @Path("/getStudent")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDTO getStudent() {
        StudentDTO student= new StudentDTO();
        student.setNombre("Chema");
        student.setId("15");
        return student;
    }

    @Path("/postStudent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postStudent(StudentDTO student) {
        return "received student %s".formatted(student.getNombre());
    }

}
