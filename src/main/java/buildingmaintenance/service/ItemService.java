package buildingmaintenance.service;

import buildingmaintenance.domain.Item;

import java.util.Date;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
public interface ItemService {
    List<Item> getAllItems();
    Item getItemByID(Long id);
    List<Item> getItemByCost(double cost);
    List<Item> getItemByLastMantainedDate(Date date);
}
