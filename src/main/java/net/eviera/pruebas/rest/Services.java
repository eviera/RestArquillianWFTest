package net.eviera.pruebas.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/services")
public class Services {
    @GET
    @Path("token")
    public String viewToken() {
        return "tito";
    }


    @POST
    @Path("users")
    public String createUser(UserData userData) {
        return userData.getName() + "xxx";
    }
}
