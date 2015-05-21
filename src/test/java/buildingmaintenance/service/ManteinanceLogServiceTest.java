package buildingmaintenance.service;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.MantainanceLogFactory;
import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.Item;
import buildingmaintenance.domain.MantainanceLog;
import buildingmaintenance.repository.BuildingRepository;
import buildingmaintenance.repository.MainteinanceLogRepository;
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
 * Created by nkosi on 2015/05/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class ManteinanceLogServiceTest {
    @Autowired
    private ManteinanceLogService service;

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
    public void testGetAllLogs() throws Exception {
        List<MantainanceLog> logList = service.getAllLogs();
        Assert.assertTrue(logList.size() >= 2);
    }

    @Test
    public void testGetLogyID() throws Exception {
        MantainanceLog log = service.getLogyID((long)1);
        Assert.assertEquals("Light Switch Not working", log.getDescription());

    }

    @Test
    public void testGetLogsByDate() throws Exception {
        //Balancing shit out as usual
        MantainanceLog thelog = service.getLogyID((long)1);

        List<MantainanceLog> logs = service.getLogsByDate(thelog.getLogDate());
        Assert.assertNotNull(logs);

    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(MantainanceLog log: repository.findAll())
            if(log.getMantainanceLog_id() > 2)
                repository.delete(log);
    }
}
