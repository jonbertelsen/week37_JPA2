package week37.jpa2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import week37.jpa2.entities.Address;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-16T21:38:36")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile ListAttribute<Customer, Address> adresses;
    public static volatile SingularAttribute<Customer, Long> customer_id;

}