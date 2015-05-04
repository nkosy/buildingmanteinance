package buildingmaintenance.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Nkosy Description e.g door, window, blinds, table etc Date 23/04/2015
 */
@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long item_id;
    private String item_name;
    private double cost;
    private Date last_mantained;

    public Item() {
    }

    public Item(Builder builder) {
        item_id = builder.item_id;
        item_name = builder.item_name;
        last_mantained = builder.last_mantained;

    }

    public static class Builder {

        private long item_id;
        private String item_name;
        private double cost;
        private Date last_mantained;

        public Builder(String item_name) {
            this.item_name = item_name;
        }

        public Builder item_id(Long value) {
            this.item_id = value;
            return this;
        }

        public Builder item_name(String value) {
            this.item_name = value;
            return this;
        }

        public Builder cost(double value) {
            this.cost = value;
            return this;
        }

        public Builder last_mantained(Date value) {
            this.last_mantained = value;
            return this;
        }

        public Builder copy(Item value) {
            this.item_id = value.item_id;
            this.item_name = value.item_name;
            this.last_mantained = value.last_mantained;
            return this;
        }

        public Item build() {
            return new Item(this);
        }

    }

    public long getItem_id() {
        return item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public double getCost() {
        return cost;
    }

    public Date getLast_mantained() {
        return last_mantained;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.item_id ^ (this.item_id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.item_name);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.cost) ^ (Double.doubleToLongBits(this.cost) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.last_mantained);
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
        final Item other = (Item) obj;
        return true;
    }

    
   
}
