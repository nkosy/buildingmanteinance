package buildingmaintenance.service;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.TenantFactory;
import buildingmaintenance.domain.MantainanceLog;
import buildingmaintenance.domain.OfficeSpace;
import buildingmaintenance.domain.Tenant;
import buildingmaintenance.repository.TenantRepository;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nkosi on 2015/05/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TenantServiceTest {
    @Autowired
    private TenantService service;

    @Autowired
    private TenantRepository repository;

    @Before
    public void setUp() throws Exception {
        //This is just me balancing shit out
        boolean found = false;
        for(Tenant thetenant: repository.findAll())
            if(thetenant != null)
                found = true;
        if(found == false) {
            List<OfficeSpace> officespaces = new ArrayList<OfficeSpace>();
            List<MantainanceLog> logs = new ArrayList<MantainanceLog>();

            Map<String, List> tenantValues = new HashMap<String, List>();

            tenantValues.put("officeSpaces", officespaces);
            tenantValues.put("logs", logs);

            Tenant tenant = TenantFactory.createTenant("MTN", tenantValues);

            repository.save(tenant);
            repository.save(tenant);
        }

    }

    @Test
    public void testGetAllTenants() throws Exception {
//        List<Tenant> tenantList = service.getAllTenants();
//        Assert.assertTrue(tenantList.size() >= 2);

    }

    @Test
    public void testGetTenantByID() throws Exception {
//        Tenant tenant = service.getTenantByID((long) 1);
//        Assert.assertEquals("MTN", tenant.getTenant_name());
    }

    @Test
    public void testGetTenantByName() throws Exception {
//        Tenant tenant = service.getTenantByName("MTN");
//        Assert.assertNotNull(tenant);
    }

    @After
    public void tearDown() throws Exception {
        //This is just me balancing shit out.
        for(Tenant tenant: repository.findAll())
            if(tenant.getTenant_id() > 2)
                repository.delete(tenant);
    }
}
