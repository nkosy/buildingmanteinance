package buildingmaintenance.repository;

import buildingmaintenance.domain.Facility;
import buildingmaintenance.domain.Job;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nkosy on 2015/05/04.
 */
public interface FacilityRepository extends CrudRepository<Facility, Long> {
}
