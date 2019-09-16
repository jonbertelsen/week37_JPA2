/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week37.jpa2.facade;

import week37.jpa2.entities.Customer;
import week37.jpa2.entities.Address;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author jobe
 */
public class CustomerFacade {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
   
    public static Customer getCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        Customer customer;
        Query query = em.createQuery("SELECT c from Customer c WHERE c.customer_id = :id ");
        query.setParameter("id", id);
        try {
            customer = (Customer)query.getSingleResult();
            return customer;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();     
        }
    }
    
    public static List<Customer> getCustomers() {
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("Select c from Customer c");
        List<Customer> customers =query.getResultList();
        em.close();         
        return customers;
    }

    public static Customer addCustomer(Customer cust){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }  
    }

       public static Customer addAddress(Customer cust, Address a){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            cust.addAddress(a);
            em.merge(cust);
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }  
    }

    
    public static Customer deleteCustomer(int id){
        Customer cust = getCustomer(id);
        if (cust != null){
               EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.remove(cust);
                em.getTransaction().commit();
                
            } finally {
                em.close();
            } 
        }
        return cust;
    }
    
    public static Customer editCustomer(Customer cust){
        if (cust != null){
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.merge(cust);
                em.getTransaction().commit();
            } finally {
                em.close();
            } 
        }
        return cust;
    }
   
}
