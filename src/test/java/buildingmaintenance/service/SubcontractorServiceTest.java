package buildingmaintenance.service;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.SubcontractorFactory;
import buildingmaintenance.conf.factory.SubcontractorManagerFactory;
import buildingmaintenance.domain.Job;
import buildingmaintenance.domain.Subcontractor;
import buildingmaintenance.domain.SubcontractorManager;
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
 * Created by nkosi on 2015/05/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class SubcontractorServiceTest {
    @Autowired
    private SubcontractorService service;

    @Autowired
    private SubcontractorRepository repository;

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
    public void testGetAllSubcontractors() throws Exception {
        List<Subcontractor> subcontractorList = service.getAllSubcontractors();
        Assert.assertTrue(subcontractorList.size() >= 2);
    }

    @Test
    public void testGetSubcontractorByID() throws Exception {
        Subcontractor subcontractor = service.getSubcontractorByID((long)1);
        Assert.assertEquals("ABC-Electrical", subcontractor.getSubcontractor_name());
    }

    @Test
    public void testGetSubcontractorByName() throws Exception {
        Subcontractor subcontractor = service.getSubcontractorByName("ABC-Electrical");
        Assert.assertNotNull(subcontractor);

    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(Subcontractor sub: repository.findAll())
            if(sub.getSubcontractor_id() > 2)
                repository.delete(sub);
    }
}
