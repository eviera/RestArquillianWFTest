package net.eviera.pruebas.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/services")
public class Services {

    @GET
    @Path("token")
    public String viewToken() {
        return "tito";
    }


    @POST
    @Path("users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserData userData) {

        UserResponse userResponse = new UserResponse();
        userResponse.setValue(userData.getAge() + 1);
        userResponse.setError(false);

        return Response.ok(userResponse).build();
    }
}
