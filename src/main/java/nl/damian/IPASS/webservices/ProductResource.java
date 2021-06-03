package nl.damian.IPASS.webservices;


import nl.damian.IPASS.Classes.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("product")
public class ProductResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@FormParam("naam") String naam, @FormParam("prijs") double prijs){
        Product product = new Product(naam, prijs);
        return Response.ok(product).build();
    }
}
