package nl.damian.IPASS.webservices;
import nl.damian.IPASS.Classes.Gebruiker;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("gebruiker")
public class GebruikerResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@FormParam("email") String em, @FormParam("wachtwoord") String ww){

    }
}
