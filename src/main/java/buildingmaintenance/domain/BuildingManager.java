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
 * @author Nkosy Description self explanatory Date 23/04/2015
 */
@Entity
public class BuildingManager implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long managerID;
    private String manager_name;
    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<Building> buildings;

    private BuildingManager() {
    }

    public BuildingManager(Builder builder) {
        this.managerID = builder.managerID;
        this.manager_name = builder.manager_name;
        this.buildings = builder.buildings;
    }

    public static class Builder {

        private long managerID;
        private String manager_name;
        private List<Building> buildings;

        public Builder(String name) {
            this.manager_name = name;
        }

        public Builder manager_id(Long value) {
            this.managerID = value;
            return this;
        }
        
         public Builder manager_name(String value) {
            this.manager_name = value;
            return this;
        }

        public Builder buildings(List<Building> value) {
            this.buildings = value;
            return this;
        }

        public Builder copy(BuildingManager value) {
            this.managerID = value.managerID;
            this.manager_name = value.manager_name;
            //this.buildings = value.buildings;
            return this;
        }

        public BuildingManager build() {
            return new BuildingManager(this);
        }
    }

    public long getManager_id() {
        return managerID;
    }

    public String getManager_name() {
        return manager_name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (int) (this.managerID ^ (this.managerID >>> 32));
        hash = 29 * hash + Objects.hashCode(this.manager_name);
        //hash = 29 * hash + Objects.hashCode(this.buildings);
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
        final BuildingManager other = (BuildingManager) obj;
        return true;
    }

}
