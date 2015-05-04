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
 *
 * @author      Nkosy 
 * Description  floor level of a building Date 23/04/2015
 * Date         23/04/2015
 */
@Entity
public class Level implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long level_id;
    private long building_id;
    private String level_name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="level_id")
    private List<OfficeSpace> officeSpaces;

    private Level() {
    }
    
     public Level(Builder builder) {
        level_id=builder.level_id;
        level_name=builder.level_name;
        this.officeSpaces = builder.officeSpaces;
    }

    public static class Builder {

        private long level_id;
        private String level_name;
        private List<OfficeSpace> officeSpaces;

        public Builder(String level_name) {
            this.level_name = level_name;
        }
        
        public Builder level_id(int value){
            this.level_id=value;
            return this;
        }
        
        public Builder level_name(String value){
            this.level_name=value;
            return this;
        }
        
        public Builder officeSpaces(List<OfficeSpace> value){
            this.officeSpaces = value;
            return this;
        }
        
        public Builder copy(Level value){
            this.level_id=value.level_id;
            this.level_name=value.level_name;
            this.officeSpaces = value.officeSpaces;
            return this;
        }
        
        public Level build(){
            return new Level(this);
        }
    }

    public long getLevel_id() {
        return level_id;
    }

    public long getBuilding_id() {
        return building_id;
    }

    public String getLevel_name() {
        return level_name;
    }

    public List<OfficeSpace> getOfficeSpaces() {
        return officeSpaces;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.level_id ^ (this.level_id >>> 32));
        hash = 53 * hash + (int) (this.building_id ^ (this.building_id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.level_name);
        hash = 53 * hash + Objects.hashCode(this.officeSpaces);
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
        final Level other = (Level) obj;
        return true;
    }
    
    
}
