package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.Facility;

import java.util.List;

/**
 *
 * @author Nkosy
 */
public class FacilityFactory {
    public static Facility createFacility(String facilityName,
            List items){
        Facility facility = new Facility.Builder(facilityName)
                .items(items)
                .build();
        return facility;
    }
}
