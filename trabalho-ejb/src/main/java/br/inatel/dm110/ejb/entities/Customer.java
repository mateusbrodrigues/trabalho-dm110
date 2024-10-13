package br.inatel.dm110.ejb.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMERS") 
public class Customer implements Serializable {

    @Id
    @Column(name = "CPF", length = 11) 
    private String cpf; 

    @Column(name = "NAME", length = 50, nullable = false) 
    private String name;

    @JsonbDateFormat(value = "yyyy-MM-dd") 
    @Column(name = "BIRTH_DATE") 
    private LocalDate birthDate;

    @Column(name = "GENDER", length = 1) 
    private String gender;

    @Column(name = "EMAIL", length = 100, nullable = false) 
    private String email;

    @Column(name = "CEP", length = 10) 
    private String cep; 

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
