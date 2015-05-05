package buildingmaintenance.domain;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import buildingmaintenance.conf.factory.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Nkosy
 */
public class BuildingMaintenanceTestSuite {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateBuilding() throws Exception {
        Map<String, String> addressValues = new HashMap<String, String>();

        addressValues.put("streetName", "Dorset");
        addressValues.put("city", "Cape Town");
        Address address = AddressFactory.createAddress(123, 10, addressValues);

        List<Job> jobs = new ArrayList<Job>();
        List<Level> levels = new ArrayList<Level>();
        Map<String, List> buildingValues = new HashMap<String, List>();

        buildingValues.put("levels", levels);
        buildingValues.put("jobs", jobs);

        Building building = BuildingFactory
                .createBuilding("NMJ", address, buildingValues);

        Assert.assertEquals("NMJ", building.getBuilding_name());
    }

    @Test
    public void testUpdateBuilding() throws Exception {
        Map<String, String> addressValues = new HashMap<String, String>();

        addressValues.put("streetName", "Dorset");
        addressValues.put("city", "Cape Town");
        Address address = AddressFactory.createAddress(123, 10, addressValues);

        List<Job> jobs = new ArrayList<Job>();
        List<Level> levels = new ArrayList<Level>();
        Map<String, List> buildingValues = new HashMap<String, List>();

        buildingValues.put("levels", levels);
        buildingValues.put("jobs", jobs);

        Building building = BuildingFactory
                .createBuilding("NMJ", address, buildingValues);

        //Update variables
        Map<String, String> newaddressValues = new HashMap<String, String>();

        newaddressValues.put("streetName", "Sir Lowry");
        newaddressValues.put("city", "Johannesburg");
        Address newaddress = AddressFactory.createAddress(1856, 10, newaddressValues);

        Building newbuilding = new Building.Builder(building.getBuilding_name())
                .copy(building)
                .building_address(newaddress)
                .build();

        Assert.assertEquals("NMJ", newbuilding.getBuilding_name());
        Assert.assertEquals("Sir Lowry", newbuilding.getBuilding_address().getStreet_name());
    }

    @Test
    public void testCreateBuildingManager() throws Exception {
        List<Building> buildings = new ArrayList<Building>();
        BuildingManager buildingManager = BuildingManagerFactory
                .createBuildingManager("lil Wayne", buildings);

        Assert.assertEquals("lil Wayne", buildingManager.getManager_name());
    }

    @Test
    public void testUpdateBuildingManager() throws Exception {
        List<Building> buildings = new ArrayList<Building>();
        BuildingManager buildingManager = BuildingManagerFactory
                .createBuildingManager("lil Wayne", buildings);

        Assert.assertEquals("lil Wayne", buildingManager.getManager_name());

        //updating the variables
        BuildingManager newManager = new BuildingManager.Builder(buildingManager.getManager_name())
                .copy(buildingManager)
                .manager_name("Rick Ross")
                .build();
        Assert.assertEquals("Rick Ross", newManager.getManager_name());
    }

    @Test
    public void testCreateFacility() throws Exception {
        List<Item> items = new ArrayList<Item>();
        Facility facility = FacilityFactory
                .createFacility("Kitchen", items);
        Assert.assertEquals("Kitchen", facility.getFacility_name());
    }

    @Test
    public void testUpdateFacility() throws Exception {
        List<Item> items = new ArrayList<Item>();
        Facility facility = FacilityFactory
                .createFacility("Kitchen", items);
        Assert.assertEquals("Kitchen", facility.getFacility_name());

        //updating the variables
        Facility newFacility = new Facility.Builder(facility.getFacility_name())
                .copy(facility)
                .facilty_name("Board Room")
                .build();
        Assert.assertEquals("Board Room", newFacility.getFacility_name());

    }

