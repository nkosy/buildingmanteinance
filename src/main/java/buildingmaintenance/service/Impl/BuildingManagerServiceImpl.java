package buildingmaintenance.service.Impl;

import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.BuildingManager;
import buildingmaintenance.repository.BuildingManagerRepository;
import buildingmaintenance.service.BuildingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
@Service
public class BuildingManagerServiceImpl implements BuildingManagerService{
    @Autowired
    BuildingManagerRepository repository;

    @Override
    public List<BuildingManager> getAllManagers() {
        List<BuildingManager> managers = new ArrayList<>();
        Iterable<BuildingManager> values = repository.findAll();
        for (BuildingManager value : values) {
            managers.add(value);
        }
        return managers;
    }

    @Override
    public BuildingManager getManagerByID(Long id) {
        if(repository.findOne(id) == null)
            return null;
        else
            return repository.findOne(id);
    }

    @Override
    public BuildingManager getManagerByName(String name) {
        List<BuildingManager> managers = new ArrayList<>();
        BuildingManager result = null;
        managers = getAllManagers();
        for(BuildingManager themanager: managers)
        {
            if(themanager.getManager_name().contains(name))
            {
                result = themanager;
            }
            break;
        }
        if(result == null)
            System.out.println("Found Nothing!");
        return result;
    }
}
