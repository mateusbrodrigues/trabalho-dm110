package br.inatel.dm110.ejb.mdb;

import br.inatel.dm110.ejb.beans.AuditServiceBean;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/AuditQueue")
})
public class AuditMDB implements MessageListener {

    @Inject
    private AuditServiceBean auditService;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String[] content = ((TextMessage) message).getText().split(",");
                String registerCode = content[0];
                String operation = content[1];
                auditService.registerAudit(registerCode, operation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 