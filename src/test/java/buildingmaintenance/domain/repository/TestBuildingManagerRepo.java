package buildingmaintenance.domain.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.BuildingManagerFactory;
import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.BuildingManager;
import buildingmaintenance.repository.BuildingManagerRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
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
        System.out.println(buildingManager.getManager_id());
        Assert.assertNotNull(buildingManager.getManager_id());

        id = buildingManager.getManager_id();
    }

    @Test
    public void testReadBuildingManager() throws Exception {
        //Just balancing shit  out no biggy

        for(BuildingManager man: repository.findAll())
            if(man != null)
            {
                id = man.getManager_id();
                System.out.println("I found this while scanning the database " + id);
            }
        BuildingManager manager = repository.findOne(id);
        Assert.assertEquals("lil Wayne", manager.getManager_name());
    }

    @Test
    public void testUpdateBuildingManager() throws Exception {
        List<Building> buildings = new ArrayList<Building>();
        BuildingManager manager= repository.findOne(id);
        BuildingManager newmanager = new BuildingManager.Builder("George")
                .manager_id((long)1)
                .buildings(buildings)
                .build();

        repository.save(newmanager);
        Assert.assertEquals("George", newmanager.getManager_name());
    }

    @Test
    public void testDeleteBuildingManager() throws Exception {
        //This is just me balancing shit out.

        for( BuildingManager man: repository.findAll()) {
            if (man.getManager_id() > 2)
                repository.delete(man);

            repository.delete(man);
            BuildingManager newmanager = repository.findOne(man.getManager_id());
            Assert.assertNull(newmanager);
            break;
        }
    }


    @After
    public void tearDown() throws Exception {

       //This is just me balancing shit out.
        for(BuildingManager man: repository.findAll())
            if(man.getManager_id() > 2)
                repository.delete(man);

    }
}
