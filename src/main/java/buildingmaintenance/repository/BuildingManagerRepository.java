package buildingmaintenance.repository;


import buildingmaintenance.domain.BuildingManager;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nkosy on 2015/05/03.
 */
public interface BuildingManagerRepository extends CrudRepository<BuildingManager, Long> {
    public BuildingManager findByManagerID(Long manager_id);
}
