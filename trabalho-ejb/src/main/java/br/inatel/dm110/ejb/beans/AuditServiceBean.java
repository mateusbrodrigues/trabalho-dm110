package br.inatel.dm110.ejb.beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Date;

import br.inatel.dm110.ejb.entities.Auditing;

@Stateless
public class AuditServiceBean {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public void registerAudit(String registerCode, String operation) {
        Auditing audit = new Auditing();
        audit.setRegisterCode(registerCode);
        audit.setOperation(operation);
        audit.setTimestamp(new Date());
        em.persist(audit);
    }
}