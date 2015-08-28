package buildingmaintenance.model;

import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.Job;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by nkosi on 2015/08/02.
 */
public class BuildingManagerResource extends ResourceSupport {

    private long resID;
    private String manager_name;

    private List<Building> buildings;

    private BuildingManagerResource() {
    }

    public BuildingManagerResource(Builder builder) {
        this.resID = builder.resID;
        this.manager_name = builder.manager_name;
        this.buildings = builder.buildings;
    }

    public static class Builder {

        private long resID;
        private String manager_name;
        private List<Building> buildings;


        public Builder(String name) {
            this.manager_name = name;
        }

        public Builder resID(Long value) {
            this.resID = value;
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


        public Builder copy(BuildingManagerResource value) {
            this.resID = value.resID;
            this.manager_name = value.manager_name;
            this.buildings = value.buildings;
            return this;
        }

        public BuildingManagerResource build() {
            return new BuildingManagerResource(this);
        }
    }

    public long getManager_id() {
        return resID;
    }

    public String getManager_name() {
        return manager_name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public long getResID() {
        return resID;
    }

}