/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week37.jpa2.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author jobe
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @Column(name="street")
    private String street;
    
    @Column(name="city")
    private String city;

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", city=" + city + '}';
    }
    
    @ManyToMany(mappedBy = "adresses", cascade = CascadeType.PERSIST)
    private Set<Customer> customers  = new HashSet();
  
    public Long getId() {
        return id;
    }
         
    // Empty constructor
    public Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
    
    public void addCustomer(Customer customer){
        this.customers.add(customer);
        customer.getAddresses().add(this);
    }  

    public Set<Customer> getCustomers() {
        return customers;
    }

}