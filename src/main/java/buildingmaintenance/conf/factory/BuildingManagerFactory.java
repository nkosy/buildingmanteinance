package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.BuildingManager;

import java.util.List;

/**
 *
 * @author Nkosy
 */
public class BuildingManagerFactory {
    public static BuildingManager createBuildingManager(String managerName,
            List buildings){
        BuildingManager buildingManager = new BuildingManager.Builder(managerName)
                .buildings(buildings)
                .build();
        return buildingManager;
    }
}
