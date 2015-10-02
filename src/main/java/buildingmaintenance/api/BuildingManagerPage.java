package buildingmaintenance.api;

import buildingmaintenance.domain.BuildingManager;
import buildingmaintenance.model.BuildingManagerResource;
import buildingmaintenance.service.BuildingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
        List<BuildingManager> managers = service.findAll();

        for (BuildingManager manager : managers) {
            BuildingManagerResource res = new BuildingManagerResource
                    .Builder(manager.getManager_name())
                    .resID(manager.getManager_id())
                    .buildings(manager.getBuildings())
                    .build();
            Link buildings = new
                    Link("http://buildingmanteinance-nkosi.rhcloud.com/api/manager/"+res.getResID())
                    .withRel("buildings");

            res.add(buildings);
            hateos.add(res);
        }
        return hateos;
    }

    @RequestMapping(value = "/managerids", method = RequestMethod.GET)
    public List<BuildingManagerResource>  getManagerByID(
            @RequestParam(value =  "id", defaultValue = "1") Long id){

        BuildingManager manager =  service.findById(id);
        List<BuildingManagerResource> hateos = new ArrayList<>();

        BuildingManagerResource res = new BuildingManagerResource
                .Builder(manager.getManager_name())
                .resID(manager.getManager_id())
                .buildings(manager.getBuildings())
                .build();
        Link buildings = new
                Link("http://buildingmanteinance-nkosi.rhcloud.com/api/manager/"+res.getResID())
                .withRel("buildings");

        res.add(buildings);
        hateos.add(res);
        return  hateos;
    }

    @RequestMapping(value = "/managernames", method = RequestMethod.GET)
    public List<BuildingManagerResource> getManagerByName(
            @RequestParam(value =  "name", defaultValue = "lil Wayne") String name){

        BuildingManager manager =  service.findByName(name);
        List<BuildingManagerResource> hateos = new ArrayList<>();

        BuildingManagerResource res = new BuildingManagerResource
                .Builder(manager.getManager_name())
                .resID(manager.getManager_id())
                .buildings(manager.getBuildings())
                .build();
        Link buildings = new
                Link("http://buildingmanteinance-nkosi.rhcloud.com/api/manager/"+res.getResID())
                .withRel("buildings");
        res.add(buildings);
        hateos.add(res);
        return  hateos;
    }

    @RequestMapping(value = "/buildingmanager/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createManager(@RequestBody BuildingManager manager, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Manager " + manager.getManager_name());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(manager);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/managerids/{id}").buildAndExpand(manager.getManager_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
