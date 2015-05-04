package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.MantainanceLog;

import java.util.List;

/**
 *
 * @author Nkosy
 */
public class MantainanceLogFactory {

    public static MantainanceLog createMantainanceLog(String description,
            List items) {
        MantainanceLog log = new MantainanceLog.Builder(description)
                .items(items)
                .build();
        return log;
    }
}
