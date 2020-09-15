package dev.autowired.app.rest.boundary;

import dev.autowired.app.service.boundary.TestService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestRest {

    @Inject
    private TestService testService;

    @GET
    public Response getTest() {
        return Response
                .ok(testService.save())
                .build();
    }
}
