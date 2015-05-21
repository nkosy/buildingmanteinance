package buildingmaintenance.api;

import buildingmaintenance.domain.BuildingManager;
import buildingmaintenance.service.BuildingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<BuildingManager> getManagers(){
        return service.getAllManagers();
    }

    @RequestMapping(value = "/managerids", method = RequestMethod.GET)
    public BuildingManager getManagerByID(
            @RequestParam(value =  "id", defaultValue = "1") Long id){
        return service.getManagerByID(id);
    }

    @RequestMapping(value = "/managernames", method = RequestMethod.GET)
    public BuildingManager getManagerByName(
            @RequestParam(value =  "name", defaultValue = "lil Wayne") String name){
        return service.getManagerByName(name);
    }
}
