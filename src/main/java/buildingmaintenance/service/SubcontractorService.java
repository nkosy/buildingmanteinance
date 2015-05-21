package buildingmaintenance.service;

import buildingmaintenance.domain.Subcontractor;

import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
public interface SubcontractorService {
    List<Subcontractor> getAllSubcontractors();
    Subcontractor getSubcontractorByID(Long id);
    Subcontractor getSubcontractorByName(String name);
}
