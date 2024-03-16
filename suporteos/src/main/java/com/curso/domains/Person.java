package com.curso.domains;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Indexed;

import com.curso.domains.enums.PersonType;

@Entity  
@Table(name = "person")
public abstract class Person {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    protected String firstName;
    protected String lastName;

    @Column(unique = true)
    protected String cpf;

    @Column(unique = true)
    protected String email;
    protected String password;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    protected Set<Integer> personType = new HashSet<>();

public UUID getId() {
        return id;
    }

protected UUID id;
protected String firstName;
protected String lastName;
protected String cpf;
protected String email;
protected String password;
protected LocalDate createdAt = LocalDate.now();
protected Set<Integer> personType = new HashSet<>();

public Person() {    
    super();
    addPersonType(PersonType.USERS);
}

public void addPersonType(PersonType users) {
}

public Person(UUID id, String firstName, String lastName, String cpf, String email, String password){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.cpf = cpf;
    this.email = email;
    this.password = password;
    addPersonType(PersonType.USERS);

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

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getCpf() {
    return cpf;
}

public void setCpf(String cpf) {
    this.cpf = cpf;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public LocalDate getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
}

public Set<PersonType> getPersonType() {
    return personType.stream().map(x -> PersonType.toEnum(x)).collect(Collectors.toSet());
}

public void setPersonType(PersonType personType) {
    this.personType.add(personType.getId());
}

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Person other = (Person) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    if (cpf == null) {
        if (other.cpf != null)
            return false;
    } else if (!cpf.equals(other.cpf))
        return false;
    return true;
}


}