    @Test
    public void testCreateItem() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));

        Item item = ItemFactory.createItem("Sink", 800.00, cal.getTime());
        Assert.assertEquals(cal.getTime(), item.getLast_mantained());
    }

    @Test
    public void testUpdateItem() throws Exception {

        Calendar cal = Calendar.getInstance();
        Item item = ItemFactory.createItem("Sink", 800.00, cal.getTime());
        Assert.assertEquals(cal.getTime(), item.getLast_mantained());

        //updating variables
        cal.set(2015, 04, 03);
        Item newItem = new Item.Builder(item.getItem_name())
                .copy(item)
                .cost(900.00)
                .last_mantained(cal.getTime())
                .build();
        Assert.assertEquals(cal.getTime(), newItem.getLast_mantained());

    }

    @Test
    public void testCreateJob() throws Exception {
        List<Item> items = new ArrayList<Item>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Job job = JobFactory.createJob("Fix The sink", cal.getTime(), items);

        Assert.assertEquals("Fix The sink", job.getJob_description());

    }

    @Test
    public void testUpdateJob() throws Exception {
        List<Item> items = new ArrayList<Item>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        Job job = JobFactory.createJob("Fix The sink", cal.getTime(), items);

        //updating variables
        Job newJob = new Job.Builder(job.getJob_description())
                .copy(job)
                .job_Description("Light switch")
                .build();
        Assert.assertEquals("Light switch", newJob.getJob_description());
    }

    @Test
    public void createlevel() throws Exception {
        List<OfficeSpace> officeSpaces = new ArrayList<OfficeSpace>();
        Level level = LevelFactory.createLevel("Ground Floor", officeSpaces);

        Assert.assertEquals("Ground Floor", level.getLevel_name());
    }

    @Test
    public void Updatelevel() throws Exception {
        List<OfficeSpace> officeSpaces = new ArrayList<OfficeSpace>();
        Level level = LevelFactory.createLevel("Ground Floor", officeSpaces);

        //Updating Variables
        Level newLevel = new Level.Builder(level.getLevel_name())
                .copy(level)
                .level_name("First Floor")
                .build();
        Assert.assertEquals("First Floor", newLevel.getLevel_name());
    }

    @Test
    public void createMantainaceLog() throws Exception {
        List<Item> items = new ArrayList<Item>();
        MantainanceLog log = MantainanceLogFactory.createMantainanceLog("Light Switch Not working",
                items);
        Assert.assertEquals("Light Switch Not working", log.getDescription());
    }

    @Test
    public void updateMantainaceLog() throws Exception {
        List<Item> items = new ArrayList<Item>();
        MantainanceLog log = MantainanceLogFactory.createMantainanceLog("Light Switch Not working",
                items);

        //Updating variables
        MantainanceLog newlog = new MantainanceLog.Builder(log.getDescription())
                .copy(log)
                .description("Door handle not working")
                .build();
        Assert.assertEquals("Door handle not working", newlog.getDescription());
    }

    @Test
    public void createOfficeSpace() throws Exception {
        List<Facility> facilities = new ArrayList<Facility>();
        OfficeSpace officespace = OfficeSpaceFactory.createOfficeSpace(1, facilities);
        Assert.assertEquals(1, officespace.getOfficeSpace_no());

    }

    @Test
    public void updateOfficeSpace() throws Exception {
        List<Facility> facilities = new ArrayList<Facility>();
        OfficeSpace officespace = OfficeSpaceFactory.createOfficeSpace(1, facilities);
        Assert.assertEquals(1, officespace.getOfficeSpace_no());

        //Updating Variables
        OfficeSpace newofficespace = new OfficeSpace.Builder(officespace.getOfficeSpace_no())
                .copy(officespace)
                .officeSpace_no(2)
                .build();

        Assert.assertEquals(2, newofficespace.getOfficeSpace_no());
    }

    @Test
    public void createSubcontractor() throws Exception {
        List<Job> jobs = new ArrayList<Job>();
        SubcontractorManager manager = SubcontractorManagerFactory.createManager("John");
        Subcontractor subcontractor = SubcontractorFactory.createSubcontractor("ABC-Electrical",
                manager, jobs);
        Assert.assertEquals("ABC-Electrical", subcontractor.getSubcontractor_name());
    }

    @Test
    public void updateSubcontractor() throws Exception {
        List<Job> jobs = new ArrayList<Job>();
        SubcontractorManager manager = SubcontractorManagerFactory.createManager("John");
        Subcontractor subcontractor = SubcontractorFactory.createSubcontractor("ABC-Electrical",
                manager, jobs);
        Assert.assertEquals("ABC-Electrical", subcontractor.getSubcontractor_name());

        //updating variables
        Subcontractor newsubcontractor = new Subcontractor.Builder(subcontractor.getSubcontractor_name())
                .copy(subcontractor)
                .subcontractor_name("Plumbers")
                .build();
        Assert.assertEquals("Plumbers", newsubcontractor.getSubcontractor_name());

    }

    @Test
    public void createSubcontractorManager() throws Exception {
        SubcontractorManager manager = SubcontractorManagerFactory.createManager("John");
        Assert.assertEquals("John", manager.getSubcontractorManager_name());
    }

    @Test
    public void updateSubcontractorManager() throws Exception {
        SubcontractorManager manager = SubcontractorManagerFactory.createManager("John");
        Assert.assertEquals("John", manager.getSubcontractorManager_name());

        //updating variables
        SubcontractorManager newmanager = new SubcontractorManager.Builder(manager.getSubcontractorManager_name())
                .copy(manager)
                .subcontractorManager_name("Mike")
                .build();
        Assert.assertEquals("Mike", newmanager.getSubcontractorManager_name());
    }

    @Test
    public void createTenant() throws Exception {
        List<OfficeSpace> officespaces = new ArrayList<OfficeSpace>();
        Tenant tenant = TenantFactory.createTenant("MTN", officespaces);
        Assert.assertEquals("MTN", tenant.getTenant_name());

    }

    @Test
    public void updateTenant() throws Exception {
        List<OfficeSpace> officespaces = new ArrayList<OfficeSpace>();
        Tenant tenant = TenantFactory.createTenant("MTN", officespaces);

        //Updating variables
        Tenant newtenant = new Tenant.Builder(tenant.getTenant_name())
                .copy(tenant)
                .tenant_name("Vodacom")
                .build();
        Assert.assertEquals("Vodacom", newtenant.getTenant_name());
    }

    @After
    public void tearDown() throws Exception {
    }

}
