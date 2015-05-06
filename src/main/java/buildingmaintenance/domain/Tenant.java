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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="tenant_id")
    private List<MantainanceLog> logs;


    private Tenant() {
    }
    
    private Tenant(Builder builder){
        this.tenant_id = builder.tenant_id;
        this.tenant_name = builder.tenant_name;
        this.officeSpaces = builder.officeSpaces;
    }

    public static class Builder {

        private long tenant_id;
        private String tenant_name;
        private List<OfficeSpace> officeSpaces;
        private List<MantainanceLog> logs;

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

        public Builder logs(List<MantainanceLog> value){
            this.logs = value;
            return this;
        }
        
        public Builder copy(Tenant value){
            this.tenant_id = value.tenant_id;
            this.tenant_name = value.tenant_name;
            this.officeSpaces = value.officeSpaces;
            this.logs = value.logs;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tenant)) return false;

        Tenant tenant = (Tenant) o;

        if (tenant_id != tenant.tenant_id) return false;
        if (tenant_name != null ? !tenant_name.equals(tenant.tenant_name) : tenant.tenant_name != null) return false;
        if (officeSpaces != null ? !officeSpaces.equals(tenant.officeSpaces) : tenant.officeSpaces != null)
            return false;
        return !(logs != null ? !logs.equals(tenant.logs) : tenant.logs != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (tenant_id ^ (tenant_id >>> 32));
        result = 31 * result + (tenant_name != null ? tenant_name.hashCode() : 0);
        result = 31 * result + (officeSpaces != null ? officeSpaces.hashCode() : 0);
        result = 31 * result + (logs != null ? logs.hashCode() : 0);
        return result;
    }
}
