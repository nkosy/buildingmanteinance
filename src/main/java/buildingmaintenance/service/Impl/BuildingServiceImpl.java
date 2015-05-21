package buildingmaintenance.service.Impl;

import buildingmaintenance.domain.Building;
import buildingmaintenance.repository.BuildingRepository;
import buildingmaintenance.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2015/05/19.
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    BuildingRepository repository;

    public List<Building> getAllBuildings() {
        List<Building> buildings = new ArrayList<Building>();
        Iterable<Building> values = repository.findAll();
        for (Building value : values) {
            buildings.add(value);
        }
        return buildings;
    }

    @Override
    public Building getBuildingByID(Long id) {
        if(repository.findOne(id) == null)
            return null;
        else
            return repository.findOne(id);
    }

    @Override
    public Building getBuildingByName(String name) {
        List<Building> buildings = new ArrayList<Building>();
        Building result = null;
        buildings = getAllBuildings();
        for(Building thebuilding: buildings)
        {
            if(thebuilding.getBuilding_name().contains(name))
            {
                result = thebuilding;
            }
            break;
        }
        if(result == null)
            System.out.println("Found Nothing!");
        return result;
    }
}
