package buildingmaintenance.service;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.ItemFactory;
import buildingmaintenance.domain.Item;
import buildingmaintenance.repository.ItemRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Calendar;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class ItemServiceTest {
    @Autowired
    private ItemService service;

    @Autowired
    private ItemRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(Item theitem: repository.findAll())
            if(theitem != null)
                found = true;
        if(found == false) {
            Calendar cal = Calendar.getInstance();
            Item item = ItemFactory.createItem("Sink", (double) 800, cal.getTime());
            System.out.println("This is the cost that I am persisting " + item.getCost());

            repository.save(item);
            repository.save(item);
        }
    }

    @Test
    public void testGetAllItems() throws Exception {
        List<Item> itemList = service.getAllItems();
        Assert.assertTrue(itemList.size() >= 2);
    }

    @Test
    public void testGetItemByID() throws Exception {
        Item item = service.getItemByID((long) 1);
        Assert.assertEquals("Sink", item.getItem_name());
    }

    @Test
    public void testGetItemByLastMantainedDate() throws Exception {
        //Balancing shit out as usual
        Item theitem = service.getItemByID((long)1);

        List<Item> items = service.getItemByLastMantainedDate(theitem.getLast_mantained());
        Assert.assertNotNull(items);
    }

    @Test
    public void testGetItemByCost() throws Exception {
        List<Item> items = service.getItemByCost(800.00);
        Assert.assertNotNull(items);
    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(Item item: repository.findAll())
            if(item.getItem_id() > 2)
                repository.delete(item);
    }
}
