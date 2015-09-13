package buildingmaintenance.api;

import buildingmaintenance.domain.BuildingManager;
import buildingmaintenance.model.BuildingManagerResource;
import buildingmaintenance.service.BuildingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
@RestController
@RequestMapping("/api/**")
public class BuildingManagerPage {
    @Autowired
    private BuildingManagerService service;

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public List<BuildingManagerResource> getManagers(){

        List<BuildingManagerResource> hateos = new ArrayList<>();
        List<BuildingManager> managers = service.getAllManagers();

        for (BuildingManager manager : managers) {
            BuildingManagerResource res = new BuildingManagerResource
                    .Builder(manager.getManager_name())
                    .resID(manager.getManager_id())
                    .buildings(manager.getBuildings())
                    .build();
            Link buildings = new
                    Link("http://localhost:8080/manager/"+res.getResID())
                    .withRel("buildings");

            res.add(buildings);
            hateos.add(res);
        }
        return hateos;
    }

    @RequestMapping(value = "/managerids", method = RequestMethod.GET)
    public List<BuildingManagerResource>  getManagerByID(
            @RequestParam(value =  "id", defaultValue = "1") Long id){

        BuildingManager manager =  service.getManagerByID(id);
        List<BuildingManagerResource> hateos = new ArrayList<>();

        BuildingManagerResource res = new BuildingManagerResource
                .Builder(manager.getManager_name())
                .resID(manager.getManager_id())
                .buildings(manager.getBuildings())
                .build();
        Link buildings = new
                Link("http://localhost:8080/manager/"+res.getResID())
                .withRel("buildings");

        res.add(buildings);
        hateos.add(res);
        return  hateos;
    }

    @RequestMapping(value = "/managernames", method = RequestMethod.GET)
    public List<BuildingManagerResource> getManagerByName(
            @RequestParam(value =  "name", defaultValue = "lil Wayne") String name){

        BuildingManager manager =  service.getManagerByName(name);
        List<BuildingManagerResource> hateos = new ArrayList<>();

        BuildingManagerResource res = new BuildingManagerResource
                .Builder(manager.getManager_name())
                .resID(manager.getManager_id())
                .buildings(manager.getBuildings())
                .build();
        Link buildings = new
                Link("http://localhost:8080/manager/"+res.getResID())
                .withRel("buildings");
        res.add(buildings);
        hateos.add(res);
        return  hateos;
    }


    @RequestMapping(value = "/newmanager", method = RequestMethod.POST)
    public void AddManager(
            @RequestParam(value =  "newManager") BuildingManagerResource newManager){
            service.addManager(newManager);
    }
}
