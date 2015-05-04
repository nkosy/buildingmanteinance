package buildingmaintenance.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/*@author       Nkosy
 *@Date         23/042015
 *@Description  An entity that stores the details of a building 
 */
@Entity
public class Tenant implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tenant_id;
    private String tenant_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="tenant_id")
    private List<OfficeSpace> officeSpaces;

    private Tenant() {
    }
    
    public Tenant(Builder builder){
        this.tenant_id = builder.tenant_id;
        this.tenant_name = builder.tenant_name;
        this.officeSpaces = builder.officeSpaces;
    }

    public static class Builder {

        private long tenant_id;
        private String tenant_name;
        private List<OfficeSpace> officeSpaces;

        public Builder(String tenant_name) {
            this.tenant_name = tenant_name;
        }
        
        public Builder tenantId(Long value){
            this.tenant_id = value;
            return this;
        }
        
        public Builder tenant_name(String value){
            this.tenant_name = value;
            return this;
        }
        
        public Builder officeSpaces(List<OfficeSpace> value){
            this.officeSpaces = value;
            return this;
        }
        
        public Builder copy(Tenant value){
            this.tenant_id = value.tenant_id;
            this.tenant_name = value.tenant_name;
            this.officeSpaces = value.officeSpaces;
            return this;
        }
        
         public Tenant build(){
            return new Tenant(this);
        }
    }

    public long getTenant_id() {
        return tenant_id;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public List<OfficeSpace> getOfficeSpaces() {
        return officeSpaces;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (this.tenant_id ^ (this.tenant_id >>> 32));
        hash = 11 * hash + Objects.hashCode(this.tenant_name);
        hash = 11 * hash + Objects.hashCode(this.officeSpaces);
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
        final Tenant other = (Tenant) obj;
        return true;
    }
    
    
}
