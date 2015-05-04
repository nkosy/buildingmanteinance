package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.Tenant;

import java.util.List;

/**
 *
 * @author Nkosy
 */
public class TenantFactory {
    public static Tenant createTenant(String name,
            List officeSpace){
        Tenant tenant = new Tenant.Builder(name)
                .officeSpaces(officeSpace)
                .build();
        return tenant;
    }
}
