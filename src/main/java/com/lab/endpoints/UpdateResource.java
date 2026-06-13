package com.lab.endpoints;

import com.lab.entity.Student;
import com.lab.service.UpdateService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/update")
public class UpdateResource {

    @Inject
    UpdateService updateService;

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Update REST";
    }


    @Path("/synchronize")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String synchronize() {
        //service.rebuildReadModel();
        updateService.update();
        return "Read model synchronized";
    }
}
