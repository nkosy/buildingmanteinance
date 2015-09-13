package buildingmaintenance.model;

import buildingmaintenance.domain.Address;
import buildingmaintenance.domain.Job;
import buildingmaintenance.domain.Level;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by nkosi on 2015/08/23.
 */
public class BuildingResource extends ResourceSupport{

    private long resID;
    private String building_name;

    private Address building_address;

    //A list of mantainance jobs that have been done on a particular building
    private List<Job> jobs;
    private List<Level> levels;

    private BuildingResource() {
    }

    private BuildingResource(Builder builder) {
        this.resID = builder.resID;
        this.building_name = builder.building_name;
        this.jobs = builder.jobs;
        this.building_address = builder.building_address;
        this.jobs = builder.jobs;
        this.levels = builder.levels;
    }

    public static class Builder {

        private long resID;

        private String building_name;
        private Address building_address;
        private List<Job> jobs;
        private List<Level> levels;

        public Builder(String name) {
            this.building_name = name;
        }

        public Builder res_id(Long value) {
            this.resID = value;
            return this;
        }

        public Builder building_name(String value){
            this.building_name = value;
            return this;
        }
        public Builder building_address(Address value) {
            this.building_address = value;
            return this;
        }

        public Builder jobs(List<Job> value) {
            this.jobs = value;
            return this;
        }

        public Builder levels(List<Level> value) {
            this.levels = value;
            return this;
        }

        public Builder copy(BuildingResource value) {
            this.resID = value.resID;

            this.building_name = value.building_name;
            this.jobs = value.jobs;
            this.levels = value.levels;
            return this;
        }

        public BuildingResource build() {
            return new BuildingResource(this);
        }
    }


    public long getResID() {
        return resID;
    }

    public String getBuilding_name() {
        return building_name;
    }

    public Address getBuilding_address() {
        return building_address;
    }

    public List<Job> getJobs() {
        return jobs;
    }
    public List<Level> getLevels() {
        return levels;
    }
}
