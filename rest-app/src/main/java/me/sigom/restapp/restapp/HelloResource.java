package me.sigom.restapp.restapp;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.sigom.restapp.restapp.model.Account;
import me.sigom.restapp.restapp.service.Counter;

import java.lang.invoke.MethodHandles;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


@Path("/")
public class HelloResource {

    private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @Inject
    Counter counter;

    @GET
    @Path("/liveness")
    @Produces(MediaType.APPLICATION_JSON)
    public Response health() {
        LOGGER.log(Level.INFO, "Processing HEALTHY endpoint");
        return Response.ok().build();
    }

    @GET
    @Path("/create/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account create(@PathParam("username") String username) {
        LOGGER.log(Level.INFO, "Processing user creation");
        return new Account(counter.getCounter(),username, UUID.randomUUID().toString());
    }
}