package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.BuildingManagerFactory;
import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.BuildingManager;
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
import java.util.List;

/**
 * Created by Nkosy on 2015/05/04.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestBuildingManagerRepo {
    private long id;
    @Autowired
    private BuildingManagerRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(BuildingManager man: repository.findAll())
            if(man != null)
                found = true;
        if(found == false) {
            List<Building> buildings = new ArrayList<Building>();
            BuildingManager buildingManager = BuildingManagerFactory
                    .createBuildingManager("lil Wayne", buildings);

            repository.save(buildingManager);
            repository.save(buildingManager);
        }
    }

    @Test
    public void testCreate() throws Exception {
        List<Building> buildings = new ArrayList<Building>();
        BuildingManager buildingManager = BuildingManagerFactory
                .createBuildingManager("lil Wayne", buildings);

        repository.save(buildingManager);
        Assert.assertNotNull(buildingManager.getManager_id());
    }

    @Test
    public void testReadBuildingManager() throws Exception {
        //Just balancing shit  out no biggy
        for(BuildingManager man: repository.findAll()) {
            if (man != null) {
                id = man.getManager_id();
            }
            break;
        }
        BuildingManager manager = repository.findOne(id);
        Assert.assertEquals("lil Wayne", manager.getManager_name());
    }

    @Test
    public void testUpdateBuildingManager() throws Exception {
        List<Building> buildings = new ArrayList<Building>();
        //You know what it is. Balancing shit out
        for(BuildingManager man: repository.findAll()) {
            if (man.getManager_id() > 2)
                id = man.getManager_id();
            break;
        }

        BuildingManager newmanager = new BuildingManager.Builder("George")
                .manager_id(id)
                .buildings(buildings)
                .build();

        repository.save(newmanager);
        Assert.assertEquals("George", newmanager.getManager_name());
    }

    @Test
    public void testDeleteBuildingManager() throws Exception {
        //This is just me balancing shit out.

        for( BuildingManager man: repository.findAll()) {
            if (man.getManager_id() > 2) {
                id = man.getManager_id();
                repository.delete(man);
            }
            break;
        }
        BuildingManager newmanager = repository.findOne(id);
        Assert.assertNull(newmanager);
    }


    @After
    public void tearDown() throws Exception {

       //This is just me balancing shit out.
        for(BuildingManager man: repository.findAll())
            if(man.getManager_id() > 2)
                repository.delete(man);

    }
}
