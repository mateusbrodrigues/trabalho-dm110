package br.inatel.dm110.ejb.entities;

	import jakarta.persistence.*;
	import java.util.Date;

	@Entity
	@Table(name = "auditing")
	public class Auditing {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	    private Long identifier;

	    private String registerCode; 
	    private String operation;  
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date timestamp;

	    
	    public Long getIdentifier() {
	        return identifier;
	    }

	    public void setIdentifier(Long identifier) {
	        this.identifier = identifier;
	    }

	    public String getRegisterCode() {
	        return registerCode;
	    }

	    public void setRegisterCode(String registerCode) {
	        this.registerCode = registerCode;
	    }

	    public String getOperation() {
	        return operation;
	    }

	    public void setOperation(String operation) {
	        this.operation = operation;
	    }

	    public Date getTimestamp() {
	        return timestamp;
	    }

	    public void setTimestamp(Date timestamp) {
	        this.timestamp = timestamp;
	    }
	}

