package buildingmaintenance.service;

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
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class BuildingManagerServiceTest {
    @Autowired
    private BuildingManagerService service;

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
    public void testGetAllManagers() throws Exception {
//        List<BuildingManager> managerList = service.getAllManagers();
//        Assert.assertTrue(managerList.size() >= 2);
    }

    @Test
    public void testGetManagerByID() throws Exception {
//        BuildingManager manager = service.getManagerByID((long)1);
//        Assert.assertEquals("lil Wayne", manager.getManager_name());
    }

    @Test
    public void testGetManagerByName() throws Exception {
//        BuildingManager manager = service.getManagerByName("lil Wayne");
//        Assert.assertNotNull(manager);
    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(BuildingManager man: repository.findAll())
            if(man.getManager_id() > 2)
                repository.delete(man);
    }
}
