package buildingmaintenance.repository;

import buildingmaintenance.domain.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nkosy on 2015/05/07.
 */
public interface ItemRepository extends CrudRepository<Item, Long> {
}
