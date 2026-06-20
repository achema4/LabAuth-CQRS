package com.lab.endpoints;

import com.lab.entity.dominio.Student;
import com.lab.entity.dto.MatriculacionDTO;
import com.lab.entity.dto.StudentDTO;
import com.lab.service.CQRSService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/student")
public class StudentResource {

    @Inject
    CQRSService service;


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StudentDTO get(
            @PathParam("id") String id) {

        return service.getStudent(id);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentDTO> getAll() {
        return service.getAllStudents();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createStudent(StudentDTO dto) {

        service.createStudent(dto);

        return Response.status(Response.Status.CREATED)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(
            @PathParam("id") String id,
            StudentDTO dto) {
        service.updateStudent(id,dto);

        return Response.noContent().build();
    }


    @POST
    @Path("/{id}/matriculaciones")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMatricula(
            @PathParam("id") String id,
            MatriculacionDTO dto) {

        service.addMatriculacion(id, dto);

        return Response.status(201).build();
    }


    @DELETE
    @Path("/{id}")
    public Response delete(
            @PathParam("id") String id) {

        service.deleteStudent(id);

        return Response.noContent().build();
    }


}
