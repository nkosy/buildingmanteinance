package buildingmaintenance.api;

import buildingmaintenance.domain.Building;
import buildingmaintenance.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nkosi on 2015/05/19.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private BuildingService service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "Welcome to the building manager app";
    }

    @RequestMapping(value = "/buildings",method = RequestMethod.GET)
    public  List<Building> getAllBuildings(){return service.getAllBuildings();}

}
