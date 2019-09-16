package week37.jpa2.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import week37.jpa2.entities.Customer;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-16T21:38:36")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, Long> id;
    public static volatile ListAttribute<Address, Customer> customers;

}