package buildingmaintenance.repository;

import buildingmaintenance.domain.Job;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nkosy on 2015/05/06.
 */
public interface JobRepository extends CrudRepository<Job, Long>{
}
