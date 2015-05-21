package buildingmaintenance.service;

import buildingmaintenance.domain.Tenant;

import java.util.Date;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
public interface TenantService {
    List<Tenant> getAllTenants();
    Tenant getTenantByID(Long id);
    Tenant getTenantByName(String name);
}
