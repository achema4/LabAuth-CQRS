package com.lab.endpoints;

import com.lab.entity.Matriculacion;
import com.lab.entity.Nota;
import com.lab.entity.Student;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
    @Produces(MediaType.TEXT_PLAIN)
    public Matriculacion getMatricula() {
        Nota nota = new Nota(6.0);
        return new Matriculacion(-1, "fundamentos", 3, nota);
    }

    @Path("/postMatricula")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postMatricula(Matriculacion matricula) {
        return "received matriculacion %s".formatted(matricula.getNombre());
    }
}