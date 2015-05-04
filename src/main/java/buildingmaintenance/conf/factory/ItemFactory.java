package buildingmaintenance.conf.factory;

import buildingmaintenance.domain.Item;

import java.util.Date;

/**
 *
 * @author Nkosy
 */
public class ItemFactory {
    public static Item createItem(String itemName,
            double cost,
            Date lastMantained){
        Item item = new Item.Builder(itemName)
                .cost(cost)
                .last_mantained(lastMantained)
                .build();                
        return item;
    }
}
