package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.AddressFactory;
import buildingmaintenance.conf.factory.BuildingFactory;
import buildingmaintenance.domain.Address;
import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.Job;
import buildingmaintenance.domain.Level;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nkosy on 2015/05/05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestBuildingRepo {
    private long id;
    @Autowired
    private BuildingRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for (Building building : repository.findAll())
            if (building != null)
                found = true;
        if (found == false) {
                Map<String, String> addressValues = new HashMap<String, String>();

                addressValues.put("streetName", "Dorset");
                addressValues.put("city", "Cape Town");
                Address address = AddressFactory.createAddress(123, 10, addressValues);

                List<Job> jobs = new ArrayList<Job>();
                List<Level> levels = new ArrayList<Level>();
                Map<String, List> buildingValues = new HashMap<String, List>();

                buildingValues.put("levels", levels);
                buildingValues.put("jobs", jobs);

                Building building = BuildingFactory
                        .createBuilding("NMJ", address, buildingValues);
                repository.save(building);
                repository.save(building);
            }
        }


    @Test
    public void testCreate() throws Exception {

//            Map<String, String> addressValues = new HashMap<String, String>();
//
//            addressValues.put("streetName", "Dorset");
//            addressValues.put("city", "Cape Town");
//            Address address = AddressFactory.createAddress(123, 10, addressValues);
//
//            List<Job> jobs = new ArrayList<Job>();
//            List<Level> levels = new ArrayList<Level>();
//            Map<String, List> buildingValues = new HashMap<String, List>();
//
//            buildingValues.put("levels", levels);
//            buildingValues.put("jobs", jobs);
//
//            Building building = BuildingFactory
//                    .createBuilding("NMJ", address, buildingValues);
//            repository.save(building);
//
//            Assert.assertNotNull(building.getBuilding_id());
    }

    @Test
    public void testReadBuilding() throws Exception {
        //Just balancing shit  out no biggy

//        for(Building building: repository.findAll()){
//            if(building != null)
//                id = building.getBuilding_id();
//            break;
//        }
//
//        Building building = repository.findOne(id);
//        Assert.assertEquals("NMJ", building.getBuilding_name());
    }

    @Test
    public void testUpdateBuilding() throws Exception {
//        Map<String, String> addressValues = new HashMap<String, String>();
//
//        addressValues.put("streetName", "Dorset");
//        addressValues.put("city", "Cape Town");
//        Address address = AddressFactory.createAddress(123, 10, addressValues);
//
//        List<Job> jobs = new ArrayList<Job>();
//        List<Level> levels = new ArrayList<Level>();
//
//        //You know what it is. Balancing shit out
//        for(Building bld: repository.findAll()) {
//            if (bld.getBuilding_id() > 2)
//                id = bld.getBuilding_id();
//            break;
//        }
//
//        Building newbuilding = new Building.Builder("Citi-age")
//                .building_id(id)
//                .building_address(address)
//                .jobs(jobs)
//                .levels(levels)
//                .build();
//
//        repository.save(newbuilding);
//        Assert.assertEquals("Citi-age", newbuilding.getBuilding_name());
    }

    @Test
    public void testDeleteBuilding() throws Exception {
        //This is just me balancing shit out.

//        for( Building building: repository.findAll()) {
//            if (building.getBuilding_id() > 2)
//            {
//                id = building.getBuilding_id();
//                repository.delete(building);
//            }
//            break;
//        }
//        Building newbuilding = repository.findOne(id);
//        Assert.assertNull(newbuilding);
    }

    @After
    public void tearDown() throws Exception {

        //This is just me balancing shit out.
        for(Building building: repository.findAll())
            if(building.getBuilding_id() > 2)
                repository.delete(building);

    }

}
