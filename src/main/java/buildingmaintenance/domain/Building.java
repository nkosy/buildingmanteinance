package buildingmaintenance.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/*@author       Nkosy
 *@Date         23/042015
 *@Description  An entity that stores the details of a building 
 */
@javax.persistence.Entity
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long buildingID;
    private String building_name;
    @Embedded
    private Address building_address;

    //A list of mantainance jobs that have been done on a particular building
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "buildingId")
    private List<Job> jobs;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "buildingID")
    private List<Level> levels;

    private Building() {
    }

    private Building(Builder builder) {
        this.buildingID = builder.buildingID;
        this.building_name = builder.building_name;
        //this.jobs = builder.jobs;
        this.building_address = builder.building_address;
        //this.jobs = builder.jobs;
        //this.levels = builder.levels;
    }

    public static class Builder {

        private long buildingID;

        private String building_name;
        private Address building_address;
        private List<Job> jobs;
        private List<Level> levels;

        public Builder(String name) {
            this.building_name = name;
        }

        public Builder building_id(Long value) {
            this.buildingID = value;
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

        public Builder copy(Building value) {
            this.buildingID = value.buildingID;

            this.building_name = value.building_name;
            this.jobs = value.jobs;
            this.levels = value.levels;
            return this;
        }

        public Building build() {
            return new Building(this);
        }
    }

    public long getBuilding_id() {
        return buildingID;
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
