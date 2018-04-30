import net.eviera.pruebas.rest.Services;
import net.eviera.pruebas.rest.UserData;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class TestPrueba {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class, "test-rest.war")
                .addPackages(true, Filters.exclude(".*Test.*"),
                        Services.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    @RunAsClient
    public void testToken(@ArquillianResteasyResource("rest/services") final WebTarget webTarget) {
        final Response response = webTarget
                .path("/token")
                .request(MediaType.APPLICATION_JSON)
                .get();

        String responseEntity = response.readEntity(String.class);
        assertEquals("tito", responseEntity);

    }

    @Test
    @RunAsClient
    public void authenticateUser(@ArquillianResteasyResource("rest/services") final WebTarget webTarget) {
        final Response response = webTarget
                .path("/users")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(new UserData(
                        "Tito",
                        42)));

        String responseEntity = response.readEntity(String.class);
        assertEquals("Titoxxx", responseEntity);
    }

}
