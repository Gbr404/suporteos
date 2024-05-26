package com.curso.domains.dtos;


import java.time.LocalDate; import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import com.curso.domains.Users;
import com.curso.domains.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonFormat;



public class UsersDTO {

    protected UUID id;
    protected String firstName; protected String lastName;
    protected String cpf;
    protected String email;
    protected String password;


@JsonFormat(pattern = "dd/MM/yyyy")
protected LocalDate createdAt = LocalDate.now();

protected Set<Integer> personType = new HashSet<>();

public UsersDTO() {
}


public UsersDTO (Users obj) {
    this.id = obj.getId();
    this.firstName = obj.getFirstName();
    this.lastName =  obj.getLastName();
    this.cpf = obj.getCpf();
    this.email = obj.getEmail();
    this.password = obj.getPassword();
    this.createdAt = obj.getCreatedAt();
    this.personType = obj.getPersonType().stream().map(x -> x.getId()).collect(Collectors.toSet());
}
    public UUID getId() {
       return id;
    }

    public void setId(UUID id) {
    this.id = id;
    }

    public String getFirstName() {
       return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
       return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf (String cpf){
        this.cpf = cpf;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail (String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }


    public LocalDate getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt (LocalDate createdAt){
        this.createdAt = createdAt;
    }

    public Set<PersonType> getPersonType(){
        return personType.stream().map(x -> PersonType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPersonType (PersonType personType){
        this.personType.add(personType.getId());
    }

}

