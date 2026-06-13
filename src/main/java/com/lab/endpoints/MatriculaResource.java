package com.lab.endpoints;

import com.lab.entity.dominio.Matriculacion;
import com.lab.entity.dominio.Nota;
import com.lab.entity.dto.MatriculacionDTO;
import com.lab.entity.dto.NotaDTO;
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
    public MatriculacionDTO getMatricula() {
        NotaDTO nota = new NotaDTO();
        nota.setValor(6);
        MatriculacionDTO matriculacion = new MatriculacionDTO();
        matriculacion.setNombre("Fundamentos");
        matriculacion.setNota(nota);
        return matriculacion;
    }

    @Path("/postMatricula")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postMatricula(MatriculacionDTO matricula) {
        return "received matriculacion %s".formatted(matricula.getNombre());
    }
}