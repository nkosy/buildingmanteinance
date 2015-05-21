package buildingmaintenance.service.Impl;

import buildingmaintenance.domain.Job;
import buildingmaintenance.repository.JobRepository;
import buildingmaintenance.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository repository;

    @Override
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<Job>();
        Iterable<Job> values = repository.findAll();
        for (Job value : values) {
            jobs.add(value);
        }
        return jobs;
    }

    @Override
    public Job getJobByID(Long id) {
        if(repository.findOne(id) == null)
            return null;
        else
            return repository.findOne(id);
    }

    @Override
    public List<Job> getLogsByDate(Date date) {
        List<Job> jobs = new ArrayList<>();
        List<Job> result = new ArrayList<>();
        jobs = getAllJobs();
        for(Job thejob: jobs)
        {
            if(thejob.getDate() == date)
            {
                result.add(thejob);
            }
        }
        if(result == null)
            System.out.println("Found Nothing!");
        return result;
    }
}
