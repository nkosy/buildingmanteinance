
package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;

import buildingmaintenance.conf.factory.AddressFactory;
import buildingmaintenance.conf.factory.BuildingFactory;
import buildingmaintenance.domain.Address;
import buildingmaintenance.domain.Building;
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
public class TestCrudBuilding {
    private Long id;
    
    @Autowired
    BuildingRepository repository;
    @Test
    public void testCreateBuilding() throws Exception {
        Map<String, String> addressValues = new HashMap<String, String>();

        addressValues.put("streetName", "SirLowry");
        addressValues.put("city", "Cape Town");
        Address address = AddressFactory.createAddress(666, 34, addressValues);

        //List<Job> jobs = new ArrayList<Job>();
        //List<Level> levels = new ArrayList<Level>();
        Map<String, List> buildingValues = new HashMap<String, List>();

        //buildingValues.put("levels", levels);
        //buildingValues.put("jobs", jobs);

        Building building = BuildingFactory
                .createBuilding("Illovo", address/*, buildingValues*/);
        repository.save(building);
        System.out.println("I am working");
        for( Building b : repository.findAll() ) {
            System.out.println(b.getBuilding_name());
        }
        Assert.assertNotNull(building.getBuilding_id());
                
    }
    
}
