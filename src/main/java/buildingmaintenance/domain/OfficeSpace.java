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

/**
 * @author Nkosy Description office space occupied by a tenant Date 23/04/2015
 */
@Entity
public class OfficeSpace implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long officeSpace_id;
    private int officeSpace_no;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "officeSpace_id")
    private List<Facility> facilities;

    private OfficeSpace() {
    }

    public OfficeSpace(Builder builder) {
        officeSpace_id = builder.officeSpace_id;
        officeSpace_no = builder.officeSpace_no;
        facilities = builder.facilities;
    }

    public static class Builder {

        private long officeSpace_id;
        private int officeSpace_no;
        private List<Facility> facilities;

        public Builder(int officeSpace_no) {
            this.officeSpace_no = officeSpace_no;
        }

        public Builder officeSpace_id(Long value) {
            this.officeSpace_id = value;
            return this;
        }

        public Builder officeSpace_no(int value) {
            this.officeSpace_no = value;
            return this;
        }

        public Builder facilities(List<Facility> value) {
            this.facilities = value;
            return this;
        }

        public Builder copy(OfficeSpace value) {
            this.officeSpace_id = value.officeSpace_id;
            this.officeSpace_no = value.officeSpace_no;
            this.facilities = value.facilities;
            return this;
        }

        public OfficeSpace build() {
            return new OfficeSpace(this);
        }
    }

    public long getOfficeSpace_id() {
        return officeSpace_id;
    }

    public int getOfficeSpace_no() {
        return officeSpace_no;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.officeSpace_id ^ (this.officeSpace_id >>> 32));
        hash = 59 * hash + this.officeSpace_no;
        hash = 59 * hash + Objects.hashCode(this.facilities);
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
        final OfficeSpace other = (OfficeSpace) obj;
        return true;
    }

}
