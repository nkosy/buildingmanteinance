package buildingmaintenance.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/*@author       Nkosy
 *@Date         23/042015
 *@Description  A company contacted to do mantainance jobs
 */
@Entity
public class Subcontractor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subcontractor_id;
    @Embedded
    private SubcontractorManager subcontractorManager;
    private String subcontractor_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="subcontractor_id")
    private List<Job> jobs;

    private Subcontractor() {
    }
    
     public Subcontractor(Builder builder){
        this.subcontractor_id = builder.subcontractor_id;
        this.subcontractorManager = builder.subcontractorManager;
        this.subcontractor_name = builder.subcontractor_name;
        this.jobs = builder.jobs;
    }

    public static class Builder {

        private long subcontractor_id;
        private SubcontractorManager subcontractorManager;
        private String subcontractor_name;
        private List<Job> jobs;

        public Builder(String name) {
            this.subcontractor_name = name;
        }
        
        public Builder subcontractor_id(Long value){
            this.subcontractor_id = value;
            return this;
        }
        
        public Builder subcontracto_id(long value){
            this.subcontractor_id = value;
            return this;
        }
        
        public Builder subcontractor_name(String value){
            this.subcontractor_name = value;
            return this;
        }

        public Builder subcontractorManager(SubcontractorManager value){
            this.subcontractorManager = value;
            return this;
        }
        
        public Builder jobs(List<Job> value){
            this.jobs = value;
            return this;
        }
        
        public Builder copy(Subcontractor value){
            this.subcontractor_id = value.subcontractor_id;
            this.subcontractorManager = value.subcontractorManager;
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

    public SubcontractorManager getSubcontractorManager() {
        return subcontractorManager;
    }

    public String getSubcontractor_name() {
        return subcontractor_name;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subcontractor)) return false;

        Subcontractor that = (Subcontractor) o;

        if (subcontractor_id != that.subcontractor_id) return false;
        if (subcontractorManager != null ? !subcontractorManager.equals(that.subcontractorManager) : that.subcontractorManager != null)
            return false;
        if (subcontractor_name != null ? !subcontractor_name.equals(that.subcontractor_name) : that.subcontractor_name != null)
            return false;
        return !(jobs != null ? !jobs.equals(that.jobs) : that.jobs != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (subcontractor_id ^ (subcontractor_id >>> 32));
        result = 31 * result + (subcontractorManager != null ? subcontractorManager.hashCode() : 0);
        result = 31 * result + (subcontractor_name != null ? subcontractor_name.hashCode() : 0);
        result = 31 * result + (jobs != null ? jobs.hashCode() : 0);
        return result;
    }
}
