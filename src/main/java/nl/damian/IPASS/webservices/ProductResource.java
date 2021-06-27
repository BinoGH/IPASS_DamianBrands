package nl.damian.IPASS.webservices;
import nl.damian.IPASS.domein.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("product")
public class ProductResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response nieuwProduct(@FormParam("productName") String naam, @FormParam("productPrijs") double prijs){
        Product product = new Product(naam, prijs);
        return Response.ok(product).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAssortiment(){
        return Response.ok(Product.getAssortiment()).build();
    }
}
