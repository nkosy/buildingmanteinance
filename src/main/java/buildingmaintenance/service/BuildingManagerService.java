package buildingmaintenance.service;

import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.BuildingManager;

import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
public interface BuildingManagerService {
    List<BuildingManager> getAllManagers();
    BuildingManager getManagerByID(Long id);
    BuildingManager getManagerByName(String name);
}
