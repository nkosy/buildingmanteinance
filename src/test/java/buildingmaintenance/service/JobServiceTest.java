package buildingmaintenance.service;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.JobFactory;
import buildingmaintenance.domain.Item;
import buildingmaintenance.domain.Job;
import buildingmaintenance.repository.JobRepository;
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
public class JobServiceTest {
    @Autowired
    private JobService service;

    @Autowired
    private JobRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(Job thejob: repository.findAll())
            if(thejob != null)
                found = true;
        if(found == false) {
            List<Item> items = new ArrayList<Item>();
            Calendar cal = Calendar.getInstance();
            Job job = JobFactory.createJob("Fix The sink", cal.getTime(), items);
            repository.save(job);
            repository.save(job);
        }
    }

    @Test
    public void testGetAllJobs() throws Exception {
//        List<Job> jobList = service.getAllJobs();
//        Assert.assertTrue(jobList.size() >= 2);
    }

    @Test
    public void testGetJobByID() throws Exception {
//        Job jobs = service.getJobByID((long)1);
//        Assert.assertEquals("Fix The sink", jobs.getJob_description());
    }

    @Test
    public void testGetJobByDate() throws Exception {
        //Balancing shit out as usual
//        Job thejob = service.getJobByID((long)1);
//
//        List<Job> logs = service.getLogsByDate(thejob.getDate());
//        Assert.assertNotNull(logs);
    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(Job job: repository.findAll())
            if(job.getJob_id() > 2)
                repository.delete(job);
    }
}
