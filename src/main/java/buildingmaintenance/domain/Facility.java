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
 * @author Nkosy Description e.g toilet, kitchen, TV room Date 23/04/2015
 */
@Entity
public class Facility implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long facility_id;
    private String facility_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "officeSpace_id")
    private List<Item> items;

    private Facility() {
    }

    public Facility(Builder builder) {
        facility_id = builder.facility_id;
        facility_name = builder.facility_name;
        items = builder.items;
    }

    public static class Builder {

        private long facility_id;
        private String facility_name;
        private List<Item> items;

        public Builder(String facility_name) {
            this.facility_name = facility_name;
        }

        public Builder facilty_id(Long value) {
            this.facility_id = value;
            return this;
        }
        
         public Builder facilty_name(String value) {
            this.facility_name = value;
            return this;
        }

        public Builder items(List<Item> value) {
            this.items = value;
            return this;
        }

        public Builder copy(Facility value) {
            this.facility_id = value.facility_id;
            this.facility_name = value.facility_name;
            this.items = value.items;
            return this;
        }

        public Facility build() {
            return new Facility(this);
        }
    }

    public long getFacility_id() {
        return facility_id;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.facility_id ^ (this.facility_id >>> 32));
        hash = 59 * hash + Objects.hashCode(this.facility_name);
        hash = 59 * hash + Objects.hashCode(this.items);
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
        final Facility other = (Facility) obj;
        return true;
    }

}
