package buildingmaintenance.service.Impl;

import buildingmaintenance.domain.Tenant;
import buildingmaintenance.repository.TenantRepository;
import buildingmaintenance.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
@Service
public class TenantServiceImpl implements TenantService {
    @Autowired
    TenantRepository repository;

    @Override
    public List<Tenant> getAllTenants() {
        List<Tenant> tenants = new ArrayList<>();
        Iterable<Tenant> values = repository.findAll();
        for (Tenant value : values) {
            tenants.add(value);
        }
        return tenants;
    }

    @Override
    public Tenant getTenantByID(Long id) {
        if(repository.findOne(id) == null)
            return null;
        else
            return repository.findOne(id);
    }

    @Override
    public Tenant getTenantByName(String name) {
        List<Tenant> tenants = new ArrayList<>();
        Tenant result = null;
        tenants = getAllTenants();
        for(Tenant thetenant: tenants)
        {
            if(thetenant.getTenant_name().contains(name))
            {
                result = thetenant;
            }
            break;
        }
        if(result == null)
            System.out.println("Found Nothing!");
        return result;
    }
}
