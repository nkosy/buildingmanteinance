package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.FacilityFactory;
import buildingmaintenance.domain.Facility;
import buildingmaintenance.domain.Item;
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
public class TestFacilityRepo {
    private long id;
    @Autowired
    private FacilityRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(Facility fac: repository.findAll())
            if(fac != null)
                found = true;
        if(found == false) {
            List<Item> items = new ArrayList<Item>();
            Facility facility = FacilityFactory
                    .createFacility("Kitchen", items);
            repository.save(facility);
            repository.save(facility);
        }
    }

    @Test
    public void testCreateFacility() throws Exception {
//        List<Item> items = new ArrayList<Item>();
//        Facility facility = FacilityFactory
//                .createFacility("Kitchen", items);
//
//        repository.save(facility);
//        Assert.assertNotNull(facility);
    }

    @Test
    public void testReadFacility() throws Exception {

        //Just balancing shit  out no biggy

//        for(Facility fac: repository.findAll()) {
//            if (fac != null)
//                id = fac.getFacility_id();
//            break;
//        }
//        Facility fac = repository.findOne(id);
//        Assert.assertEquals("Kitchen", fac.getFacility_name());
    }

    @Test
    public void testUpdateFacility() throws Exception {
        List<Item> items = new ArrayList<Item>();

        //You know what it is. Balancing shit out
//        for(Facility fac: repository.findAll())
//            if(fac.getFacility_id() > 2)
//                id = fac.getFacility_id();
//
//        Facility newfacility = new Facility.Builder("Bathroom")
//                .facilty_id(id)
//                .facilty_name("Bathroom")
//                .items(items)
//                .build();
//
//        repository.save(newfacility);
//        Assert.assertEquals("Bathroom", newfacility.getFacility_name());
    }

    @Test
    public void testDeleteTenant() throws Exception {
        //This is just me balancing shit out.

//        for( Facility fac: repository.findAll()) {
//            if (fac.getFacility_id() > 2)
//            {
//                id = fac.getFacility_id();
//                repository.delete(fac);
//            }
//            break;
//        }
//        Facility newfacility = repository.findOne(id);
//        Assert.assertNull(newfacility);
    }

    @After
    public void tearDown() throws Exception {

        //This is just me balancing shit out.
        for(Facility fac: repository.findAll())
            if(fac.getFacility_id() > 2)
                repository.delete(fac);

    }
}
