package buildingmaintenance.repository;

import buildingmaintenance.BuildingmaintenanceApplication;
import buildingmaintenance.conf.factory.TenantFactory;
import buildingmaintenance.domain.MantainanceLog;
import buildingmaintenance.domain.OfficeSpace;
import buildingmaintenance.domain.Tenant;
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
 * Created by Nkosy on 2015/05/06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BuildingmaintenanceApplication.class)
@WebAppConfiguration
public class TestTenantRepo {
    private long id;
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
    public void testCreateTenant() throws Exception {
        List<OfficeSpace> officespaces = new ArrayList<OfficeSpace>();
        List<MantainanceLog> logs = new ArrayList<MantainanceLog>();

        Map<String, List> tenantValues = new HashMap<String, List>();

        tenantValues.put("officeSpaces", officespaces);
        tenantValues.put("logs", logs);

        Tenant tenant = TenantFactory.createTenant("MTN", tenantValues);

        repository.save(tenant);
        Assert.assertNotNull(tenant.getTenant_id());
    }

    @Test
    public void testReadTenant() throws Exception {

        //Just balancing shit  out no biggy

        for(Tenant tenant: repository.findAll()) {
            if (tenant != null)
                id = tenant.getTenant_id();
            break;
        }
        Tenant tenant = repository.findOne(id);
        Assert.assertEquals("MTN", tenant.getTenant_name());
    }

    @Test
    public void testUpdateTenant() throws Exception {
        List<OfficeSpace> officespaces = new ArrayList<OfficeSpace>();
        List<MantainanceLog> logs = new ArrayList<MantainanceLog>();

        //You know what it is. Balancing shit out
        for(Tenant thetenant: repository.findAll())
            if(thetenant.getTenant_id() > 2)
                id = thetenant.getTenant_id();

        Tenant newtenant = new Tenant.Builder("Cell C")
                .tenantId(id)
                .tenant_name("Cell C")
                .officeSpaces(officespaces)
                .logs(logs)
                .build();

        repository.save(newtenant);
        Assert.assertEquals("Cell C", newtenant.getTenant_name());
    }

    @Test
    public void testDeleteTenant() throws Exception {
        //This is just me balancing shit out.

        for( Tenant tenant: repository.findAll()) {
            if (tenant.getTenant_id() > 2)
            {
                id = tenant.getTenant_id();
                repository.delete(tenant);
            }
            break;
        }
        Tenant newtenant = repository.findOne(id);
        Assert.assertNull(newtenant);
    }

    @After
    public void tearDown() throws Exception {

        //This is just me balancing shit out.
        for(Tenant tenant: repository.findAll())
            if(tenant.getTenant_id() > 2)
                repository.delete(tenant);

    }


}
