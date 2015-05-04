package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.Job;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nkosy
 */
public class JobFactory {
    public static Job createJob(String description,
            Date date,
            List items){
        Job job = new Job.Builder(description)
                .date(date)
                .items(items)
                .build();
        return job;
    }
}
