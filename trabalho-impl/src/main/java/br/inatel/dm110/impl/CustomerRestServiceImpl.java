package br.inatel.dm110.impl;

import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import br.inatel.dm110.ejb.beans.CustomerServiceBean;
import br.inatel.dm110.ejb.entities.Customer;
import br.inatel.dm110.api.CustomerRestService; // Importa a interface que você implementa

@Path("/customers")
public class CustomerRestServiceImpl implements CustomerRestService {

    @EJB
    private CustomerServiceBean customerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Override 
    public Response createCustomer(Customer customer) {
        customerService.addCustomer(customer); 
        return Response.ok("Customer added successfully").build();
    }

    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("cpf") String cpf) {
        Customer customer = customerService.getCustomer(cpf);
        if (customer != null) {
            return Response.ok(customer).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return Response.ok("Customer updated successfully").build();
    }
}
