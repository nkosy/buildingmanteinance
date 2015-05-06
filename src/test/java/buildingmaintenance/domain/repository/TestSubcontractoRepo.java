package buildingmaintenance.domain.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.SubcontractorFactory;
import buildingmaintenance.conf.factory.SubcontractorManagerFactory;
import buildingmaintenance.domain.BuildingManager;
import buildingmaintenance.domain.Job;
import buildingmaintenance.domain.Subcontractor;
import buildingmaintenance.domain.SubcontractorManager;
import buildingmaintenance.repository.BuildingManagerRepository;
import buildingmaintenance.repository.BuildingRepository;
import buildingmaintenance.repository.LevelRepository;
import buildingmaintenance.repository.SubcontractorRepository;
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
public class TestSubcontractoRepo {
    private long id;
    @Autowired
    private SubcontractorRepository repository;
    @Autowired
    private BuildingManagerRepository managerRepository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(Subcontractor sub: repository.findAll())
            if(sub != null)
                found = true;
        if(found == false) {
            List<Job> jobs = new ArrayList<Job>();
            SubcontractorManager manager = SubcontractorManagerFactory.createManager("John");
            Subcontractor subcontractor = SubcontractorFactory.createSubcontractor("ABC-Electrical",
                    manager, jobs);

            repository.save(subcontractor);
            repository.save(subcontractor);
        }
    }

    @Test
    public void testCreate() throws Exception {
        List<Job> jobs = new ArrayList<Job>();
        SubcontractorManager manager = SubcontractorManagerFactory.createManager("John");
        Subcontractor subcontractor = SubcontractorFactory.createSubcontractor("ABC-Electrical",
                manager, jobs);

        repository.save(subcontractor);
        Assert.assertNotNull(subcontractor.getSubcontractor_id());
    }



    @After
    public void tearDown() throws Exception {

        //This is just me balancing shit out.
        for(Subcontractor sub: repository.findAll())
            if(sub.getSubcontractor_id() > 2)
                repository.delete(sub);

    }
}