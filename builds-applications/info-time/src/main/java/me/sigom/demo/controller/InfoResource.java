package me.sigom.demo.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.sigom.demo.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api")
public class InfoResource {
    private static final Logger LOG = LoggerFactory.getLogger(InfoResource.class);
    @Inject
    InfoService infoService;

    @GET
    @Path("/time")
    @Produces(MediaType.APPLICATION_JSON)
    public Response info(@DefaultValue("LA") @QueryParam("tag") String tag) {
        return Response.ok(infoService.getInfoTime(tag)).build();
    }
    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response manifest() {
        return Response.ok(infoService.getInfo()).build();
    }
}
