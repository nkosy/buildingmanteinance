package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.Tenant;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Nkosy
 */
public class TenantFactory {
    public static Tenant createTenant(String name,
                                      Map<String, List> values){
        Tenant tenant = new Tenant.Builder(name)
                .officeSpaces(values.get("officeSpaces"))
                .logs(values.get("logs"))
                .build();
        return tenant;
    }
}
