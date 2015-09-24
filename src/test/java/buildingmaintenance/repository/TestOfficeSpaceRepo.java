package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.OfficeSpaceFactory;
import buildingmaintenance.domain.Facility;
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
 * Created by Nkosy on 2015/05/06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestOfficeSpaceRepo {
    private long id;
    @Autowired
    private OfficeSpaceRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(OfficeSpace lev: repository.findAll())
            if(lev != null)
                found = true;
        if(found == false) {
            List<Facility> facilities = new ArrayList<Facility>();
            OfficeSpace officespace1 = OfficeSpaceFactory.createOfficeSpace(1, facilities);
            OfficeSpace officespace2 = OfficeSpaceFactory.createOfficeSpace(2, facilities);
            repository.save(officespace1);
            repository.save(officespace2);
        }
    }

    @Test
    public void testCreateOfficeSpace() throws Exception {
//        List<Facility> facilities = new ArrayList<Facility>();
//        OfficeSpace officespace = OfficeSpaceFactory.createOfficeSpace(3, facilities);
//        repository.save(officespace);
//
//        Assert.assertNotNull(officespace.getOfficeSpace_id());
    }

    @Test
    public void testReadOfficeSpace() throws Exception {

        //Just balancing shit  out no biggy

//        for(OfficeSpace space: repository.findAll()) {
//            if (space != null)
//                id = space.getOfficeSpace_id();
//            break;
//        }
//        OfficeSpace space = repository.findOne(id);
//        Assert.assertEquals(1, space.getOfficeSpace_no());
    }

    @Test
    public void testUpdateOfficeSpace() throws Exception {
        List<Facility> facilities = new ArrayList<Facility>();

        //You know what it is. Balancing shit out
//        for(OfficeSpace thespace: repository.findAll())
//            if(thespace.getOfficeSpace_id() > 2)
//                id = thespace.getOfficeSpace_id();
//
//        OfficeSpace newspace = new OfficeSpace.Builder(3)
//                .officeSpace_id(id)
//                .officeSpace_no(3)
//                .facilities(facilities)
//                .build();
//
//        repository.save(newspace);
//        Assert.assertEquals(3, newspace.getOfficeSpace_no());
    }

    @Test
    public void testDeleteOfficeSpace() throws Exception {
        //This is just me balancing shit out.

//        for( OfficeSpace space: repository.findAll()) {
//            if (space.getOfficeSpace_id() > 2)
//            {
//                id = space.getOfficeSpace_id();
//                repository.delete(space);
//            }
//            break;
//        }
//        OfficeSpace newspace = repository.findOne(id);
//        Assert.assertNull(newspace);
    }
    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(OfficeSpace space: repository.findAll())
            if(space.getOfficeSpace_id() > 2)
                repository.delete(space);
    }
}
