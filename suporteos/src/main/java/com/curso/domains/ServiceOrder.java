package com.curso.domains;

import java.time.LocalDate;
import java.util.UUID;

import com.curso.domains.enums.OrderPriority;
import com.curso.domains.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviceorder")
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate starDate = LocalDate.now();
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private String titleOS;
    private String description;
    private OrderPriority orderPriority;
    private OrderStatus orderStatus;
    
    @ManyToOne //relacao muitos para um
    @JoinColumn(name = "idtechnician") //refere-se ao id de technician
    private Technician technician;

    @ManyToOne //relacao muitos para um
    @JoinColumn(name = "iduser") //refere-se ao id de users
    private Users user;

    public ServiceOrder() {
    }

    public ServiceOrder(UUID id, String titleOS, String description, OrderPriority orderPriority,
            OrderStatus orderStatus, Technician technician, Users user) {
        this.id = id;
        this.titleOS = titleOS;
        this.description = description;
        this.orderPriority = orderPriority;
        this.orderStatus = orderStatus;
        this.technician = technician;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTitleOS() {
        return titleOS;
    }

    public void setTitleOS(String titleOS) {
        this.titleOS = titleOS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderPriority getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(OrderPriority orderPriority) {
        this.orderPriority = orderPriority;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        ServiceOrder other = (ServiceOrder) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
