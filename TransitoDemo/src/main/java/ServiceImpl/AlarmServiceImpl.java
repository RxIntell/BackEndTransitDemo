package ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Entity.Alarm;
import Repository.AlarmRepository;
import service.AlarmService;

import java.util.Date;
import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmRepository alarmRepository;

    @Override
    public Alarm createAlarm(int idTunnel, int alarmType, int severity) {
        Alarm alarm = new Alarm();
        alarm.setIdTunnel(idTunnel);
        alarm.setAlarmType(alarmType);
        alarm.setSeverity(severity);
        alarm.setAlarmTimestamp(new Date()); // fecha actual
        return alarmRepository.save(alarm);
    }

    @Override
    public List<Alarm> getAlarmsBetweenDates(Date startDate, Date endDate) {
        return alarmRepository.findByAlarmTimestampBetween(startDate, endDate);
    }

    @Override
    public List<Alarm> getAlarmsBySeverity(int severity) {
        return alarmRepository.findBySeverity(severity);
    }

    @Override
    public List<Alarm> getAlarmsBySeverityAndBetweenDates(int severity, Date startDate, Date endDate) {
        return alarmRepository.findBySeverityAndAlarmTimestampBetween(severity, startDate, endDate);
    }

    @Override
    public List<Alarm> getAlarmsBySeverityAndTunnelIdAndBetweenDates(int severity, int tunnelId, Date startDate, Date endDate) {
        return alarmRepository.findBySeverityAndIdTunnelAndAlarmTimestampBetween(severity, tunnelId, startDate, endDate);
    }

    @Override
    public List<Alarm> getAlarmsBySeverityAndTypeAndBetweenDates(int severity, String alarmType, Date startDate, Date endDate) {
        return alarmRepository.findBySeverityAndAlarmTypeAndAlarmTimestampBetween(severity, alarmType, startDate, endDate);
    }

    @Override
    public List<Alarm> getAlarmsByTypeAndBetweenDates(String alarmType, Date startDate, Date endDate) {
        return alarmRepository.findByAlarmTypeAndAlarmTimestampBetween(alarmType, startDate, endDate);
    }

    @Override
    public List<Alarm> getAlarmsByTunnelIdAndBetweenDates(int tunnelId, Date startDate, Date endDate) {
        return alarmRepository.findByIdTunnelAndAlarmTimestampBetween(tunnelId, startDate, endDate);
    }

    @Override
    public List<Alarm> getAlarmsBySeverityAndTunnelIdAndTypeAndBetweenDates(int severity, int tunnelId, String alarmType, Date startDate, Date endDate) {
        return alarmRepository.findBySeverityAndIdTunnelAndAlarmTypeAndAlarmTimestampBetween(severity, tunnelId, alarmType, startDate, endDate);
    }
    
    @Override
    public List<Alarm> getAlarmsByCriteria(Date startDate, Date endDate, Integer severity, Integer tunnelId) {
        if (severity != null && tunnelId != null) {
            return alarmRepository.findBySeverityAndIdTunnelAndAlarmTimestampBetween(severity, tunnelId, startDate, endDate);
        } else if (severity != null) {
            return alarmRepository.findBySeverityAndAlarmTimestampBetween(severity, startDate, endDate);
        } else if (tunnelId != null) {
            return alarmRepository.findByIdTunnelAndAlarmTimestampBetween(tunnelId, startDate, endDate);
        } else {
            return alarmRepository.findByAlarmTimestampBetween(startDate, endDate);
        }
    }
}
