package br.inatel.dm110.api;

import br.inatel.dm110.ejb.entities.Customer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/customers")
public interface CustomerRestService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response createCustomer(Customer customer);

    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getCustomer(@PathParam("cpf") String cpf);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Customer> getAllCustomers();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response updateCustomer(Customer customer);
}
