
package buildingmaintenance.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author      Nkosy
 * Description  The manager responsible for the company contracted to do the jib
 * Date         23/04/2015
 */
@Entity
public class SubcontractorManager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subcontractorManager_id;
    private String subcontractorManager_name;

    private SubcontractorManager() {
    }
    
    public SubcontractorManager(Builder builder) {
        subcontractorManager_id = builder.subcontractorManager_id;
        subcontractorManager_name = builder.subcontractorManager_name;
    }

    public static class Builder {

        private long subcontractorManager_id;
        private String subcontractorManager_name;

        public Builder(String subcontractorManager_name) {
            this.subcontractorManager_name = subcontractorManager_name;
        }
        
        public Builder subcontractorManager_id(Long value){
            this.subcontractorManager_id=value;
            return this;
        }
        
        public Builder subcontractorManager_name(String value){
            this.subcontractorManager_name=value;
            return this;
        }
        
        public Builder copy(SubcontractorManager value){
            this.subcontractorManager_id=value.subcontractorManager_id;
            this.subcontractorManager_name=value.subcontractorManager_name;
            return this;
        }
        
        public SubcontractorManager build(){
            return new SubcontractorManager(this);
        }
    }

    public long getSubcontractorManager_id() {
        return subcontractorManager_id;
    }

    public String getSubcontractorManager_name() {
        return subcontractorManager_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.subcontractorManager_id ^ (this.subcontractorManager_id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.subcontractorManager_name);
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
        final SubcontractorManager other = (SubcontractorManager) obj;
        return true;
    }
    
    
    
    
}
