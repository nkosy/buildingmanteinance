package buildingmaintenance.api;

import buildingmaintenance.domain.Building;
import buildingmaintenance.model.BuildingResource;
import buildingmaintenance.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2015/09/13.
 */

@RestController
@RequestMapping("/api/**")
public class BuildingsPage {
    @Autowired
    private BuildingService service;

    @RequestMapping(value = "/buildings", method = RequestMethod.GET)
    public List<BuildingResource> getBuildings(){

        List<BuildingResource> hateos = new ArrayList<>();
        List<Building> buildings = service.getAllBuildings();

        for (Building building : buildings) {
            BuildingResource res = new BuildingResource
                    .Builder(building.getBuilding_name())
                    .res_id(building.getBuilding_id())
                    .jobs(building.getJobs())
                    .levels(building.getLevels())
                    .build();
            Link jobs = new
                    Link("http://localhost:8080/building/"+res.getResID())
                    .withRel("jobs");
            res.add(jobs);
            hateos.add(res);
        }
        return hateos;
    }
}
