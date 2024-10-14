package br.inatel.dm110.ejb.beans;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import br.inatel.dm110.ejb.entities.Customer;

@Stateless
public class CustomerServiceBean {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    @Inject
    private AuditServiceBean auditService;  

    public void addCustomer(Customer customer) {
        em.persist(customer);
        auditService.registerAudit(customer.getCpf(), "create");  
    }

    public Customer getCustomer(String cpf) {
        return em.find(Customer.class, cpf);
    }

    public List<Customer> getAllCustomers() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    public void updateCustomer(Customer customer) {
        em.merge(customer);
        auditService.registerAudit(customer.getCpf(), "update"); 
    }

}