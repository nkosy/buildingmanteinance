package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.Address;
import buildingmaintenance.domain.Building;

import java.util.List;
import java.util.Map;


/**
 *
 * @author Nkosy
 */
public class BuildingFactory {

    public static Building createBuilding(String name,
            Address address, Map<String, List> values) {
        Building building = new Building.Builder(name)
                .building_address(address)
                .jobs(values.get("jobs"))
                .levels(values.get("levels"))
                .build();
        return building;

    }
}
