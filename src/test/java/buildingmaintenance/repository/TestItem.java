package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.ItemFactory;
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
import java.util.Calendar;
import java.util.List;

/**
 * Created by Nkosy on 2015/05/07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestItem {
    private long id;
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
    public void testCreateItem() throws Exception {
        Calendar cal = Calendar.getInstance();
        Item item = ItemFactory.createItem("Sink", (double) 800, cal.getTime());

        repository.save(item);
        Assert.assertNotNull(item.getItem_id());
    }

    @Test
    public void testReadItem() throws Exception {

        //Just balancing shit  out no biggy
        for(Item item: repository.findAll()) {
            if (item != null)
                id = item.getItem_id();
            break;
        }
        Item item = repository.findOne(id);
        Assert.assertEquals("Sink", item.getItem_name());
    }

    @Test
    public void testUpdateItem() throws Exception {
        Calendar cal = Calendar.getInstance();

        //You know what it is. Balancing shit out
        for(Item theitem: repository.findAll())
            if(theitem.getItem_id() > 2)
                id = theitem.getItem_id();

        Item newitem = new Item.Builder("Light bulb")
                .item_id(id)
                .cost((double)600)
                .last_mantained(cal.getTime())
                .build();

        repository.save(newitem);
        Assert.assertEquals("Light bulb", newitem.getItem_name());
    }

    @Test
    public void testDeleteItem() throws Exception {
        //This is just me balancing shit out.

        for( Item item: repository.findAll()) {
            if (item.getItem_id() > 2)
            {
                id = item.getItem_id();
                repository.delete(item);
            }
            break;
        }
        Item newItem = repository.findOne(id);
        Assert.assertNull(newItem);
    }

    @After
    public void tearDown() throws Exception {

        //This is just me balancing shit out.
        for(Item item: repository.findAll())
            if(item.getItem_id() > 2)
                repository.delete(item);

    }

}
