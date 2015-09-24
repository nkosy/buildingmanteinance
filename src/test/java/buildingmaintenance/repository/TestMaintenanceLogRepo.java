package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.MantainanceLogFactory;
import buildingmaintenance.domain.Item;
import buildingmaintenance.domain.MantainanceLog;
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
 * Created by Nkosy on 2015/05/06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestMaintenanceLogRepo {
    private long id;
    @Autowired
    private MainteinanceLogRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(MantainanceLog log: repository.findAll())
            if(log != null)
                found = true;
        if(found == false) {
            List<Item> items = new ArrayList<Item>();
            Calendar cal = Calendar.getInstance();
            MantainanceLog thelog = MantainanceLogFactory.createMantainanceLog("Light Switch Not working",
                    cal.getTime(), items);
            repository.save(thelog);
            repository.save(thelog);
        }
    }

    @Test
    public void testCreateLog() throws Exception {
//        List<Item> items = new ArrayList<Item>();
//        Calendar cal = Calendar.getInstance();
//        MantainanceLog thelog = MantainanceLogFactory.createMantainanceLog("Light Switch Not working",
//                cal.getTime(), items);
//        repository.save(thelog);
//
//        Assert.assertNotNull(thelog.getMantainanceLog_id());
    }

    @Test
    public void testReadLog() throws Exception {

        //Just balancing shit  out no biggy
//        for(MantainanceLog thelog: repository.findAll()) {
//            if (thelog != null)
//                id = thelog.getMantainanceLog_id();
//            break;
//        }
//        MantainanceLog log = repository.findOne(id);
//        Assert.assertEquals("Light Switch Not working", log.getDescription());
    }

    @Test
    public void testUpdateLevel() throws Exception {
        List<Item> items = new ArrayList<Item>();

        //You know what it is. Balancing shit out
//        for(MantainanceLog log: repository.findAll())
//            if(log.getMantainanceLog_id() > 2)
//                id = log.getMantainanceLog_id();
//
//        MantainanceLog newlog = new MantainanceLog.Builder("Fan went quite")
//                .description("Fan went quite")
//                .items(items)
//                .build();
//
//        repository.save(newlog);
//        Assert.assertEquals("Fan went quite", newlog.getDescription());
    }

    @Test
    public void testDeleteBuilding() throws Exception {
        //This is just me balancing shit out.
//
//        for( MantainanceLog log: repository.findAll()) {
//            if (log.getMantainanceLog_id() > 2)
//            {
//                id = log.getMantainanceLog_id();
//                repository.delete(log);
//            }
//            break;
//        }
//        MantainanceLog newlog = repository.findOne(id);
//        Assert.assertNull(newlog);
    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(MantainanceLog log: repository.findAll())
            if(log.getMantainanceLog_id() > 2)
                repository.delete(log);
    }

}
