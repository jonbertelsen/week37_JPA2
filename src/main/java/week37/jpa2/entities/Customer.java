/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week37.jpa2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jobe
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="customer_id")
    private Long customer_id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName; 

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
        name = "LINK_CUSTOMER_ADDRESS", 
        joinColumns = @JoinColumn(name = "customer_id"), 
        inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address> adresses = new HashSet();


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Customer() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Long getId() {
        return customer_id;
    }

    public void setId(Long id) {
        this.customer_id = id;
    }
    
    public void addAddress(Address address){       
        this.adresses.add(address);
        address.getCustomers().add(this);      
    }

    @Override
    public String toString() {
        return "Customer{" + "customer_id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    public Set<Address> getAddresses(){
        return this.adresses;
    }
    
}
