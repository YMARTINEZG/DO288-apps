package me.sigom.demo.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/q")
public class HealthResource {

    @GET
    @Path("/health")
    public Response healthCheck() {
        return Response.ok("Develop version is running healthy..!").build();
    }
}
