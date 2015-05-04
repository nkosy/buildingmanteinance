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
import javax.persistence.OneToOne;

/*@author       Nkosy
 *@Date         23/042015
 *@Description  A company contacted to do mantainance jobs
 */
@Entity
public class Subcontractor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subcontractor_id;
    private long subcontractorManager_id;
   // @OneToOne(cascade = CascadeType.ALL)
    private String subcontractor_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="subcontractor_id")
    private List<Job> jobs;

    private Subcontractor() {
    }
    
     public Subcontractor(Builder builder){
        this.subcontractor_id = builder.subcontractor_id;
        this.subcontractorManager_id = builder.subcontractorManager_id;
        this.subcontractor_name = builder.subcontractor_name;
        this.jobs = builder.jobs;
    }

    public static class Builder {

        private long subcontractor_id;
        private long subcontractorManager_id;
        private String subcontractor_name;
        private List<Job> jobs;

        public Builder(String name) {
            this.subcontractor_name = name;
        }
        
        public Builder subcontractor_id(Long value){
            this.subcontractor_id = value;
            return this;
        }
        
        public Builder subcontractorManager_id(Long value){
            this.subcontractor_id = value;
            return this;
        }
        
        public Builder subcontractor_name(String value){
            this.subcontractor_name = value;
            return this;
        }
        
        public Builder jobs(List<Job> value){
            this.jobs = value;
            return this;
        }
        
        public Builder copy(Subcontractor value){
            this.subcontractor_id = value.subcontractor_id;
            this.subcontractorManager_id = value.subcontractorManager_id;
            this.subcontractor_name = value.subcontractor_name;
            return this;
        }
        
        public Subcontractor build(){
            return new Subcontractor(this);
        }
    }

    public long getSubcontractor_id() {
        return subcontractor_id;
    }

    public long getSubcontractorManager_id() {
        return subcontractorManager_id;
    }

    public String getSubcontractor_name() {
        return subcontractor_name;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.subcontractor_id ^ (this.subcontractor_id >>> 32));
        hash = 23 * hash + (int) (this.subcontractorManager_id ^ (this.subcontractorManager_id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.subcontractor_name);
        hash = 23 * hash + Objects.hashCode(this.jobs);
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
        final Subcontractor other = (Subcontractor) obj;
        return true;
    }
    
    
    
}
