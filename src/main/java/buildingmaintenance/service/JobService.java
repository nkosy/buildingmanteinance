package buildingmaintenance.service;

import buildingmaintenance.domain.Job;

import java.util.Date;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
public interface JobService {
    List<Job> getAllJobs();
    Job getJobByID(Long id);
    List<Job> getLogsByDate(Date date);
}
