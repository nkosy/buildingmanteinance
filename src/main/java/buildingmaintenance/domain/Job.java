package buildingmaintenance.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Nkosy Description job entity representing a maintainance job done on
 * a building Date 23/04/2015
 */
@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long job_id;
    private Date date;
    private String job_description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_id")
    private List<Item> items;

    private Job() {
    }

    public Job(Builder builder) {
        this.job_id = builder.job_id;
        this.date = builder.date;
        this.job_description = builder.job_description;
    }

    public static class Builder {

        private long job_id;
        private Date date;
        private String job_description;
        private List<Item> items;

        public Builder(String description) {
            this.job_description = description;
        }

        public Builder job_id(Long value) {
            this.job_id = value;
            return this;
        }

        public Builder date(Date value) {
            this.date = value;
            return this;
        }

        public Builder items(List value) {
            this.items = value;
            return this;
        }
        
        public Builder job_Description(String value) {
            this.job_description = value;
            return this;
        }

        public Builder copy(Job value) {
            this.job_id = value.job_id;
            this.date = value.date;
            this.job_description = value.job_description;
            this.items = value.items;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }

    public long getJob_id() {
        return job_id;
    }

    public Date getDate() {
        return date;
    }

    public String getJob_description() {
        return job_description;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.job_id ^ (this.job_id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.date);
        hash = 59 * hash + Objects.hashCode(this.job_description);
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
        final Job other = (Job) obj;
        return true;
    }

}
