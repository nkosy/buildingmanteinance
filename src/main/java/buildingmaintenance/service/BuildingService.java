package buildingmaintenance.service;

import buildingmaintenance.domain.Building;

import java.util.List;

/**
 * Created by nkosi on 2015/05/19.
 */
public interface BuildingService {
     List<Building> getAllBuildings();
     Building getBuildingByID(Long id);
     Building getBuildingByName(String name);
}
