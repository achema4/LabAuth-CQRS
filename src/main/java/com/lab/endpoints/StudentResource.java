package com.lab.endpoints;

import com.lab.entity.Student;
import jakarta.annotation.security.RolesAllowed;
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent() {
        return new Student("15","Chema");
    }

    @Path("/postStudent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postStudent(Student student) {
        return "received student %s".formatted(student.getNombre());
    }

}
