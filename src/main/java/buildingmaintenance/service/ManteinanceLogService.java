package buildingmaintenance.service;

import buildingmaintenance.domain.MantainanceLog;

import java.util.Date;
import java.util.List;

/**
 * Created by nkosi on 2015/05/20.
 */
public interface ManteinanceLogService {
    List<MantainanceLog> getAllLogs();
    MantainanceLog getLogyID(Long id);
    List<MantainanceLog> getLogsByDate(Date date);

}
