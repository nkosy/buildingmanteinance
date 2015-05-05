package buildingmaintenance.conf.factory;

import buildingmaintenance.domain.Subcontractor;
import buildingmaintenance.domain.SubcontractorManager;

import java.util.List;

/**
 *
 * @author Nkosy
 */
public class SubcontractorFactory {
    public static Subcontractor createSubcontractor(String name,
            SubcontractorManager subcontractorManager,
            List jobs){
        Subcontractor subcontractor = new Subcontractor.Builder(name)
                .subcontractorManager(subcontractorManager)
                .jobs(jobs)
                .build();
        return subcontractor;
    }
}
