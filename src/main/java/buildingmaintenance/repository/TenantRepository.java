package buildingmaintenance.repository;

import buildingmaintenance.domain.Tenant;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nkosy on 2015/05/06.
 */
public interface TenantRepository extends CrudRepository<Tenant, Long> {
}
