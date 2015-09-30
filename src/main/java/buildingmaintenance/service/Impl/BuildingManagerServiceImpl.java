package buildingmaintenance.service.Impl;

import buildingmaintenance.conf.factory.BuildingManagerFactory;
import buildingmaintenance.domain.Building;
import buildingmaintenance.domain.BuildingManager;
import buildingmaintenance.model.BuildingManagerResource;
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
    public BuildingManager findById(Long id) {
        if(repository.findOne(id) == null)
            return null;
        else
            return repository.findOne(id);
    }

    @Override
    public BuildingManager findByName(String name) {
        List<BuildingManager> managers = new ArrayList<>();
        BuildingManager result = null;
        managers = findAll();
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

    @Override
    public BuildingManager save(BuildingManager entity) {
        return repository.save(entity);
    }

    @Override
    public BuildingManager update(BuildingManager entity) {
        return null;
    }

    @Override
    public void delete(BuildingManager entity) {

    }

    @Override
    public List findAll() {
        List<BuildingManager> managers = new ArrayList<>();
        Iterable<BuildingManager> values = repository.findAll();
        for (BuildingManager value : values) {
            managers.add(value);
        }
        return managers;
    }
}
