/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week37.jpa2.facade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import week37.jpa2.entities.Address;


/**
 *
 * @author jobe
 */
public class AddressFacade {
    
        private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
 
        
        public static Address addAddress(Address address){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
            return address;
        } finally {
            em.close();
        }  
    }
    
}
