/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week37.jpa2.entities;

import java.util.List;
import java.util.Set;
import week37.jpa2.facade.CustomerFacade;
import week37.jpa2.facade.AddressFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jobe
 */
public class Tester {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    
    
    public static void main(String[] args){

        Customer c1 = new Customer("Jon","Bertelsen");
        Customer c2 = new Customer("Jønke","Svendsen");

        Address a1 = new Address("Nordre Frihavnsgade 28", "Kbh Ø");
        Address a2 = new Address("Slagtehusgade 10", "Kbh K");
      
        a1 = AddressFacade.addAddress(a1);
        a2 = AddressFacade.addAddress(a2);
        c1 = CustomerFacade.addCustomer(c1);
        c2 = CustomerFacade.addCustomer(c2);
        
        CustomerFacade.addAddress(c1, a1);
        CustomerFacade.addAddress(c1, a2);
        CustomerFacade.addAddress(c2, a1);
//       
  //    Jeg opretter et adresseobjekt, som jeg genbruger til to forskellige
  //    kunder. Når jeg indsætter kunderne nedenfor, så ryger der
  //    2 rækker i adressetabellen. Det går fint nok, hvis jeg opretter
  //    1 kunde med to adresser. Her ser alt fint ud.
  
//        c1.addAddress(a1);
//        c2.addAddress(a1);
//         
//        c1 = CustomerFacade.addCustomer(c1);
//        c2 = CustomerFacade.addCustomer(c2);
 
    }
    
    
    
}
