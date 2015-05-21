package buildingmaintenance.service.Impl;

import buildingmaintenance.domain.MantainanceLog;
import buildingmaintenance.repository.MainteinanceLogRepository;
import buildingmaintenance.service.ManteinanceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nkosi on 2015/05/20.
 */
@Service
public class ManteinanceLogServiceImpl implements ManteinanceLogService {
    @Autowired
    MainteinanceLogRepository repository;

    @Override
    public List<MantainanceLog> getAllLogs() {
        List<MantainanceLog> logs = new ArrayList<MantainanceLog>();
        Iterable<MantainanceLog> values = repository.findAll();
        for (MantainanceLog value : values) {
            logs.add(value);
        }
        return logs;
    }

    @Override
    public MantainanceLog getLogyID(Long id) {
        if(repository.findOne(id) == null)
            return null;
        else
            return repository.findOne(id);
    }

    @Override
    public List<MantainanceLog> getLogsByDate(Date date) {
        List<MantainanceLog> logs = new ArrayList<>();
        List<MantainanceLog> result = new ArrayList<>();
        logs = getAllLogs();
        for(MantainanceLog thelog: logs)
        {
            if(thelog.getLogDate() == date)
            {
                result.add(thelog);
            }
        }
        if(result == null)
            System.out.println("Found Nothing!");
        return result;
    }
}
