package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.OfficeSpace;

import java.util.List;

/**
 *
 * @author Nkosy
 */
public class OfficeSpaceFactory {
    public static OfficeSpace createOfficeSpace(int officespace_no,
            List facilities){
        OfficeSpace officeSpace = new OfficeSpace.Builder(officespace_no)
                .facilities(facilities)
                .build();
        return officeSpace;
    }
}
