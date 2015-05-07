package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.LevelFactory;
import buildingmaintenance.domain.Level;
import buildingmaintenance.domain.OfficeSpace;
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
 * Created by Nkosy on 2015/05/05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestLevelRepo {
    private long id;
    @Autowired
    private LevelRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(Level lev: repository.findAll())
            if(lev != null)
                found = true;
        if(found == false) {
            List<OfficeSpace> officeSpaces = new ArrayList<OfficeSpace>();
            Level level1 = LevelFactory.createLevel("Ground Floor", officeSpaces);
            Level level2 = LevelFactory.createLevel("First Floor", officeSpaces);
            repository.save(level1);
            repository.save(level2);
        }
    }

    @Test
    public void testCreateLevel() throws Exception {
        List<OfficeSpace> officeSpaces = new ArrayList<OfficeSpace>();
        Level level = LevelFactory.createLevel("Third Floor", officeSpaces);
        repository.save(level);

        Assert.assertNotNull(level.getLevel_id());
    }

    @Test
    public void testReadLevel() throws Exception {

        //Just balancing shit  out no biggy

        for(Level thelev: repository.findAll()) {
            if (thelev != null)
                id = thelev.getLevel_id();
            break;
        }
        Level lev = repository.findOne(id);
        Assert.assertEquals("Ground Floor", lev.getLevel_name());
    }

    @Test
    public void testUpdateLevel() throws Exception {
        List<OfficeSpace> officeSpaces = new ArrayList<OfficeSpace>();

        //You know what it is. Balancing shit out
        for(Level lev: repository.findAll())
            if(lev.getLevel_id() > 2)
                id = lev.getLevel_id();

        Level newlevel = new Level.Builder("3rd Floor")
                .level_id(id)
                .level_name("3rd Floor")
                .officeSpaces(officeSpaces)
                .build();

        repository.save(newlevel);
        Assert.assertEquals("3rd Floor", newlevel.getLevel_name());
    }

    @Test
    public void testDeleteBuilding() throws Exception {
        //This is just me balancing shit out.

        for( Level lev: repository.findAll()) {
            if (lev.getLevel_id() > 2)
            {
                id = lev.getLevel_id();
                repository.delete(lev);
            }
            break;
        }
        Level newlevel = repository.findOne(id);
        Assert.assertNull(newlevel);
    }


    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(Level lev: repository.findAll())
            if(lev.getLevel_id() > 2)
                repository.delete(lev);
    }
}
