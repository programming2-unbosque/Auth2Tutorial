package edu.unbosque.Auth2Tutorial.resources;

import edu.unbosque.Auth2Tutorial.resources.filters.Logged;
import edu.unbosque.Auth2Tutorial.resources.pojos.User;
import edu.unbosque.Auth2Tutorial.services.UserAppService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/owners")
public class OwnerResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(User user) {

        user.setRole("owner");

        Optional<User> persistedUser = new UserAppService().createUser(user);

        if (persistedUser.isPresent()) {
            return Response.status(Response.Status.CREATED)
                    .entity(persistedUser.get())
                    .build();
        } else {
            return Response.serverError()
                    .entity("Owner user could not be created")
                    .build();
        }


    }

    @Logged
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello(@HeaderParam("role") String role) {

        // If role doesn't match
        if (!"owner".equals(role))
            return Response.status(Response.Status.FORBIDDEN)
                    .entity("Role " + role + " cannot access to this method")
                    .build();

        return Response.ok()
                .entity("Hello, World, " + role + "!")
                .build();

    }

}