package buildingmaintenance.service;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.AddressFactory;
import buildingmaintenance.conf.factory.BuildingFactory;
import buildingmaintenance.domain.Address;
import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.Job;
import buildingmaintenance.domain.Level;
import buildingmaintenance.repository.BuildingRepository;
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
 * Created by nkosi on 2015/05/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class BuildingServiceTest {
    @Autowired
    private BuildingService service;

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
    public void testGetAllBuildings() throws Exception{
        List<Building> buildingList = service.getAllBuildings();
        Assert.assertTrue(buildingList.size() >= 2);
    }

    @Test
    public void testGetBuildingByID() throws Exception {
        Building building = service.getBuildingByID((long)1);
        Assert.assertEquals("NMJ", building.getBuilding_name());
    }

    @Test
    public void testGetBuildingByName() throws Exception {
        Building building = service.getBuildingByName("NMJ");
        Assert.assertNotNull(building);

    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(Building building: repository.findAll())
            if(building.getBuilding_id() > 2)
                repository.delete(building);
    }
}
