package buildingmaintenance.service.Impl;

import buildingmaintenance.domain.Subcontractor;
import buildingmaintenance.repository.SubcontractorRepository;
import buildingmaintenance.service.SubcontractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
@Service
public class SubcontractorServiceImpl implements SubcontractorService {
    @Autowired
    SubcontractorRepository repository;

    @Override
    public List<Subcontractor> getAllSubcontractors() {
        List<Subcontractor> subcontractors = new ArrayList<>();
        Iterable<Subcontractor> values = repository.findAll();
        for (Subcontractor value : values) {
            subcontractors.add(value);
        }
        return subcontractors;
    }

    @Override
    public Subcontractor getSubcontractorByID(Long id) {
        if(repository.findOne(id) == null)
            return null;
        else
            return repository.findOne(id);
    }

    @Override
    public Subcontractor getSubcontractorByName(String name) {
        List<Subcontractor> subcontractors = new ArrayList<>();
        Subcontractor result = null;
        subcontractors = getAllSubcontractors();
        for(Subcontractor thecontractor: subcontractors)
        {
            if(thecontractor.getSubcontractor_name().contains(name))
            {
                result = thecontractor;
            }
            break;
        }
        if(result == null)
            System.out.println("Found Nothing!");
        return result;
    }
}
