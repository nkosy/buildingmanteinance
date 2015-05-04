
package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;

import buildingmaintenance.conf.factory.*;
import buildingmaintenance.domain.*;
import org.junit.Assert;
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
 *
 * @author Nkosy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestCrudBuildingMaintenance {

    //Test Building Repository
    @Autowired
    BuildingRepository repository;

    @Test
    public void testCreateBuilding() throws Exception {
        Map<String, String> addressValues = new HashMap<String, String>();

        addressValues.put("streetName", "SirLowry");
        addressValues.put("city", "Cape Town");
        Address address = AddressFactory.createAddress(666, 34, addressValues);

        List<Job> jobs = new ArrayList<Job>();
        List<Level> levels = new ArrayList<Level>();
        Map<String, List> buildingValues = new HashMap<String, List>();

        buildingValues.put("levels", levels);
        buildingValues.put("jobs", jobs);

        Building building = BuildingFactory
                .createBuilding("Illovo", address, buildingValues);
        repository.save(building);

        Assert.assertNotNull(building.getBuilding_id());
                
    }

    @Test
    public void testReadBuilding() throws Exception {
        Building building = repository.findOne((long)4);
        Assert.assertEquals("Jack's place", building.getBuilding_name());
    }

    @Test
    public void testUpdateBuilding() throws Exception {

        Building building = repository.findOne((long)3);
        Building newbuilding = new Building.Builder("Calton Heights")
                .building_id(building.getBuilding_id())
                .building_address(building.getBuilding_address())
                .build();

        repository.save(newbuilding);
        Assert.assertEquals("Calton Heights", newbuilding.getBuilding_name());
    }

    @Test
    public void testDeleteBuilding() throws Exception {
        Building building = repository.findOne((long)2);
        //repository.delete(building);
        Building newbuilding = repository.findOne((long)2);
        Assert.assertNull(newbuilding);
    }

    //Test Building Manager Repository
    @Autowired
    BuildingManagerRepository managerRepository;

    @Test
    public void testCreateBuildingManager() throws Exception {
        List<Building> buildings = new ArrayList<Building>();
        BuildingManager buildingManager = BuildingManagerFactory
                .createBuildingManager("lil Wayne", buildings);

        managerRepository.save(buildingManager);

        Assert.assertNotNull(buildingManager.getManager_id());
    }

    @Test
    public void testReadBuildingManager() throws Exception {
        BuildingManager manager = managerRepository.findOne((long) 1);
        Assert.assertEquals("George", manager.getManager_name());
    }

    @Test
    public void testUpdateBuildingManager() throws Exception {
        List<Building> buildings = new ArrayList<Building>();
        BuildingManager manager= managerRepository.findOne((long) 1);
        BuildingManager newmanager = new BuildingManager.Builder("George")
                .manager_id(manager.getManager_id())
                .buildings(buildings)
                .build();

        //managerRepository.save(newmanager);
        Assert.assertEquals("George", newmanager.getManager_name());
    }

    @Test
    public void testDeleteBuildingManager() throws Exception {
        BuildingManager manager = managerRepository.findOne((long) 3);
        managerRepository.delete(manager);
        BuildingManager newmanager = managerRepository.findOne((long) 3);
        Assert.assertNull(newmanager);
    }

    //Test Facility Repository
    @Autowired
    FacilityRepository facilityRepository;

    @Test
    public void testCreateFacility() throws Exception {
        List<Item> items = new ArrayList<Item>();
        Facility facility = FacilityFactory
                .createFacility("Kitchen", items);
        facilityRepository.save(facility);

       // Assert.assertNotNull(facility.getFacility_id());

    }

    @Test
    public void testReadFacility() throws Exception {

    }

    @Test
    public void testUpdateFacility() throws Exception {

    }

    @Test
    public void testDeleteFacility() throws Exception {
    }

    //Test Level Repository
    @Autowired
    LevelRepository levelRepository;

    /*@Test
    public void testCreateLevel() throws Exception {
        List<OfficeSpace> officeSpaces = new ArrayList<OfficeSpace>();
        Level level = LevelFactory.createLevel("Ground Floor", officeSpaces);
        levelRepository.save(level);
        Assert.assertNotNull(level.getLevel_id());
    }*/

    @Test
    public void testReadLevel() throws Exception {

    }

    @Test
    public void testUpdateLevel() throws Exception {

    }

    @Test
    public void testDeleteLevel() throws Exception {
    }



}
