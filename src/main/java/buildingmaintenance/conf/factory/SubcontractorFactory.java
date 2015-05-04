package buildingmaintenance.conf.factory;

import buildingmaintenance.domain.Subcontractor;

import java.util.List;

/**
 *
 * @author Nkosy
 */
public class SubcontractorFactory {
    public static Subcontractor createSubcontractor(String name,
            long subcontractorManager_id,
            List jobs){
        Subcontractor subcontractor = new Subcontractor.Builder(name)
                .subcontractorManager_id(subcontractorManager_id)
                .jobs(jobs)
                .build();
        return subcontractor;
    }
}
