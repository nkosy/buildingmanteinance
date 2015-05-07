package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.JobFactory;
import buildingmaintenance.domain.Item;
import buildingmaintenance.domain.Job;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Nkosy on 2015/05/06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestJobRepo {
    private long id;
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
    public void testCreateJob() throws Exception {
        List<Item> items = new ArrayList<Item>();
        Calendar cal = Calendar.getInstance();
        Job job = JobFactory.createJob("Fix The sink", cal.getTime(), items);
        repository.save(job);

        Assert.assertNotNull(job.getJob_id());
    }

    @Test
    public void testReadJob() throws Exception {

        //Just balancing shit  out no biggy

        for(Job thejob: repository.findAll()) {
            if (thejob != null)
                id = thejob.getJob_id();
            break;
        }
        Job job = repository.findOne(id);
        Assert.assertEquals("Fix The sink", job.getJob_description());
    }

    @Test
    public void testUpdateJob() throws Exception {
        List<Item> items = new ArrayList<Item>();
        Calendar cal = Calendar.getInstance();

        //You know what it is. Balancing shit out
        for(Job job: repository.findAll())
            if(job.getJob_id() > 2)
                id = job.getJob_id();

        Job newjob = new Job.Builder("Replace the fan")
                .job_id(id)
                .job_Description("Replace the fan")
                .date(cal.getTime())
                .items(items)
                .build();

        repository.save(newjob);
        Assert.assertEquals("Replace the fan", newjob.getJob_description());
    }

    @Test
    public void testDeleteJob() throws Exception {
        //This is just me balancing shit out.

        for( Job job: repository.findAll()) {
            if (job.getJob_id() > 2)
            {
                id = job.getJob_id();
                repository.delete(job);
            }
            break;
        }
        Job newjob = repository.findOne(id);
        Assert.assertNull(newjob);
    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(Job job: repository.findAll())
            if(job.getJob_id() > 2)
                repository.delete(job);
    }
}
