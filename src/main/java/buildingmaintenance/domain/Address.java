package buildingmaintenance.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author      Nkosy
 * Description  Address object of a building
 * Date         23/04/2015
 */
@Embeddable
public class Address implements Serializable {
    private int zipcode;
    private int street_no;
    private String street_name;
    private String city;

    private Address() {
        
    }
    
    public Address(Builder builder) {
        zipcode=builder.zipCode;
        street_no=builder.street_no;
        street_name=builder.street_name;
        city = builder.city;
        
    }
    
    public int getZipcode() {
            return zipcode;
        }

        public int getStreet_no() {
            return street_no;
        }

        public String getStreet_name() {
            return street_name;
        }

        public String getCity() {
            return city;
        }
    
    public static class Builder{
        private int zipCode;
        private int street_no;
        private String street_name;
        private String city;
        
        public Builder(int street_no) {
            this.street_no = street_no;
        }
        
        public Builder zipCode(int value){
            this.zipCode=value;
            return this;
        }
        
        public Builder streetName(String value){
            this.street_name=value;
            return this;
        }
        
        public Builder city(String value){
            this.city=value;
            return this;
        }
        
        public Builder copy(Address value){
            this.street_no=value.street_no;
            this.street_name=value.street_name;
            this.zipCode=value.zipcode;
            this.city=value.city;
            return this;
        }
        
         public Address build(){
            return new Address(this);
        }
        
    }
     
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.zipcode;
        hash = 59 * hash + this.street_no;
        hash = 59 * hash + Objects.hashCode(this.street_name);
        hash = 59 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        return true;
    }
    
    
}
