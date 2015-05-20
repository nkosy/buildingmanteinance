package buildingmaintenance.services.Impl;

import buildingmaintenance.domain.Building;
import buildingmaintenance.repository.BuildingRepository;
import buildingmaintenance.services.BuildingService;
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

}
