package com.lab.endpoints;

import com.lab.entity.Matriculacion;
import com.lab.entity.Nota;
import com.lab.entity.Student;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/matriculacion")
public class MatriculaResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Matriculacion REST";
    }

    @Path("/getMatricula")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Matriculacion getMatricula() {
        Nota nota = new Nota(6.0);
        return new Matriculacion(-1, "fundamentos", 3, nota);
    }

    @Path("/postMatricula")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postMatricula(Matriculacion matricula) {
        return "received matriculacion %s".formatted(matricula.getNombre());
    }
}