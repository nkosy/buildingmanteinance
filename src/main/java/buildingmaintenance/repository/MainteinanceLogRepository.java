package buildingmaintenance.repository;

import buildingmaintenance.domain.MantainanceLog;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nkosy on 2015/05/06.
 */
public interface MainteinanceLogRepository extends CrudRepository<MantainanceLog, Long> {
}
