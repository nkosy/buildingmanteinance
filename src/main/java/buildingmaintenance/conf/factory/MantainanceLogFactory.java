package buildingmaintenance.conf.factory;


import buildingmaintenance.domain.MantainanceLog;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nkosy
 */
public class MantainanceLogFactory {

    public static MantainanceLog createMantainanceLog(String description,
                                                      Date logDate, List items) {
        MantainanceLog log = new MantainanceLog.Builder(description)
                .logDate(logDate)
                .items(items)
                .build();
        return log;
    }
}
