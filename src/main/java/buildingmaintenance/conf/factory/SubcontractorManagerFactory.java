package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.SubcontractorManager;

/**
 *
 * @author Nkosy
 */
public class SubcontractorManagerFactory {
    public static SubcontractorManager createManager(String name){
        SubcontractorManager manager = new SubcontractorManager.Builder(name)
                .build();
        return manager;
    }
}
