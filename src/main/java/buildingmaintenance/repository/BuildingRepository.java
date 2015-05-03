
package buildingmaintenance.repository;


import buildingmaintenance.domain.Building;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Nkosy
 */
public interface BuildingRepository extends CrudRepository<Building, Long> {
    public Building findByBuildingID(Long buildingID);
}
