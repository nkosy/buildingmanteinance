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
        
        public Builder level_id(long value){
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Level)) return false;

        Level level = (Level) o;

        if (level_id != level.level_id) return false;
        if (building_id != level.building_id) return false;
        if (level_name != null ? !level_name.equals(level.level_name) : level.level_name != null) return false;
        return !(officeSpaces != null ? !officeSpaces.equals(level.officeSpaces) : level.officeSpaces != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (level_id ^ (level_id >>> 32));
        result = 31 * result + (int) (building_id ^ (building_id >>> 32));
        result = 31 * result + (level_name != null ? level_name.hashCode() : 0);
        result = 31 * result + (officeSpaces != null ? officeSpaces.hashCode() : 0);
        return result;
    }
}
